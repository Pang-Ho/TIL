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
	//create / read / update / delete �⺻ ����
	public int insertEmp(EmpVO empVO) {
		int rows = 0;
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("���� ����");
		
		
		String sql = "insert into emp values(" + empVO.getId() +", '" + empVO.getName() + "', " + 
											empVO.getDept_id() +", " + empVO.getSalary() + ", '" + empVO.getTitle() + "', sysdate)";
		
		Statement st = con.createStatement();
		rows = st.executeUpdate(sql);
		
		con.close();
		System.out.println("���� ��������");
		
		}
		catch (ClassNotFoundException e) {
			System.out.println("����̹� Ŭ���� ��ġ Ȯ���ϼ���");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con.isClosed() == false) {
					con.close();
					System.out.println("finally ���� ���� ����");
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
		System.out.println("���� ����");
		
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
			EmpVO vo = new EmpVO(id, name, title, dept_id, salary, hiredate); //1�� ���ڵ�
			list.add(vo);
		}
		//list���� ��� emp���̺� ���ڵ尡 EmpVO��ü�� �ٲ� �����
		
		con.close();
		System.out.println("���� ��������");
		
		}
		catch (ClassNotFoundException e) {
			System.out.println("����̹� Ŭ���� ��ġ Ȯ���ϼ���");
		}
		catch (SQLException e) { //���̺�� �ٸ�, ���� �߸� �Ἥ ���� �߸���, 
			e.printStackTrace();
		}
		finally {
			try {
				if(con.isClosed() == false) {
					con.close();
					System.out.println("finally ���� ���� ����");
				}
			}
			catch ( SQLException e_) {	
			}
		}
		
		return list;
	}
}
