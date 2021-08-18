package test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookTest {

	public static void main(String[] args) {
		
	}
	public void insertStudent(BookDTO book) {
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		
		String sql = "insert into book values"+
				" select employee_id, first_name, department_id, salary, job_id, hire_date" +
				" from employees where employee_id > 200";
		
		Statement st = con.createStatement();
		int row = st.executeUpdate(sql);
		
		con.close();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con.isClosed() == false) {
					con.close();
				}
			}
			catch ( SQLException e) {	
				e.printStackTrace();
			}
		}

	}
	public void printAllBooks() {
		System.out.println("************************* 도서 목록 ************************");
		BookDTO dto1 = new BookDTO(21424, "Java Basic", "김하나", "Jaen.kr", 15000, "Java 기본 문법");
		BookDTO dto2 = new BookDTO(33455, "JDBC Pro", "김철수", "Jaen.kr", 23000, "");
		BookDTO dto3 = new BookDTO(55355, "Servlet/JSP", "박자바", "Jaen.kr", 41000, "Model2 기반");
		BookDTO dto4 = new BookDTO(35332, "Android App", "홍길동", "Jaen.kr", 25000, "Lighweight Framework");
		BookDTO dto5 = new BookDTO(35355, "OOAD분석,설계", "소나무", "Jaen.kr", 30000, "");
		Connection con = null;
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("연결 성공");
		
		String sql = "select isbs, title, author, publisher, price, desc, to_char(publishdate, 'yy.mm') from employees";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql); 

		while(rs.next()) {
			int isbn = rs.getInt(1);
			String title = rs.getString("name");
			String author = rs.getString("title");
			String publisher = rs.getInt("dept_id");
			int price = rs.getDouble("salary");
			String hiredate = rs.getString("hiredate2");
			System.out.println(id + "\t" + name + "\t" + title + "\t" + dept_id + "\t" + salary + "\t" + hiredate);
		}
		
		int isbn, String title, String author, String publisher, int price, String desc
		con.close();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con.isClosed() == false) {
					con.close();
				}
			}
			catch ( SQLException e_) {	
			}
		}
	}
}
