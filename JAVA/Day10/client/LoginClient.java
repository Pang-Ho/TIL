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
			System.out.println("9999��Ʈ ����");
			System.out.println( s.getInetAddress().getHostAddress() + "���� ����");
			
			//Ű����� ���̵� ��� �Է�
			Scanner sc = new Scanner(System.in);
			System.out.println("id�� �Է����ּ���");
			String id = sc.next();
			System.out.println("pw�� �Է����ּ���");
			String pw = sc.next();
			
			//���̵� ����� ������ ���
			//HashMap<String, String> users = new HashMap<String, String>();
			//users.put(id, pw);
			byte[] id_byte = id.getBytes();
			byte[] pw_byte = pw.getBytes();
			
			OutputStream os = s.getOutputStream();
			os.write(id_byte);
			System.out.println("������ id ����");
			os.write(pw_byte);
			System.out.println("������ pw ����");
			
			InputStream is = s.getInputStream();
			Scanner sc = new Scanner(is);
			String sever_reply = sc.nextLine();
			
			s.close();
			System.out.println("9999��Ʈ ��������");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
