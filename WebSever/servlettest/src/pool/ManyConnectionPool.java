package pool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/manyconnection3")
public class ManyConnectionPool extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청
		
		//jdbc
			
			try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//1. context명+정보 저장 객체 생성
				Context initContext = new InitialContext();
				//2. server.xml 읽어와서 1번 컨텍스트 설정만 찾아줘
				Context envContext = (Context)initContext.lookup("java:/comp/env");
				//name="jdbc/myoracle" 설정만 찾아와
				DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
				
				for(int i = 1; i <=1000 ; i++) {
				//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
				//=> con 하나만 만드는거
				Connection con = ds.getConnection();
				System.out.println(i+ "번째 연결 성공");
				con.close(); 
				}
			}catch(SQLException e) {
				
			}catch(NamingException e) {
				
			}
		//응답
		
}
}
