package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginform")
public class LoginFormServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String[] con = request.getParameterValues("con");
		//처리
		String result ="";

		if(pw.length() <= 10) {
			result = "암호 입력 조건에 마즘";
		}
		else {
			result = "암호 입력 조건에 맞지아늠";
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>" + id + " 아이디 받았습니다.</h3>");
		out.println("<h3>" + result + "</h3>");
		for(String a : con) {
			out.println("<h3> 관심 분야" + a + " </h3>");
		}
		/*
		 * java.util.Enumeration e = request.getParameterNames(); // name 다 찾아오는거
		 * while(e.hasMoreElements()) { System.out.println(e.nextElement()); }
		 */
	}

}
