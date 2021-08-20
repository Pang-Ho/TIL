package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) {
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection
		("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("연결성공");

		//6명 사원 employees  테이블 복사-급여-달러- 
		//String sql = "update emp set title = '미정' where salary <= 30000";
		
		//  1. 키보드 입력
		/*
		int result = System.in.read();미정
		급여 : 10
		===> emp  테이블에서  title '미정'인 직원의 급여를 현재 급여 10 배 인상
		2. update  sql 작성
		
		 */
		Scanner key = new Scanner(System.in);
		System.out.print("직급 : ");
		String title = key.next();
		System.out.print("급여 : ");
		int salary = key.nextInt();	
		
		String sql = "update emp set salary = salary * " + salary + " where title='" + title + "'";
		
		// 삭제 -- "delete emp where title = '" +  title + "'"
		
		Statement st = con.createStatement();
		int row = st.executeUpdate(sql);
		System.out.println(row + " 개의 행  수정되었습니다.");
		
		con.close();
		System.out.println("연결해제성공");
		
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 클래스 위치 확인하세요");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(con.isClosed() == false) {
				con.close();
				System.out.println("finally연결해제성공");
			}//if end
			}//try end
			catch(SQLException e) { }
		}//finally
	}//main end
}
