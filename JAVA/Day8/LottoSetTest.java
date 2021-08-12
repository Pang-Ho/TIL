package settest;

import java.util.HashSet;

public class LottoSetTest {

	public static void main(String[] args) {
		//1-45 난수 ?개 반복 생성 - set 저장 후 데이터 갯수 몇개인지 확인 - 6개 만족하면 
		//set 저장(그러나 반드시 6개 저장이 아니다)
		HashSet<Integer> numbers = new HashSet<Integer>(6);
		while(true) {
			int ran = (int)(Math.random() * 45) + 1;
			System.out.println(ran);
			numbers.add(ran);
			if(numbers.size() == 6) {
				break;
			}
		}
		System.out.println("완성된 로또번호 = ");
		for( Integer lotto : numbers ) {
			System.out.println(lotto);
		}

	}

}
