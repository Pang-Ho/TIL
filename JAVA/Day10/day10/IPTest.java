package day10;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPTest{

	public static void main(String[] args) {
		try {
		InetAddress myip = InetAddress.getLocalHost(); // ����ƽ �޼ҵ���
		System.out.println(myip.getHostAddress()); //���� ��ǻ�� ip
		System.out.println(myip.getHostName()); // �� ��ǻ�� �̸�
		
		// www.daum.net ���� ���� ����
		// ��Ʈ��ũ Ŭ���̾�Ʈ�� ���� ip address, �� ��Ʈ��ȣ�� �˾ƾ��Ѵ�.
		// Ŭ���̾�Ʈ�� ���� ������ = 203.133.167.81 + 8080 ��ſ� ������ ������ �˷���
		InetAddress[] otherip = InetAddress.getAllByName("www.daum.net"); //daum ip�ּ� �˰�ʹ�
		 for(InetAddress one : otherip) {
			 System.out.println(one.getHostAddress());
		 }
		} catch(UnknownHostException e) {
			e.printStackTrace(); //
		}
	}

}
