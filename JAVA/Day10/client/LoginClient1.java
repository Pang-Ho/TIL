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
		System.out.println("=== " + s.getInetAddress().getHostAddress() + "8888���� ����.===");
		
		//Ŭ���̾�Ʈ�� ������ ���	
		//Ű����� ���̵�� ��� �Է�
		//System.in.read() or Scanner ��� �ΰ�����
		Scanner keyboard = new Scanner(System.in);
		System.out.print("���̵� �Է� : ");
		String id = keyboard.next() + " ";
		System.out.print("��ȣ �Է� : ");
		String pw = keyboard.next() + " ";
		
		// byte b[] = id.getBytes(); ����Ʈ�� ��ȯ �� write��
		byte b[] = id.getBytes();
		
		//Ű����� �Է¹��� ������ ������ ���
		OutputStream os = s.getOutputStream();
		//os.write( (id + "-" + pw).getBytes() ); //�̷��� �Է��ϸ� �������� split�ؾߵ�
		os.write((id + " ").getBytes()); // sc.next(); �� �̿��ؼ� ���� ����. //next�޼ҵ�� ���� �������� ���� �׷��� id �ڿ� ���� ��ߴ�
		os.write(pw.getBytes()); // ������ sc.next();�� �� �� �о�ߵ�
		
		System.out.println("=== ������" + id + "," + pw + " �����߽��ϴ�. ===");
		
		//�����κ��� ó�� ��� �Է�
		InputStream is = s.getInputStream();
		Scanner sc = new Scanner(is);
		String server_reply = sc.nextLine();
		System.out.println("===�����κ��� " + server_reply + " ������ �޾ҽ��ϴ� ===");
		
		is.close();
		os.close();
		s.close();
		System.out.println("===���� ��ǻ�� 9999 ��Ʈ ���� �����մϴ�.===");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
