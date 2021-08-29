package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logindb")
public class LoginDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
		//jdbc
			Connection con = null;
			String db_id="";
			String db_pw="";
			String db_name="";
			String db_mail="";
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			System.out.println("연결 성공");
			
			String sql = "select * from member where id = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				db_id = rs.getString("id");
				db_pw = rs.getString("pw");
				db_name = rs.getString("name");
				db_mail = rs.getString("mail");
				
			}
			
			con.close();
			System.out.println("연결해제성공");
			}catch(SQLException e) {
				
			}catch(ClassNotFoundException e) {
				
			}
		//응답
			String result = "";
			if(db_id.equals(id)) {
				if(db_pw.equals(pw)) {
					result = "<h1>오 로그인 축하드림<br>아이디 : " + db_id + "<br>이름 : " +db_name + "<br>메일 : " + db_mail + "</h1>";
				}
				else {
					result = "<h1>암호가 다른디예<br> <a href='http://localhost:9090/servlettest/logindb.html'>다시 로그인해봐</a></h1>";
				}
			}
			else {
				result = "<h1>회원가입 하셈 님아<br> <a href='/servlettest/insertmember.html'>회원가입ㄱㄱ</a></h1>";
			}
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<h3>" + result + "</h3>");
	}

}
