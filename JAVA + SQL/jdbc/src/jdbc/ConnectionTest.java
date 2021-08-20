package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args)  {
		try {
		//jdbc driver 호출
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//DB연결
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("연결 성공");
		
		//sql전공 - 결과 이용
		
		//DB연결 해제
		con.close();
		System.out.println("연결 해제성공");
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스 위치 확인하세요");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
