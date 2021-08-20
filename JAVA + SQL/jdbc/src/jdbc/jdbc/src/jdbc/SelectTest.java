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
		System.out.println("���Ἲ��");

		//String sql = "select id, name, title, dept_id, to_char(salary, '0000000000') salary, "
		//		+ "to_char(hiredate, 'yyyy/mm/dd hh24:mi:ss') hiredate2 from emp";// ��ü���ڵ��� ��ü�÷��� ��ȸ
		
		/*  Ű����� �Է�
		���� : ��
		�Ի�� : 06
		
		emp  ���̺��� title  �븮 �����ϰ� �Ի���� 06�� ����� �̸�, ����, �Ի��� ��ȸ sql
		*/
		Scanner key = new Scanner(System.in);
		System.out.print("���� : ");
		String title = key.next(); // �븮 --> %�븮%
		title = "%" + title + "%";
		
		System.out.print("�Ի�� : ");
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
		//��ü ����� ��ȸ - select count(*) from emp
		Statement st1 = con.createStatement();
		ResultSet rs1 = st1.executeQuery("select count(*) as cnt from emp");//1��
		rs1.next();// 1�� �̵�
		int cnt = rs1.getInt("cnt");
		System.out.println("��ü ����� : " + cnt);
		
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
	}//main end
}
