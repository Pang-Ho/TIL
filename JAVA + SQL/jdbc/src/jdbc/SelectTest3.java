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
		System.out.println("���� ����");
		
		
		/*
		 * Ű����� �Է�
		 * ���� : �븮
		 * �Ի�� : 06
		 * emp ���̺��� title �븮 �����ϰ� �Ի�� 06���� ��� �̸� ���� �Ի��� ��ȸ
		 */
		
		Scanner s = new Scanner(System.in);
		System.out.print("���� : ");
		String str1 = s.next();
		str1 = "'%" + str1 +"%'";
		System.out.print("�Ի�� : ");
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
		
		//��ü ����� ��ȸ - select count(*) from emp
		Statement st1 = con.createStatement();
		ResultSet rs1 = st1.executeQuery("select count(*) as cnt from emp"); //1���� �ٷ� ������ ��ġ��
		//rs1.next();�� ���� 1������ �̵��ϴ°���  while�� �Ƚᵵ�Ǵ°� ������ 1�ุ �������ϱ�!
		
		rs1.next(); //1������ �̵�
		//int count = rs.getInt("count(*)");
		int cnt = rs1.getInt("cnt");
		System.out.println("��ü ����� : " + cnt);
				
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
