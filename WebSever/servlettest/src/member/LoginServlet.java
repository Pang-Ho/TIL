package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:9090/servlettest/login 클라가 요청url로 요청
//내게 요청한 클라가 누구야?
//http://localhost:9090/servlettest/login?입력파라미터명=테이값
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id"); //id를 받아와라 : 요청
		System.out.println("클라이언트로부터" + id + "데이터 전송받았습니다. ");
		
		//처리 jsp, servlet spring 인지 확인
		String result = "";
		if(id.equals("jsp") || id.equals("servlet") || id.equals("spring")) {
			result = "입력한 아이디 " + id + " 정상 로그인 되었습니다.";
		}
		else {
			result = "입력한 아이디 " + id + " 로그인 할 수 없습니다.";
		}
		
		//응답
		response.setContentType("text/html;charset=utf-8"); //이것이 없으면 브라우저 charset으로 됨
		PrintWriter out = response.getWriter(); //브라우저 응답 = 브라우저로 출력하는 객체
		out.println("<h1>" + result + "</h1>");
		
	}

}
