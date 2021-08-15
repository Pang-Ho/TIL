package client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class LoginClient1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		Socket s = new Socket("127.0.0.1", 8888);
		System.out.println("=== " + s.getInetAddress().getHostAddress() + "8888접속 성공.===");
		
		//클라이언트가 서버로 출력	
		//키보드로 아이디와 비번 입력
		//System.in.read() or Scanner 방법 두개있음
		Scanner keyboard = new Scanner(System.in);
		System.out.print("아이디 입력 : ");
		String id = keyboard.next() + " ";
		System.out.print("암호 입력 : ");
		String pw = keyboard.next() + " ";
		
		// byte b[] = id.getBytes(); 바이트로 변환 후 write에
		byte b[] = id.getBytes();
		
		//키보드로 입력받은 내용을 서버로 출력
		OutputStream os = s.getOutputStream();
		//os.write( (id + "-" + pw).getBytes() ); //이렇게 입력하면 서버에서 split해야됨
		os.write((id + " ").getBytes()); // sc.next(); 로 이용해서 읽을 거임. //next메소드는 공백 이전까지 읽음 그래서 id 뒤에 공백 써야댐
		os.write(pw.getBytes()); // 서버도 sc.next();로 두 번 읽어야됨
		
		System.out.println("=== 서버로" + id + "," + pw + " 전송했습니다. ===");
		
		//서버로부터 처리 결과 입력
		InputStream is = s.getInputStream();
		Scanner sc = new Scanner(is);
		String server_reply = sc.nextLine();
		System.out.println("===서버로부터 " + server_reply + " 응답을 받았습니다 ===");
		
		is.close();
		os.close();
		s.close();
		System.out.println("===로컬 컴퓨터 9999 포트 접속 해제합니다.===");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
