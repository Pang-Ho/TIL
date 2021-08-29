package pool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

@WebServlet("/manyconnection2")
public class ManyConnectionTest2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청
		
		//jdbc
			
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			for(int i = 1; i <=1000 ; i++) {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			//=> 메모리에 con객체를 생성함
			System.out.println(i+ "번째 연결 성공");
			con.close(); //68번에서 멈추는데 뭐냐?? 메모리에서 con 객체를 삭제할 예정을 표시하는 것 즉각 삭제 방법은 서버를 끄는것...
							//=> 해결방법이 뭘까용?
			}
			
			}catch(SQLException e) {
				
			}catch(ClassNotFoundException e) {
				
			}
		//응답
		
}
}
