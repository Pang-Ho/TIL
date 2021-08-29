package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		ForwardVO vo = new ForwardVO(id);
		
		ForwardDAO dao = new ForwardDAO();
		int row = dao.forwardDelete(vo);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		if(row==1) {
			o.print("수정이 완료되었습니다. 다시 로그인하세요.");
		}
		o.print("<a href='/study/login.html'>로그인</a>");
	}

}
