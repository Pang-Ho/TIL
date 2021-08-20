package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args)  {
		Connection con = null;
		try {
		//jdbc driver ȣ��
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//DB����
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("���� ����");
		
		
		//emp���̺� - 400 �����  30 100000 ���� sysdate ���ڵ� insert
		//String sql = "insert into emp values(400, '�����', 30, 1000000, '����', sysdate)";
		
		//�����Ű����� 401 �Ѻ��� 10 900000 ���� / args + sysdate => emp ���̺�� ����
		//String sql = "insert into emp values(" + args[0] + ", '" + args[1] + "' , " + args[2] + "," +
			//									args[3] + ", '" + args[4] + "' , sysdate)";
		
		String sql = "insert into emp"+
					" select employee_id, first_name, department_id, salary, job_id, hire_date" +
					" from employees where employee_id > 200";
		
		//sql ���� - db ���� ����
		Statement st = con.createStatement();
		int row = st.executeUpdate(sql);
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
