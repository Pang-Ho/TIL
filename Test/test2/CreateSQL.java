package test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateSQL {

	public static void main(String[] args) {
		Connection con = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		
		String sql = "create table book("
				+" isbn number(5) constraint book_isbn_pk primary key,"
				+" title varchar2(50) constraint book_title_nn not null,"
				+" author varchar2(250) constraint book_author_nn not null,"
				+" publisher varchar2(50) constraint book_publisher_nn not null,"
				+" price number(6) constraint book_price_nn not null,"
				+" detail varchar2(200),"
				+" publish_date varchar2(10)"
				+" )";
		
		Statement st = con.createStatement();
		int row = st.executeUpdate(sql);
		
		con.close();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con.isClosed() == false) {
					con.close();
				}
			}
			catch ( SQLException e) {	
				e.printStackTrace();
			}
		}
	}

}
