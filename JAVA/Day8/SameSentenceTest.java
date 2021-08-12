package day8;

import java.util.ArrayList;
import java.util.List;

class SameSentence{
	String[] compare(ArrayList<String> list1, ArrayList<String> list2){
		String[] result = new String[10]; //배열의 길이를 바꿀 수가 없음
		int cnt = 0;
		int len1 = list1.size();
		int len2 = list2.size();
		if(len1 == len2) {
			for(int i = 0 ; i < len1 ; i++) {
				if(list1.get(i).equals(list2.get(i))) {
					result[cnt] = list1.get(i);
					cnt++;//cnt 변수로 null 방지 하는 방법이래
				}
			}
		} else {
			result[0] = String.valueOf(len1 + len2);
		}
		/*if(list1.size() == list2.size()) {
			for(int i = 0 ; i < list1.size() ; i++) {
				if(list1.get(i) == list2.get(i)) {
					System.out.println(list1.get(i));
				}
			}
		} else {
			System.out.println("list1 의 데이터 총 갯수 = " + list1.size());
			System.out.println("list3 의 데이터 총 갯수 = " + list2.size());
		}*/
		
		//null이면 같은 리스트에 들어가서 본문에 if가 필요없음 
		String[] result2 = new String[cnt]; 
		System.arraycopy(result, 0, result2, 0, cnt);
         return result2;
	}
}

public class SameSentenceTest {
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
	
	SameSentence ss = new SameSentence();
	String[] r1 = ss.compare(list1, list2);//list1, list2에서 같은 내용만 출력
	for(int i = 0; i < r1.length ; i++) { //return 값 바꾸려면 이렇게
		//배열의 길이를 바꿀 수 없으니 null나오지 않게 
		//if(r1[i] != null) {
		System.out.println(r1[i]);
	
		//}
	}
	String[] r2 = ss.compare(list1, list3);//list1, list3의 데이터 총갯수 출력	
	for(int i = 0 ; i < r2.length ; i++) {
		if(r2[i] !=null) {
		System.out.println(r2[i]);
		}
	}	
}
}

