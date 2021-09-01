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

@WebServlet("/insertdb")
public class InsertDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String mail = request.getParameter("mail");
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
			
			String sql = "insert into member values(?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, pw);
			st.setString(3, name);
			st.setString(4, mail);
			int row = st.executeUpdate();
			
			con.close();
			System.out.println("연결해제성공");
			}catch(SQLException e) {
				
			}catch(ClassNotFoundException e) {
				
			}
		//응답
			String result = "회원가입 축하염";
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<h3>" + result + "</h3>");
	}

}
