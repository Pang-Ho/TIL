package day10;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPTest{

	public static void main(String[] args) {
		try {
		InetAddress myip = InetAddress.getLocalHost(); // 스태틱 메소드임
		System.out.println(myip.getHostAddress()); //현재 컴퓨터 ip
		System.out.println(myip.getHostName()); // 내 컴퓨터 이름
		
		// www.daum.net 다음 서버 접속
		// 네트워크 클라이언트는 서버 ip address, 웹 포트번호를 알아야한다.
		// 클라이언트가 많은 서버들 = 203.133.167.81 + 8080 대신에 도메인 네임을 알려줌
		InetAddress[] otherip = InetAddress.getAllByName("www.daum.net"); //daum ip주소 알고싶다
		 for(InetAddress one : otherip) {
			 System.out.println(one.getHostAddress());
		 }
		} catch(UnknownHostException e) {
			e.printStackTrace(); //
		}
	}

}
