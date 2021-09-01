package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.MemberVO;

public class MemberDAO2 {
	public ArrayList<MemberVO> getMemberList() {
		Connection con = null;
		ArrayList<MemberVO> result = new ArrayList<MemberVO>();
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection
		("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("연결성공");
		
		String sql = "select * from member";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String db_memberid = rs.getString("memberid");
			int db_password = rs.getInt("password");
			String name = rs.getString("membername");
			String email = rs.getString("email");
			MemberVO vo = new MemberVO(db_memberid, db_password, name, email);
			result.add(vo);
			
		}
		
		con.close();
		System.out.println("연결해제성공");
		}catch(SQLException e) {/**/}
		catch(ClassNotFoundException e) {/**/}	
		
		return result;
	}
}
