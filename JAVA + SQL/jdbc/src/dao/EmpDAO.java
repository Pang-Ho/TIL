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
	//create / read / update / delete 기본 포함
	public int insertEmp(EmpVO empVO) {
		int rows = 0;
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("연결 성공");
		
		
		String sql = "insert into emp values(" + empVO.getId() +", '" + empVO.getName() + "', " + 
											empVO.getDept_id() +", " + empVO.getSalary() + ", '" + empVO.getTitle() + "', sysdate)";
		
		Statement st = con.createStatement();
		rows = st.executeUpdate(sql);
		
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
		return rows;
	}
	public ArrayList<EmpVO> getEmp(){
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("연결 성공");
		
		String sql = "select id, title, name, dept_id, to_char(salary, '0000000000') salary, "
				+ "to_char(hiredate, 'yyyy/mm/dd hh24:mi:ss') hiredate2"
				+ " from emp";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String title = rs.getString("title");
			int dept_id = rs.getInt("dept_id");
			double salary = rs.getDouble("salary");
			String hiredate = rs.getString("hiredate2");
			EmpVO vo = new EmpVO(id, name, title, dept_id, salary, hiredate); //1개 레코드
			list.add(vo);
		}
		//list에는 모든 emp테이블 레코드가 EmpVO객체로 바뀌어서 저장됨
		
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
		
		return list;
	}
}
