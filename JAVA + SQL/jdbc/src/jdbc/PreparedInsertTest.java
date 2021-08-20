package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedInsertTest {

	public static void main(String[] args)  {
		Connection con = null;
		try {
		//jdbc driver ȣ��
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//DB����
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("���� ����");
		
		//�����Ű����� 402 �ѽ���  20 700000 ���Ի�� / args + sysdate => emp ���̺�� ����
//		String sql = "insert into emp values(" + args[0] + ", '" + args[1] + "' , " + args[2] + "," +
//												args[3] + ", '" + args[4] + "' , sysdate)";
		String sql = "insert into emp values(?,?,?,?,?,sysdate)";
		//sql ���� - db ���� ����
		PreparedStatement st = con.prepareStatement(sql); //�����м� - ������ - ���� - �����
		//sql �Է� �Ķ���� �� ����
		st.setInt(1, Integer.parseInt(args[0]));
		st.setString(2, args[1]);
		st.setInt(3, Integer.parseInt(args[2]));
		st.setDouble(4, Double.parseDouble(args[3]));
		st.setString(5, args[4]);
		
		int row = st.executeUpdate(); // ����
		System.out.println(row + " ���� �� ���ԵǾ����ϴ�.");
		
		
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
			catch ( SQLException e) {	
				e.printStackTrace();
			}
		}
	}

}
