package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args) {
		Connection con = null;
		try {
		//0. oracle jdbc driver 호출 - ojdbc6.jar 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//1.  db 연결(db종류, ip, port, 계정, 암호.)
		con = DriverManager.getConnection
		("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("연결성공");

		//emp 테이블 - 400 김사장 사장 30 1000000 sysdate 레코드 insert
		// sql - db 인식 언어 . 자바 sql 문자열 형식
		//String sql = "insert into emp values(400 , '김사장',  '사장', 30 ,1000000 , sysdate )";
		
		//명령행 매개변수 - RUN CONFIGURATIONS-ARGUMENTS-PRORAM ARGUMENT - ...
		//401         한부장       부장                 10    900000 --> 5개 입력 , + SYSDATE --> EMP  테이블로 저장
		//args[0] args[1] args[2]  args[3]  args[4]
		//String sql = "insert into emp values(" + args[0] + ", '" + args[1] + "',  '" 
		//+ args[2] + "', " + args[3]  + "," + args[4] + ", sysdate )";
		
		String sql = "insert into emp"
		+" select employee_id, first_name, job_id, department_id, salary, hire_date"
		+" from employees where employee_id > 200";
		

		
		// sql 저장 - db 전송 역할
		Statement st = con.createStatement();
		int row = st.executeUpdate(sql);
		System.out.println(row + " 개의 행 삽입되었습니다.");
		
		//4. db 연결 해제 - 파일 close tcp소켓 close finally
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
