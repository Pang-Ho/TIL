package day9;

import java.util.Scanner;

public class CalTest {

	public static void main(String[] args) {
		while(true) {
		//���� �޴� ȭ��
		System.out.println("���� �޴�");
		System.out.println("1. ����");
		System.out.println("2. ����");
		System.out.println("3. ����");
		System.out.println("4. ������");
		System.out.println("5. ����");
		System.out.println("");
		System.out.println("��ȣ�Է� : ");
		
		//����� �޴����� ��ȣ �Է�
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		if(num == 5) {
		/*int result = System.in.read();
		if(result == 53) {*/ 
			System.out.println("���� �����մϴ�.");
			return;
		}
		else if(num >= 1 && num <= 4){ // 1 -4
			System.out.println("ù��° ������ : ");
			int data1 = s.nextInt();
			System.out.println("�ι�° ������ : ");
			int data2 = s.nextInt();
			
			Calculator c = new Calculator(data1, data2, num);
			c.calc(); // 100 + 200 = 300
			String calcResult = c.calc();
			System.out.println(calcResult);
			System.out.println("=======================\n\n");
		}
		else {
			System.out.println("�߸��� ��ȣ�� �Է��ϼ̽��ϴ�.");
		}
	}
	}
}

class Calculator{
	int data1;
	int data2;
	int num;
	
	public Calculator(int data1, int data2, int num) {
		this.data1 = data1;
		this.data2 = data2;
		this.num = num;
	}
	
	public String calc() {
		String op[] = {"+", "-", "*", "/"};
		String result = data1 + op[num - 1] + data2 + " = ";
		if(num == 1) {
			result += data1 + data2;
		}
		else if(num ==2) {
			result += data1 - data2;
		}
		else if(num == 3 ) {
			result += data1 * data2;
		}
		else if(num == 4) {
			result += (double)data1 / data2;
		}
		return result;
	}
}