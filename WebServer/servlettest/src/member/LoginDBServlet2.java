package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

@WebServlet("/logind")
public class LoginDBServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//요청	
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id"); //html파일에서 데이터 입력
		String user_password = request.getParameter("password");
		//jdbc (member1:1111 member2:2222)
		MemberDAO dao = new MemberDAO();
		String result = dao.getMember(id, user_password);
		
	//응답
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println(result);
		
		//MemberListServlet 
		//html태그 속성에선 / => 서버루트 => /context명
		//web.xml, @WebServlet, rd 속성에선 / => context루트 => /파일명
		request.setAttribute("role", "admin"); //요청객체 내부에다가 서블릿 추가 데이터저장
		
		RequestDispatcher rd =request.getRequestDispatcher("/memberlist");
		rd.include(request, response); //doxxx(request, response) 를 요청하는구나
		
		o.println("<h1>완료</h1>");
	}

}
