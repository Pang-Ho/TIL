package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args) {
		Connection con = null;
		try {
		//0. oracle jdbc driver ȣ�� - ojdbc6.jar 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//1.  db ����(db����, ip, port, ����, ��ȣ.)
		con = DriverManager.getConnection
		("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("���Ἲ��");

		//emp ���̺� - 400 ����� ���� 30 1000000 sysdate ���ڵ� insert
		// sql - db �ν� ��� . �ڹ� sql ���ڿ� ����
		//String sql = "insert into emp values(400 , '�����',  '����', 30 ,1000000 , sysdate )";
		
		//����� �Ű����� - RUN CONFIGURATIONS-ARGUMENTS-PRORAM ARGUMENT - ...
		//401         �Ѻ���       ����                 10    900000 --> 5�� �Է� , + SYSDATE --> EMP  ���̺�� ����
		//args[0] args[1] args[2]  args[3]  args[4]
		//String sql = "insert into emp values(" + args[0] + ", '" + args[1] + "',  '" 
		//+ args[2] + "', " + args[3]  + "," + args[4] + ", sysdate )";
		
		String sql = "insert into emp"
		+" select employee_id, first_name, job_id, department_id, salary, hire_date"
		+" from employees where employee_id > 200";
		

		
		// sql ���� - db ���� ����
		Statement st = con.createStatement();
		int row = st.executeUpdate(sql);
		System.out.println(row + " ���� �� ���ԵǾ����ϴ�.");
		
		//4. db ���� ���� - ���� close tcp���� close finally
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
