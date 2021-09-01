package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO2;
import vo.MemberVO;

@WebServlet("/memberlist")
public class MemberListServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//include 하는중
		String o = (String)request.getAttribute("role");
		if(o.equalsIgnoreCase("admin")) {
			doGet(request, response);			
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO2 dao = new MemberDAO2();
		ArrayList<MemberVO> list = dao.getMemberList();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		for(MemberVO vo : list) {
			out.print("<h3>" + vo + "</h3>");
		}
	}
}
