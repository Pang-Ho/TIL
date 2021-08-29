package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/retouch")
public class RetouchServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		
		ForwardVO vo = new ForwardVO(pw, name, mail);
		
		ForwardDAO dao = new ForwardDAO();
		int row = dao.forwardUpdate(vo);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		if(row==1) {
			o.print("수정이 완료되었습니다. 다시 로그인하세요.");
		}
		o.print("<a href='/study/login.html'>로그인</a>");
	}

}
