
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedSelectTest {

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
		String title = s.next();
		//str1 = "'%" + str1 +"%'";
		System.out.print("�Ի�� : ");
		String month = s.next();
		
		
		String sql = "select title, name, dept_id, to_char(hiredate, 'yyyy/mm/dd hh24:mi:ss') hiredate2"
				+ " from emp where hiredate like ? and title like ?" ;
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, "%" + title + "%");
		st.setString(2, "___" + month + "%");
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String name = rs.getString("name");
			String db_title = rs.getString("title");
			int dept_id = rs.getInt("dept_id");
			String hiredate = rs.getString("hiredate");
			System.out.println(name + "\t" + db_title + "\t" + dept_id + "\t" + hiredate);
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
