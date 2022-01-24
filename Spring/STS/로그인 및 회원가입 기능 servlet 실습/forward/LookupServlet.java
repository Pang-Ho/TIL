package forward;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/lookup")
public class LookupServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		ForwardDAO dao = new ForwardDAO();
		
		ArrayList<ForwardVO> list = dao.myLookUp(id);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		for(ForwardVO vo : list) {
			o.print("<h3>" + vo + "</h3>");
		}

}
}
