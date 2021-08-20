package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedInsertTest {

	public static void main(String[] args)  {
		Connection con = null;
		try {
		//jdbc driver 호출
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//DB연결
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("연결 성공");
		
		//명령행매개변수 402 한신입  20 700000 신입사원 / args + sysdate => emp 테이블로 저장
//		String sql = "insert into emp values(" + args[0] + ", '" + args[1] + "' , " + args[2] + "," +
//												args[3] + ", '" + args[4] + "' , sysdate)";
		String sql = "insert into emp values(?,?,?,?,?,sysdate)";
		//sql 저장 - db 전송 역할
		PreparedStatement st = con.prepareStatement(sql); //구문분석 - 컴파일 - 저장 - 대기중
		//sql 입력 파라미터 값 설정
		st.setInt(1, Integer.parseInt(args[0]));
		st.setString(2, args[1]);
		st.setInt(3, Integer.parseInt(args[2]));
		st.setDouble(4, Double.parseDouble(args[3]));
		st.setString(5, args[4]);
		
		int row = st.executeUpdate(); // 실행
		System.out.println(row + " 개의 행 삽입되었습니다.");
		
		
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
			catch ( SQLException e) {	
				e.printStackTrace();
			}
		}
	}

}
