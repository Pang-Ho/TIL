package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import vo.MemberVO;

public class MemberDAO {
	public String getMember(String id, String password) {
		Connection con = null;
		String result = "";
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection
		("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("연결성공");
		
		String sql = "select * from member where memberid = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		//memberid - primary key(not null+unique)
		//  존재하면 1개, 미존재하면 0개=rs.next() true / false
		
		if(rs.next()) {
			//rs.getString("memberid");
			int db_password = rs.getInt("password");
			String name = rs.getString("membername");
			String email = rs.getString("email");
			if(db_password == Integer.parseInt(password) ) {
result = 
"<html><head><style>body{color:blue}</style></head><body><h1>아이디 = " 
+ id + "<br>회원이름 = " + name + "<br> 이메일 = " + email + "</h1></body></html>";
			}//id 존재, 암호 맞다 
			else {
result = 
"<h1>암호가 다릅니다. 다시 <a href='logindb.html' > 로그인 </a> 하세요.</h1>";
			}//id 존재, 암호 다르다
		}//rs.next() if end
		else {
result = 
"<h1>회원 정보를 찾을 수 없습니다.  <a href='logininsert.html' > 회원 가입 </a> 부터 하세요.</h1>";			
		}//id 미존재

		
		con.close();
		System.out.println("연결해제성공");
		}catch(SQLException e) {/**/}
		catch(ClassNotFoundException e) {/**/}	
		
		return result;
	}

	public int insertMember(MemberVO vo) {
		Connection con = null;
		int result = 0;
		try {
		/*
		 * Class.forName("oracle.jdbc.driver.OracleDriver"); con =
		 * DriverManager.getConnection ("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr",
		 * "hr");
		 */
		//1. context명+정보 저장 객체 생성
		Context initContext = new InitialContext();
		//2. server.xml 읽어와서 1번 컨텍스트 설정만 찾아줘
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		//3. name="jdbc/myoracle" 설정만 찾아와
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		//4. 이미 생성된 con을 pool에서 꺼낸다
		con = ds.getConnection();
		System.out.println("연결성공");
		
		String sql = "insert into member values(?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, vo.getMemberid());
		st.setInt(2, vo.getPassword());
		st.setString(3, vo.getMembername());
		st.setString(4, vo.getEmail());
		
		result = st.executeUpdate();
		
		con.close();
		System.out.println("연결해제성공");
		}
		catch(SQLException e) {/**/}
		catch(NamingException e) {/**/}	
		
		return result;
	}
}
