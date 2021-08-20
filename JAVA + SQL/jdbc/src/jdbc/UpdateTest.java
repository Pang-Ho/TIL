package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args)  {
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("���� ����");
		
		//6�� ��� employees ���̺� ����-�޿�-�޷�-
		//String sql = "update emp set title = '����' where salary <= 30000";
		
		//select title from emp where salary <= 30000;
		//Ű���� �Է�
		/*
		 * ���� : ����
		 * �޿� : 10
		 * emp ���̺��� title ������ ������ �޿��� ���� �޿��� 10��� �λ�
		 */
		//������Ʈ sql�ۼ�
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("���� : ");
		String str1 = s.next();
		System.out.print("�޿� : ");
		int str2 = s.nextInt();
		
		String sql = "update emp set salary = salary*" + str2 + " where title = '" + str1 + "'";
		
		Statement st = con.createStatement();
		int row = st.executeUpdate(sql);
		System.out.println(row + " ���� ���� �����Ǿ����ϴ�.");
		
		
		//DB���� ����
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
	}

}
