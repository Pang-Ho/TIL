package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest {

	public static void main(String[] args) {
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection
		("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("연결성공");

		//String sql = "select id, name, title, dept_id, to_char(salary, '0000000000') salary, "
		//		+ "to_char(hiredate, 'yyyy/mm/dd hh24:mi:ss') hiredate2 from emp";// 전체레코드의 전체컬럼들 조회
		
		/*  키보드로 입력
		직급 : 정
		입사월 : 06
		
		emp  테이블에서 title  대리 포함하고 입사월은 06월 사원의 이름, 직급, 입사일 조회 sql
		*/
		Scanner key = new Scanner(System.in);
		System.out.print("직급 : ");
		String title = key.next(); // 대리 --> %대리%
		title = "%" + title + "%";
		
		System.out.print("입사월 : ");
		String month = key.next();	// 06 --> ___06%
		month = "___" + month + "%";
		
		String sql = "select name, title, hiredate from emp "
				+ " where title like '"  + title + "' and hiredate like '" + month + "'";
		// instr(hiredate, '06', 4) = 4
		//substr(hiredate, 4, 2) = '06'
		//to_char(hiredate, 'mm') = '06'
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {// no rows selected
			String name = rs.getString("name");
			String db_title = rs.getString("title");
			java.sql.Date hiredate = rs.getDate("hiredate");
			System.out.println(name + "\t" + db_title + "\t" + hiredate);
		}
//=====================================
		//전체 사원수 조회 - select count(*) from emp
		Statement st1 = con.createStatement();
		ResultSet rs1 = st1.executeQuery("select count(*) as cnt from emp");//1행
		rs1.next();// 1행 이동
		int cnt = rs1.getInt("cnt");
		System.out.println("전체 사원수 : " + cnt);
		
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
