package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest {

	public static void main(String[] args)  {
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("���� ����");
		
		String sql = "select id, name, title, dept_id, salary, "
				+ "to_char(hiredate, 'yyyy/mm/dd hh24:mi:ss') hiredate2 from emp"; //��ü ���ڵ��� ��ü �÷� ��ȸ
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql); 
		//System.out.println(rs); //��ü.toString ��� oracle.jdbc.driver.OracleResultSetImpl@cad498c
								//�׷� ��°? �������̵��� �����ݾ� 
								//Result�� �޼ҵ带 ���� ����
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString("name");
			String title = rs.getString("title");
			int dept_id = rs.getInt("dept_id");
			double salary = rs.getDouble("salary");
			//Date hiredate = rs.getDate("hiredate"); ���� �ٲܶ�� �ؿ� ó��
			String hiredate = rs.getString("hiredate2");
			System.out.println(id + "\t" + name + "\t" + title + "\t" + dept_id + "\t" + salary + "\t" + hiredate);
		}
		
		
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
	}

}
