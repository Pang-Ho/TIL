package day9;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCopyTest {
public static void main(String[] args) {
	Scanner s = new Scanner(System.in); 
	System.out.println("원본파일명 : ");
	String sourcefile = s.next();
	
	System.out.println("목적지파일명 : ");
	String destfile = s.next();
	/*
	 * 1. a.txt, b.txt => 입력파일 미존재시 예외발생 - 중단
	 * 2. src/day9/FileCopyTest.java를 b.txt에 복사 - 출력파일 미존재시 자동 생성
	 * 3. src/day9/ScannerTest.java를 b.txt에 복사 - 출력파일 존재시 내용삭제 후 출력 시작
	 * 4. 소스 내부 new FileWriter(destfile, true);로 수정하고
	 * 	  src/day9/SystemInTest.java b.txt - 출력파일 존재시 내용 유지 추가 출력
	 */
	FileReader fr = null;
	FileWriter fw = null;
	
	try {
	fr = new FileReader(sourcefile);
	fw = new FileWriter(destfile, true);
	
	// 파일복사 구현 = fr 입력받아서 fw로 출력
	while(true) {
		int r = fr.read();
		if(r == -1) { break; }//end of file = eof
		fw.write(r);
	}
	
	}catch(IOException e) {
		e.printStackTrace();
	}finally {
		try {
			fr.close();
			fw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
}
