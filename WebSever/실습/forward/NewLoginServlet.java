package forward;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newlogin")
public class NewLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		
		ForwardVO vo = new ForwardVO(id, pw, name, mail);
		
		ForwardDAO dao = new ForwardDAO();
		int row = dao.forwardNew(vo);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		if(row==1) {
			o.print("회원가입이 완료되었습니다.");
		}
	}
	
}
