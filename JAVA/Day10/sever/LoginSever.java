package sever;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class LoginSever {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("9999포트 서버 시작");
			
			Socket s = ss.accept();
			System.out.println(s.getInetAddress().getHostAddress() + " s클라이언트와 연결되었습니다.");
			
			InputStream is = s.getInputStream();
			Scanner sc = new Scanner(is);
			
			/*String id = sc.next();
			System.out.println("클라이언트가 전달한 id는 " + id + " 입니다.");
			String pw = sc.next();
			System.out.println("클라이언트가 전달한 pw는 " +pw+ "입니다.");*/
			String idpw = sc.next();
			String[] user = idpw.split("a");
			
			System.out.println(user[0]);
			System.out.println(user[1]);
			
			HashMap<String, String> users = new HashMap<String, String>();
			users.put("multi", "campus");
			users.put("java", "program");
			users.put("oracle", "db");
			
			
			OutputStream os = s.getOutputStream();
			
			
			String server_reply1 = "회원가입부터 하세요.";
			byte[] server_reply_byte1 = server_reply1.getBytes();
			os.write(server_reply_byte1);
			
			if(users.containsKey(user[0])) {
				if(users.containsValue(user[1])) {
					String server_reply = "정상 로그인 사용자입니다";
					byte[] server_reply_byte = server_reply.getBytes();
					os.write(server_reply_byte);
				} else {
					String server_reply = "암호를 확인하세요";
					byte[] server_reply_byte = server_reply.getBytes();
					os.write(server_reply_byte);
				}
			} else {
				String server_reply = "회원가입부터 하세요.";
				byte[] server_reply_byte = server_reply.getBytes();
				os.write(server_reply_byte);
				
			}
			
			s.close();
			System.out.println("s클라이언트와 연결이 해제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
