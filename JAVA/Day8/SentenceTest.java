package day8;

import java.util.ArrayList;
import java.util.HashSet;
class SameSent {
	HashSet<String> result = new HashSet<String>();
	
	public HashSet compare(ArrayList<String> list1, ArrayList<String> list2) {
		if(list1.size()==list2.size()) {
			for(int i = 0 ; i < list1.size() ; i++) {
				if(list1.get(i).equals(list2.get(i))) {
					result.add(list1.get(i));
				}
			}
			return result;
			} else if(list1.size() > list2.size()) {
				for(int i = 0 ; i < list2.size() ; i++) {
					if(list1.get(i).equals(list2.get(i))) {
						result.add(list2.get(i));
					}		
				}
				return result;
			} else if(list1.size() < list2.size()) {
				for(int i = 0 ; i < list1.size() ; i++) {
					if(list1.get(i).equals(list2.get(i))) {
						result.add(list1.get(i));
					}		
				}
				return result;
			} else {
				return result;
			}
	}
	public void getResult() {
		for(String sen : result) {
		System.out.println("같은 문장 : " + sen );
		
		}
		result.clear();
	}
}
public class SentenceTest {

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("자바는 객체지향 언어입니다");
		list1.add("우리는 멀티캠퍼스에서 자바를 배우는 중입니다");
		list1.add("오늘은 컬렉션 프레임워크를 배우죠! ");
		list1.add("내일은 입출력과 네트워크를 배울 예정입니다 ");
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("자바는 객체지향 언어입니다");
		list2.add("우리는 MULTI에서 자바를 배우는 중입니다");
		list2.add("오늘은 콜렉션 프레임워크를 배우죠! ");
		list2.add("내일은 입출력과 네트워크를 배울 예정입니다 ");
		
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("자바는 객체지향 언어입니다");
		list3.add("우리는 kitri에서 자바를 배우는 중입니다");
		list3.add("오늘은 콜렉션 프레임워크를 배우죠! ");

		SameSent ss = new SameSent();
		ss.compare(list1, list2);
		ss.getResult();
		
		ss.compare(list1, list3);
		ss.getResult();
	}

}
