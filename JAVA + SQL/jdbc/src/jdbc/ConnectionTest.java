package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args)  {
		try {
		//jdbc driver ȣ��
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//DB����
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("���� ����");
		
		//sql���� - ��� �̿�
		
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
	}

}
