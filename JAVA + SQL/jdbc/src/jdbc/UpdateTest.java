package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args)  {
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("연결 성공");
		
		//6명 사원 employees 테이블 복사-급여-달러-
		//String sql = "update emp set title = '미정' where salary <= 30000";
		
		//select title from emp where salary <= 30000;
		//키보드 입력
		/*
		 * 직급 : 미정
		 * 급여 : 10
		 * emp 테이블에서 title 미정인 직원의 급여를 현재 급여의 10배로 인상
		 */
		//업데이트 sql작성
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("직급 : ");
		String str1 = s.next();
		System.out.print("급여 : ");
		int str2 = s.nextInt();
		
		String sql = "update emp set salary = salary*" + str2 + " where title = '" + str1 + "'";
		
		Statement st = con.createStatement();
		int row = st.executeUpdate(sql);
		System.out.println(row + " 개의 행이 수정되었습니다.");
		
		
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
