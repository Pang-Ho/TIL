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
		System.out.println("===���� ��ǻ�� 9999 ��Ʈ ������ ��û�մϴ�.===");
		System.out.println("=== " + s.getInetAddress().getHostAddress() + "���� ����.===");
		
		//Ŭ���̾�Ʈ�� ������ ���	
		String id = "�ȳ� �ϼ���\n"; //�ѱ��� 5���̸� byte ���̴� 10.
		byte id_byte [] = id.getBytes();
		
		OutputStream os = s.getOutputStream();
		os.write(id_byte);
		System.out.println("===" + id_byte.length + "===");
		
		System.out.println("=== ������ ���̵� �����߽��ϴ�. ===");
		
		//�����κ��� �Է�
		InputStream is = s.getInputStream();
		Scanner sc = new Scanner(is);
		String server_reply = sc.nextLine();
		System.out.println("===�����κ��� " + server_reply + " ������ �޾ҽ��ϴ� ===");
		
		s.close();
		System.out.println("===���� ��ǻ�� 9999 ��Ʈ ���� �����մϴ�.===");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
