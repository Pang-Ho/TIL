package test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookTest {

	public static void main(String[] args) {
		BookDTO book1 = new BookDTO(21424, "Java Basic", "���ϳ�", "Jaen.kr", 15000, "Java �⺻ ����");
		BookDTO book2 = new BookDTO(33455, "JDBC Pro", "��ö��", "Jaen.kr", 23000, " ");
		BookDTO book3 = new BookDTO(55355, "Servlet/JSP", "���ڹ�", "Jaen.kr", 41000, "Model2 ���");
		BookDTO book4 = new BookDTO(35332, "Android App", "ȫ�浿", "Jaen.kr", 25000, "Lighweight Framework");
		BookDTO book5 = new BookDTO(35355, "OOAD�м�,����", "�ҳ���", "Jaen.kr", 30000, " ");
		
		System.out.println("************************* ���� ��� ************************");
		BookTest boo = new BookTest();
		boo.insertStudent(book1);
		boo.insertStudent(book2);
		boo.insertStudent(book3);
		boo.insertStudent(book4);
		boo.insertStudent(book5);
		
		boo.printAllBooks();
	}
	public void insertStudent(BookDTO book) {
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		
		
		String sql = "insert into book values(" + book.getIsbn() + ", '" + book.getTitle() + "', '" +
												book.getAuthor() + "', '"+ book.getPubblisher() + "', "+ 
												book.getPrice() +", '"+ book.getDetail() + "', '21.08')"; 
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
		Connection con = null;
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("���� ����");
		
		String sql = "select isbn, title, author, publisher, price, detail from book";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql); 

		while(rs.next()) {
			int isbn = rs.getInt("isbn");
			String title = rs.getString("title");
			String author = rs.getString("author");
			String publisher = rs.getString("publisher");
			int price = rs.getInt("price");
			String detail = rs.getString("detail");
			BookDTO dto = new BookDTO(isbn, title, author, publisher, price, detail);
			System.out.println(dto);
		}
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
