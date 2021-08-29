package forward;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ForwardDAO {
	
public int forwardNew(ForwardVO vo) {
		Connection con = null;
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
			String sql = "insert into member values(?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, vo.getId());
			st.setString(2, vo.getPw());
			st.setString(3, vo.getName());
			st.setString(4, vo.getMail());
			
			result = st.executeUpdate();
			
			con.close();
		} 
		catch(SQLException e) {e.printStackTrace(); }
		catch(ClassNotFoundException e) {e.printStackTrace(); }
		return result;
	}
	
public ArrayList<ForwardVO> myLookUp(String id) {
	Connection con = null;
	ArrayList<ForwardVO> list = new ArrayList<ForwardVO>();
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		
		String sql = "select * from member where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, id);
		
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
		String db_id = rs.getString("id");
		String db_pw = rs.getString("pw");
		String db_name = rs.getString("name");
		String db_mail = rs.getString("mail");
		
		ForwardVO vo = new ForwardVO(db_id, db_pw, db_name, db_mail);
		list.add(vo);
		}
		con.close();
		System.out.println("연결해제");
	} 
	catch(SQLException e) {e.printStackTrace(); 
	System.out.println("sql문제임");}
	catch(ClassNotFoundException e) {e.printStackTrace(); 
	System.out.println("class가없음");}
	return list;
}

public ArrayList<ForwardVO> allLookup() {
	Connection con = null;
	ArrayList<ForwardVO> list = new ArrayList<ForwardVO>();
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		
		String sql = "select * from member";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
		String db_id = rs.getString("id");
		String db_pw = rs.getString("pw");
		String db_name = rs.getString("name");
		String db_mail = rs.getString("mail");
		
		ForwardVO vo = new ForwardVO(db_id, db_pw, db_name, db_mail);
		list.add(vo);
		}
		con.close();
	} 
	catch(SQLException e) {e.printStackTrace(); }
	catch(ClassNotFoundException e) {e.printStackTrace(); }
	return list;
}

public int forwardUpdate(ForwardVO vo) {
	Connection con = null;
	int result = 0;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		
		String sql = "update member set pw=?, name=?, mail=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, vo.getPw());
		st.setString(2, vo.getName());
		st.setString(3, vo.getMail());
		
		result = st.executeUpdate();
		
		con.close();
	} 
	catch(SQLException e) {e.printStackTrace(); }
	catch(ClassNotFoundException e) {e.printStackTrace(); }
	return result;
}

public int forwardDelete(ForwardVO vo) {
	Connection con = null;
	int result = 0;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		
		String sql = "delete from member where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, vo.getId());
		
		result = st.executeUpdate();
		
		con.close();
	} 
	catch(SQLException e) {e.printStackTrace(); }
	catch(ClassNotFoundException e) {e.printStackTrace(); }
	return result;
}

}