package day9;

import java.util.Scanner;

class CalMenu{
	public void show() {
		//���� �޴� ȭ��
		System.out.println("���� �޴�");
		System.out.println("1. ����");
		System.out.println("2. ����");
		System.out.println("3. ����");
		System.out.println("4. ������");
		System.out.println("5. ����");
		System.out.println("");
		System.out.println("��ȣ�Է� : ");
	}
}

public class Cal {
public static void main(String[] args) {
		CalMenu menu = new CalMenu();
		Scanner s = new Scanner(System.in);
		menu.show();
		
		//���� �޴� ����
		int num = s.nextInt();
		int first;
		int second;
		
		Label : while(true) {
			
			switch(num) {
			case 1 : 
				System.out.println("���� �� ���� 1���� �Է��ϼ���");
				first = s.nextInt();
				System.out.println("���� �� ���� 1���� �Է��ϼ���");
				second = s.nextInt();
				System.out.println("��� �� : " + (first + second));
				menu.show();
				num = s.nextInt();
				break;
			case 2 : 
				System.out.println("���� �� ���� 1���� �Է��ϼ���");
				first = s.nextInt();
				System.out.println("���� �� ���� 1���� �Է��ϼ���");
				second = s.nextInt();
				System.out.println("��� �� : " + (first - second));
				menu.show();
				num = s.nextInt();
				break;
			case 3 : 
				System.out.println("���� �� ���� 1���� �Է��ϼ���");
				first = s.nextInt();
				System.out.println("���� �� ���� 1���� �Է��ϼ���");
				second = s.nextInt();
				System.out.println("��� �� : " + first * second);
				menu.show();
				num = s.nextInt();
				break;
			case 4 : 
				System.out.println("������ �� ���� 1���� �Է��ϼ���");
				first = s.nextInt();
				System.out.println("������ �� ���� 1���� �Է��ϼ���");
				second = s.nextInt();
				if(second == 0) {
					System.out.println("�и� 0�� �� �� �����ϴ�.");
					continue;
				}
				System.out.println("��� �� : " + ( (double)first / second) );
				menu.show();
				num = s.nextInt();
				break;
			case 5 : 
				System.out.println("�����մϴ�.");
				break Label;
			}
			
		}
}
}
