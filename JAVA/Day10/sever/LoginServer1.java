package sever;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class LoginServer1 {

	public static void main(String[] args) {
		try {
		ServerSocket ss = new ServerSocket(8888);
		System.out.println("===로그인서버는 8888 포트로 시작합니다===");
		
		while(true) {//한 클라이언트가 끊겨도 서버 지속
			Socket s = ss.accept();
			System.out.println("===" + s.getInetAddress().getHostAddress() + " s클라이언트와 연결되었습니다===");
			
			//클라이언트로 아이디 암호 받음
			InputStream is = s.getInputStream();
			Scanner sc = new Scanner(is);
			String id = sc.next(); // os.write(id.getBytes())
			String pw = sc.next(); // os.write(pw.getBytes()) 
			System.out.println("클라이언트가 전달한 아이디는 " + id + ", " + pw + " 입니다.");
			
			//users 맵의 key에 id 존재하는지 확인
			String toClient = "";
			boolean search = false;
			
			HashMap<String, String> users = new HashMap<String, String>();
			users.put("multi", "campus");
			users.put("java", "program");
			users.put("m", "c");
			
			Set<String> idSet = users.keySet();
			for( String oneId : idSet ) {
				if(oneId.equals(id)) {
					search = true;
					String pwMap = users.get(oneId);
					if(pwMap.equals(pw)) {
						toClient = "정상 로그인 사용자입니다\n";
					}
					else {
						toClient = "암호를 다시 확인하세요\n";
					}
				}
			}
			if(search == false) {
				toClient = "회원가입부터 하세요\n";
			}
			
			//로그인 처리 결과를 서버가 클라이언트로 출력
			OutputStream os = s.getOutputStream();
			byte[] server_reply_byte = toClient.getBytes(); //알아서 길이가 정해짐
			os.write(server_reply_byte);
			System.out.println("===클라이언트로 응답했습니다.===");
			
			is.close();
			os.close();
			s.close();
			System.out.println("===클라이언트와 연결이 해제되었습니다.'");
		
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}	

}
