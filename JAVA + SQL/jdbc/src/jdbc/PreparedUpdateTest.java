package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedUpdateTest {

	public static void main(String[] args)  {
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		con.setAutoCommit(false);
		System.out.println("sql 트랜잭션 커밋상태 = " + con.getAutoCommit());
		
		Scanner s = new Scanner(System.in);
		
		//직급 미정 / 급여 
		System.out.print("직급 : ");
		String title = s.next();
		System.out.print("급여 : ");
		int salary = s.nextInt();
		
		String sql = "update emp set salary = salary* ? where title = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		//입력 파라미터 값 설정
		st.setInt(1, salary);
		st.setNString(2, title);
		
		con.rollback(); // 명시적으로 롤백 하면 롤백함
		
		int row = st.executeUpdate();
		System.out.println(row + " 개의 행이 수정되었습니다.");
		
		
		//DB연결 해제
		con.close(); //이넘이 자동으로 커밋한거임
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
