package client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		Socket s = new Socket("127.0.0.1" , 9999);
		System.out.println("===로컬 컴퓨터 9999 포트 접속을 요청합니다.===");
		System.out.println("=== " + s.getInetAddress().getHostAddress() + "접속 성공.===");
		
		//클라이언트가 서버로 출력	
		String id = "안녕 하세요\n"; //한글이 5개이면 byte 길이는 10.
		byte id_byte [] = id.getBytes();
		
		OutputStream os = s.getOutputStream();
		os.write(id_byte);
		System.out.println("===" + id_byte.length + "===");
		
		System.out.println("=== 서버로 아이디 전송했습니다. ===");
		
		//서버로부터 입력
		InputStream is = s.getInputStream();
		Scanner sc = new Scanner(is);
		String server_reply = sc.nextLine();
		System.out.println("===서버로부터 " + server_reply + " 응답을 받았습니다 ===");
		
		s.close();
		System.out.println("===로컬 컴퓨터 9999 포트 접속 해제합니다.===");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
