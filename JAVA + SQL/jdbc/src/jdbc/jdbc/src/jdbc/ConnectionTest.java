package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		try {
		//0. oracle jdbc driver ȣ�� - ojdbc6.jar 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//1.  db ����(db����, ip, port, ����, ��ȣ.)
		Connection con = DriverManager.getConnection
		("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("���Ἲ��");
		//sql ���� - ��� �̿�
		//4. db ���� ����
		con.close();
		System.out.println("������������");
		}catch(ClassNotFoundException e) {
			System.out.println("����̹� Ŭ���� ��ġ Ȯ���ϼ���");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}//main end

}
