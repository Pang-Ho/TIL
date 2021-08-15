package sever;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPSeverTest {

	public static void main(String[] args) {
		try {
		ServerSocket ss = new ServerSocket(9999);
		System.out.println("===서버는 9999 포트로 시작합니다===");
		
		while(true) {//한 클라이언트가 끊겨도 서버 지속
			Socket s = ss.accept();
			System.out.println("===" + s.getInetAddress().getHostAddress() + " s클라이언트와 연결되었습니다===");
			
			//서버가 클라이언트로부터 데이터를 전달받아 입력받는 방법1
			/*byte[] id_byte_server = new byte[10];//
			InputStream is = s.getInputStream();
			is.read(id_byte_server); //클라이언트로부터 배열을 전달받아 저장. 안녕하세요 10개
			String id = new String(id_byte_server);
			System.out.println("클라이언트가 전달한 아이디는" + id + "입니다.");*/

			//위 방법은 너무 길고 복잡함 byte로 받고 String으로 바꾸고...
			
			//서버가 클라이언트로부터 데이터를 전달받아 입력받는 방법2 (정해진 글자 수가 아닌 글자 그대로 받아올 때)
			InputStream is = s.getInputStream();
			//DataInputStream ds = new DataInputStream(is);
			//String id = ds.readLine(); 밑 두줄을 이렇게 쓸 수도 있음
			Scanner sc = new Scanner(is);
			String id = sc.nextLine(); //공백 포함하면 nextLine으로 
			System.out.println("클라이언트가 전달한 아이디는 " + id + " 입니다.");
			
			//이제 서버가 클라이언트로 출력
			OutputStream os = s.getOutputStream();
			String server_reply = "잘 지냅니다.\n"; //\n을 안붙여서 nextline은 언제 끝나는지 모르니까 계속 기다리는거였음
			byte[] server_reply_byte = server_reply.getBytes(); //알아서 길이가 정해짐
			os.write(server_reply_byte);
			System.out.println("===클라이언트로 응답했습니다.===");
			
			s.close();
			System.out.println("===클라이언트와 연결이 해제되었습니다.'");
		
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}	

}
