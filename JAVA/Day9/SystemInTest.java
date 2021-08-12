package day9;

import java.io.IOException;

public class SystemInTest {

	public static void main(String[] args) {
		try {
			while(true) { 
				int result = System.in.read();
				if((char)result == '\n') {
					break;
				}
				System.out.println((char)(result));
		
			}	
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
