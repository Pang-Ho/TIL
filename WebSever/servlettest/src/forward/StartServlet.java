package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

@WebServlet("/start")
public class StartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String user_password = request.getParameter("password");
		MemberDAO dao = new MemberDAO();
		String result = dao.getMember(id, user_password);
		
		request.setAttribute("role", "admin"); //요청객체 내부에다가 서블릿 추가 데이터저장
		
		if(id.equals("admin")) {
		RequestDispatcher rd =request.getRequestDispatcher("/admin");
		rd.include(request, response); //doxxx(request, response) 를 요청하는구나
		
		o.println("<h1>완료</h1>");
		} else {
		RequestDispatcher rd =request.getRequestDispatcher("/user");
		rd.include(request, response); //doxxx(request, response) 를 요청하는구나
		
		o.println("<h1>완료</h1>");
		}
	}

}
