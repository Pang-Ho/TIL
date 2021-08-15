package sever;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class LoginSever {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("9999��Ʈ ���� ����");
			
			Socket s = ss.accept();
			System.out.println(s.getInetAddress().getHostAddress() + " sŬ���̾�Ʈ�� ����Ǿ����ϴ�.");
			
			InputStream is = s.getInputStream();
			Scanner sc = new Scanner(is);
			
			/*String id = sc.next();
			System.out.println("Ŭ���̾�Ʈ�� ������ id�� " + id + " �Դϴ�.");
			String pw = sc.next();
			System.out.println("Ŭ���̾�Ʈ�� ������ pw�� " +pw+ "�Դϴ�.");*/
			String idpw = sc.next();
			String[] user = idpw.split("a");
			
			System.out.println(user[0]);
			System.out.println(user[1]);
			
			HashMap<String, String> users = new HashMap<String, String>();
			users.put("multi", "campus");
			users.put("java", "program");
			users.put("oracle", "db");
			
			
			OutputStream os = s.getOutputStream();
			
			
			String server_reply1 = "ȸ�����Ժ��� �ϼ���.";
			byte[] server_reply_byte1 = server_reply1.getBytes();
			os.write(server_reply_byte1);
			
			if(users.containsKey(user[0])) {
				if(users.containsValue(user[1])) {
					String server_reply = "���� �α��� ������Դϴ�";
					byte[] server_reply_byte = server_reply.getBytes();
					os.write(server_reply_byte);
				} else {
					String server_reply = "��ȣ�� Ȯ���ϼ���";
					byte[] server_reply_byte = server_reply.getBytes();
					os.write(server_reply_byte);
				}
			} else {
				String server_reply = "ȸ�����Ժ��� �ϼ���.";
				byte[] server_reply_byte = server_reply.getBytes();
				os.write(server_reply_byte);
				
			}
			
			s.close();
			System.out.println("sŬ���̾�Ʈ�� ������ �����Ǿ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
