package day9;

import java.util.Scanner;

class CalMenu{
	public void show() {
		//계산기 메뉴 화면
		System.out.println("계산기 메뉴");
		System.out.println("1. 덧셈");
		System.out.println("2. 뺄셈");
		System.out.println("3. 곱셈");
		System.out.println("4. 나눗셈");
		System.out.println("5. 종료");
		System.out.println("");
		System.out.println("번호입력 : ");
	}
}

public class Cal {
public static void main(String[] args) {
		CalMenu menu = new CalMenu();
		Scanner s = new Scanner(System.in);
		menu.show();
		
		//계산기 메뉴 선택
		int num = s.nextInt();
		int first;
		int second;
		
		Label : while(true) {
			
			switch(num) {
			case 1 : 
				System.out.println("덧셈 할 정수 1개를 입력하세요");
				first = s.nextInt();
				System.out.println("덧셈 할 정수 1개를 입력하세요");
				second = s.nextInt();
				System.out.println("결과 값 : " + (first + second));
				menu.show();
				num = s.nextInt();
				break;
			case 2 : 
				System.out.println("뺄셈 할 정수 1개를 입력하세요");
				first = s.nextInt();
				System.out.println("뺄셈 할 정수 1개를 입력하세요");
				second = s.nextInt();
				System.out.println("결과 값 : " + (first - second));
				menu.show();
				num = s.nextInt();
				break;
			case 3 : 
				System.out.println("곱셈 할 정수 1개를 입력하세요");
				first = s.nextInt();
				System.out.println("곱셈 할 정수 1개를 입력하세요");
				second = s.nextInt();
				System.out.println("결과 값 : " + first * second);
				menu.show();
				num = s.nextInt();
				break;
			case 4 : 
				System.out.println("나눗셈 할 정수 1개를 입력하세요");
				first = s.nextInt();
				System.out.println("나눗셈 할 정수 1개를 입력하세요");
				second = s.nextInt();
				if(second == 0) {
					System.out.println("분모에 0이 들어갈 수 없습니다.");
					continue;
				}
				System.out.println("결과 값 : " + ( (double)first / second) );
				menu.show();
				num = s.nextInt();
				break;
			case 5 : 
				System.out.println("종료합니다.");
				break Label;
			}
			
		}
}
}
