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
		System.out.println("===������ 9999 ��Ʈ�� �����մϴ�===");
		
		while(true) {//�� Ŭ���̾�Ʈ�� ���ܵ� ���� ����
			Socket s = ss.accept();
			System.out.println("===" + s.getInetAddress().getHostAddress() + " sŬ���̾�Ʈ�� ����Ǿ����ϴ�===");
			
			//������ Ŭ���̾�Ʈ�κ��� �����͸� ���޹޾� �Է¹޴� ���1
			/*byte[] id_byte_server = new byte[10];//
			InputStream is = s.getInputStream();
			is.read(id_byte_server); //Ŭ���̾�Ʈ�κ��� �迭�� ���޹޾� ����. �ȳ��ϼ��� 10��
			String id = new String(id_byte_server);
			System.out.println("Ŭ���̾�Ʈ�� ������ ���̵��" + id + "�Դϴ�.");*/

			//�� ����� �ʹ� ��� ������ byte�� �ް� String���� �ٲٰ�...
			
			//������ Ŭ���̾�Ʈ�κ��� �����͸� ���޹޾� �Է¹޴� ���2 (������ ���� ���� �ƴ� ���� �״�� �޾ƿ� ��)
			InputStream is = s.getInputStream();
			//DataInputStream ds = new DataInputStream(is);
			//String id = ds.readLine(); �� ������ �̷��� �� ���� ����
			Scanner sc = new Scanner(is);
			String id = sc.nextLine(); //���� �����ϸ� nextLine���� 
			System.out.println("Ŭ���̾�Ʈ�� ������ ���̵�� " + id + " �Դϴ�.");
			
			//���� ������ Ŭ���̾�Ʈ�� ���
			OutputStream os = s.getOutputStream();
			String server_reply = "�� �����ϴ�.\n"; //\n�� �Ⱥٿ��� nextline�� ���� �������� �𸣴ϱ� ��� ��ٸ��°ſ���
			byte[] server_reply_byte = server_reply.getBytes(); //�˾Ƽ� ���̰� ������
			os.write(server_reply_byte);
			System.out.println("===Ŭ���̾�Ʈ�� �����߽��ϴ�.===");
			
			s.close();
			System.out.println("===Ŭ���̾�Ʈ�� ������ �����Ǿ����ϴ�.'");
		
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}	

}
