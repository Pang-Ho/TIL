package study;

import java.io.InputStream;

public class ISReadTest {

	public static void main(String[] args) throws Exception {
		InputStream is = System.in;

		byte[] data = new byte[100];
		
		System.out.print("�̸� : ");
		int code1 = is.read(data);
		String name = new String(data, 0, data.length);
		
		System.out.print("���� : ");
		int code2 = is.read(data);
		String sex = new String(data, 0, data.length);
		
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + sex);
		
	}

}