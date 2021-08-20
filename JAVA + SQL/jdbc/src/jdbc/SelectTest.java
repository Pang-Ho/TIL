package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest {

	public static void main(String[] args)  {
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("연결 성공");
		
		String sql = "select id, name, title, dept_id, salary, "
				+ "to_char(hiredate, 'yyyy/mm/dd hh24:mi:ss') hiredate2 from emp"; //전체 레코드의 전체 컬럼 조회
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql); 
		//System.out.println(rs); //객체.toString 결과 oracle.jdbc.driver.OracleResultSetImpl@cad498c
								//그럼 우째? 오버라이딩도 못하잖아 
								//Result의 메소드를 얻을 거임
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString("name");
			String title = rs.getString("title");
			int dept_id = rs.getInt("dept_id");
			double salary = rs.getDouble("salary");
			//Date hiredate = rs.getDate("hiredate"); 형식 바꿀라면 밑에 처럼
			String hiredate = rs.getString("hiredate2");
			System.out.println(id + "\t" + name + "\t" + title + "\t" + dept_id + "\t" + salary + "\t" + hiredate);
		}
		
		
		con.close();
		System.out.println("연결 해제성공");
		
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스 위치 확인하세요");
		}
		catch (SQLException e) { //테이블명 다름, 띄어쓰기 잘못 써서 문법 잘못됨, 
			e.printStackTrace();
		}
		finally {
			try {
				if(con.isClosed() == false) {
					con.close();
					System.out.println("finally 연결 해제 성공");
				}
			}
			catch ( SQLException e_) {	
			}
		}
	}

}
