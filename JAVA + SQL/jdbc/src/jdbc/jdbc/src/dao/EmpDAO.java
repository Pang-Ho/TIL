package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.EmpVO;

public class EmpDAO {
	//���� / ��ȸ / ���� / ���� �ϼ� 
	//create / read / update / delete �⺻ ���� -  CRUD
	public int insertEmp(EmpVO vo){
		int rows = 0;
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection
		("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("���Ἲ��");

		String sql = "insert into emp values(" + vo.getId() + " , '" + vo.getName() + "', '" 
		+ vo.getTitle() + "' , " + vo.getDept_id() + " ," +  vo.getSalary() + ", sysdate)";// 
		
		Statement st = con.createStatement();
		rows = st.executeUpdate(sql);

		con.close();
		System.out.println("������������");
		}catch(ClassNotFoundException e) {
			System.out.println("����̹� Ŭ���� ��ġ Ȯ���ϼ���");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(con.isClosed() == false) {
				con.close();
				System.out.println("finally������������");
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
		System.out.println("���Ἲ��");

		String sql = "select id, name, title, dept_id, to_char(salary, '0000000000') salary, "
		+ "to_char(hiredate, 'yyyy/mm/dd hh24:mi:ss') hiredate2 from emp";// ��ü���ڵ��� ��ü�÷��� ��ȸ
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String db_title = rs.getString("title");
			int dept_id = rs.getInt("Dept_id");
			double salary = rs.getDouble("salary");
			String hiredate = rs.getString("hiredate2");
			EmpVO vo = new EmpVO(id, name, db_title, dept_id, salary, hiredate);//1�����ڵ�
			list.add(vo);
		}

		con.close();
		System.out.println("������������");
		}catch(ClassNotFoundException e) {
			System.out.println("����̹� Ŭ���� ��ġ Ȯ���ϼ���");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(con.isClosed() == false) {
				con.close();
				System.out.println("finally������������");
			}//if end
			}//try end
			catch(SQLException e) { }
		}//finally		
		
		
		return list;
	}
}
