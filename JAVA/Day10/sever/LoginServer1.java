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
		System.out.println("===�α��μ����� 8888 ��Ʈ�� �����մϴ�===");
		
		while(true) {//�� Ŭ���̾�Ʈ�� ���ܵ� ���� ����
			Socket s = ss.accept();
			System.out.println("===" + s.getInetAddress().getHostAddress() + " sŬ���̾�Ʈ�� ����Ǿ����ϴ�===");
			
			//Ŭ���̾�Ʈ�� ���̵� ��ȣ ����
			InputStream is = s.getInputStream();
			Scanner sc = new Scanner(is);
			String id = sc.next(); // os.write(id.getBytes())
			String pw = sc.next(); // os.write(pw.getBytes()) 
			System.out.println("Ŭ���̾�Ʈ�� ������ ���̵�� " + id + ", " + pw + " �Դϴ�.");
			
			//users ���� key�� id �����ϴ��� Ȯ��
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
						toClient = "���� �α��� ������Դϴ�\n";
					}
					else {
						toClient = "��ȣ�� �ٽ� Ȯ���ϼ���\n";
					}
				}
			}
			if(search == false) {
				toClient = "ȸ�����Ժ��� �ϼ���\n";
			}
			
			//�α��� ó�� ����� ������ Ŭ���̾�Ʈ�� ���
			OutputStream os = s.getOutputStream();
			byte[] server_reply_byte = toClient.getBytes(); //�˾Ƽ� ���̰� ������
			os.write(server_reply_byte);
			System.out.println("===Ŭ���̾�Ʈ�� �����߽��ϴ�.===");
			
			is.close();
			os.close();
			s.close();
			System.out.println("===Ŭ���̾�Ʈ�� ������ �����Ǿ����ϴ�.'");
		
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}	

}
