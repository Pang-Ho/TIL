package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedUpdateTest {

	public static void main(String[] args)  {
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		con.setAutoCommit(false);
		System.out.println("sql Ʈ����� Ŀ�Ի��� = " + con.getAutoCommit());
		
		Scanner s = new Scanner(System.in);
		
		//���� ���� / �޿� 
		System.out.print("���� : ");
		String title = s.next();
		System.out.print("�޿� : ");
		int salary = s.nextInt();
		
		String sql = "update emp set salary = salary* ? where title = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		//�Է� �Ķ���� �� ����
		st.setInt(1, salary);
		st.setNString(2, title);
		
		con.rollback(); // ��������� �ѹ� �ϸ� �ѹ���
		
		int row = st.executeUpdate();
		System.out.println(row + " ���� ���� �����Ǿ����ϴ�.");
		
		
		//DB���� ����
		con.close(); //�̳��� �ڵ����� Ŀ���Ѱ���
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
