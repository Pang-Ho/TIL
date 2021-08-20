package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		try {
		//0. oracle jdbc driver 호출 - ojdbc6.jar 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//1.  db 연결(db종류, ip, port, 계정, 암호.)
		Connection con = DriverManager.getConnection
		("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("연결성공");
		//sql 전송 - 결과 이용
		//4. db 연결 해제
		con.close();
		System.out.println("연결해제성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 클래스 위치 확인하세요");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}//main end

}
