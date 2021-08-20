package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest3 {

	public static void main(String[] args)  {
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("연결 성공");
		
		
		/*
		 * 키보드로 입력
		 * 직급 : 대리
		 * 입사월 : 06
		 * emp 테이블에서 title 대리 포함하고 입사월 06월의 사원 이름 직급 입사일 조회
		 */
		
		Scanner s = new Scanner(System.in);
		System.out.print("직급 : ");
		String str1 = s.next();
		str1 = "'%" + str1 +"%'";
		System.out.print("입사월 : ");
		String str2 = s.next();
		
		
		String sql = "select title, name, dept_id, to_char(hiredate, 'yyyy/mm/dd hh24:mi:ss') hiredate2"
				+ " from emp where hiredate like '%" + str2 + "%' and title like " + str1 ;
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			String name = rs.getString("name");
			String title = rs.getString("title");
			int dept_id = rs.getInt("dept_id");
			String hiredate = rs.getString("hiredate2");
			System.out.println(name + "\t" + title + "\t" + dept_id + "\t" + hiredate);
		}
		
		//전체 사원수 조회 - select count(*) from emp
		Statement st1 = con.createStatement();
		ResultSet rs1 = st1.executeQuery("select count(*) as cnt from emp"); //1행의 바로 이전에 위치함
		//rs1.next();를 통해 1행으로 이동하는거임  while을 안써도되는게 위에가 1행만 가져오니까!
		
		rs1.next(); //1행으로 이동
		//int count = rs.getInt("count(*)");
		int cnt = rs1.getInt("cnt");
		System.out.println("전체 사원수 : " + cnt);
				
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
