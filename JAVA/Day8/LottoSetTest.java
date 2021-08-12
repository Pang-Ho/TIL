package settest;

import java.util.HashSet;

public class LottoSetTest {

	public static void main(String[] args) {
		//1-45 ���� ?�� �ݺ� ���� - set ���� �� ������ ���� ����� Ȯ�� - 6�� �����ϸ� 
		//set ����(�׷��� �ݵ�� 6�� ������ �ƴϴ�)
		HashSet<Integer> numbers = new HashSet<Integer>(6);
		while(true) {
			int ran = (int)(Math.random() * 45) + 1;
			System.out.println(ran);
			numbers.add(ran);
			if(numbers.size() == 6) {
				break;
			}
		}
		System.out.println("�ϼ��� �ζǹ�ȣ = ");
		for( Integer lotto : numbers ) {
			System.out.println(lotto);
		}

	}

}
