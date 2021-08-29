package forward;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//메뉴 (id 회원님)
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.print("<h3>" + id + " 회원님<h3>");
		//내정보 수정
		o.print("<a href='/study/retouch.html'>내정보 수정</a>");
		//내정보 조회
		o.print("<a href='/study/lookup?id=" + id + "&pw=" + pw + "'>내정보 조회</a>");
	}
}