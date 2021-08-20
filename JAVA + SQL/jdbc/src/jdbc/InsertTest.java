package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args)  {
		Connection con = null;
		try {
		//jdbc driver 호출
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//DB연결
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("연결 성공");
		
		
		//emp테이블 - 400 김사장  30 100000 사장 sysdate 레코드 insert
		//String sql = "insert into emp values(400, '김사장', 30, 1000000, '사장', sysdate)";
		
		//명령행매개변수 401 한부장 10 900000 부장 / args + sysdate => emp 테이블로 저장
		//String sql = "insert into emp values(" + args[0] + ", '" + args[1] + "' , " + args[2] + "," +
			//									args[3] + ", '" + args[4] + "' , sysdate)";
		
		String sql = "insert into emp"+
					" select employee_id, first_name, department_id, salary, job_id, hire_date" +
					" from employees where employee_id > 200";
		
		//sql 저장 - db 전송 역할
		Statement st = con.createStatement();
		int row = st.executeUpdate(sql);
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
