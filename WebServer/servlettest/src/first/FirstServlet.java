package first;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// http://localhost:9090/servlettest/src/first.FirstServlet.class => http://localhost:9090/servlettest/src/FirstServlet

//패키지명.서블릿클래스명.class(실제 파일명) --> 별칭으로 호출 예정 
@WebServlet("/FirstServlet") // 이것이 별칭임 이게 바뀌면 바뀐대로 창이 열림
public class FirstServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
