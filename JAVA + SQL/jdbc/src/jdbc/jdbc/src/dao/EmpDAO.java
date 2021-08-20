package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.EmpVO;

public class EmpDAO {
	//저장 / 조회 / 수정 / 삭제 완성 
	//create / read / update / delete 기본 포함 -  CRUD
	public int insertEmp(EmpVO vo){
		int rows = 0;
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection
		("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("연결성공");

		String sql = "insert into emp values(" + vo.getId() + " , '" + vo.getName() + "', '" 
		+ vo.getTitle() + "' , " + vo.getDept_id() + " ," +  vo.getSalary() + ", sysdate)";// 
		
		Statement st = con.createStatement();
		rows = st.executeUpdate(sql);

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
		
		
		return rows;
	}

	
	public ArrayList<EmpVO> getEmp(){
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection
		("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("연결성공");

		String sql = "select id, name, title, dept_id, to_char(salary, '0000000000') salary, "
		+ "to_char(hiredate, 'yyyy/mm/dd hh24:mi:ss') hiredate2 from emp";// 전체레코드의 전체컬럼들 조회
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String db_title = rs.getString("title");
			int dept_id = rs.getInt("Dept_id");
			double salary = rs.getDouble("salary");
			String hiredate = rs.getString("hiredate2");
			EmpVO vo = new EmpVO(id, name, db_title, dept_id, salary, hiredate);//1개레코드
			list.add(vo);
		}

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
		
		
		return list;
	}
}
