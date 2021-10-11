package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//메뉴
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.print("<h3>" + id + " 계정입니다.<h3>");
		o.print("메뉴<br>");
		//모든회원정보
		o.print("<a href='/study/alllookup'>모든 회원 조회</a>");
		//회원 탈퇴
		o.print("<a href='/study/delete.html'>회원탈퇴</a>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
