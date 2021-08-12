package day9;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("키보드로 정수 2개를 입력해조세요");
		// 100 200
		if(s.hasNextInt()) {
		int first = s.nextInt(); //정수 입력시에만 가능
		int second = s.nextInt();
		System.out.println(first + second);
		}
		s.nextLine();
		System.out.println("키보드로 한글 데이터를 입력해 보세요");
		String word = s.nextLine();
		System.out.println(word);
	
	}
}
