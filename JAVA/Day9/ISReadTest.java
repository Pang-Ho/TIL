package study;

import java.io.InputStream;

public class ISReadTest {

	public static void main(String[] args) throws Exception {
		InputStream is = System.in;

		byte[] data = new byte[100];
		
		System.out.print("이름 : ");
		int code1 = is.read(data);
		String name = new String(data, 0, data.length);
		
		System.out.print("성별 : ");
		int code2 = is.read(data);
		String sex = new String(data, 0, data.length);
		
		System.out.println("이름 : " + name);
		System.out.println("성별 : " + sex);
		
	}

}