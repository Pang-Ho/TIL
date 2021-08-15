package client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class LoginClient {

	public static void main(String[] args) {
		try {
			Socket s =new Socket("127.0.0.1", 9999);
			System.out.println("9999포트 접속");
			System.out.println( s.getInetAddress().getHostAddress() + "접속 성공");
			
			//키보드로 아이디 비번 입력
			Scanner sc = new Scanner(System.in);
			System.out.println("id를 입력해주세요");
			String id = sc.next();
			System.out.println("pw를 입력해주세요");
			String pw = sc.next();
			
			//아이디 비번을 서버로 출력
			//HashMap<String, String> users = new HashMap<String, String>();
			//users.put(id, pw);
			byte[] id_byte = id.getBytes();
			byte[] pw_byte = pw.getBytes();
			
			OutputStream os = s.getOutputStream();
			os.write(id_byte);
			System.out.println("서버로 id 전송");
			os.write(pw_byte);
			System.out.println("서버로 pw 전송");
			
			InputStream is = s.getInputStream();
			Scanner sc = new Scanner(is);
			String sever_reply = sc.nextLine();
			
			s.close();
			System.out.println("9999포트 접속해제");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
