package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) {
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection
		("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("���Ἲ��");

		//6�� ��� employees  ���̺� ����-�޿�-�޷�- 
		//String sql = "update emp set title = '����' where salary <= 30000";
		
		//  1. Ű���� �Է�
		/*
		int result = System.in.read();����
		�޿� : 10
		===> emp  ���̺���  title '����'�� ������ �޿��� ���� �޿� 10 �� �λ�
		2. update  sql �ۼ�
		
		 */
		Scanner key = new Scanner(System.in);
		System.out.print("���� : ");
		String title = key.next();
		System.out.print("�޿� : ");
		int salary = key.nextInt();	
		
		String sql = "update emp set salary = salary * " + salary + " where title='" + title + "'";
		
		// ���� -- "delete emp where title = '" +  title + "'"
		
		Statement st = con.createStatement();
		int row = st.executeUpdate(sql);
		System.out.println(row + " ���� ��  �����Ǿ����ϴ�.");
		
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
