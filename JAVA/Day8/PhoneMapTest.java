package day8;

import java.util.HashMap;
import java.util.Set;

public class PhoneMapTest {

	public static void main(String[] args) {
		String [] phone1 = {"010-9166-3275", "031-324-2354", "02-2432-1232", "slsl01@naver.com"};
		String [] phone2 = {"010-3495-3275", "031-324-5454", "02-1562-2315", "slsl03@naver.com"};
		String [] phone3 = {"010-3145-3275", "031-363-2454", "02-2552-1452", "slsl05@naver.com"};
		String [] phone4 = {"010-3240-0353"};
		HashMap<String, String[]> map = new HashMap<String, String[]>(); // 이름key - 전화번호 배열
		//map.put(key, value)
		map.put("김자영", phone1);
		map.put("김사원", phone2);
		map.put("박상사", phone3);
		map.put("거래처사원", phone4);
		System.out.println("현재 전화번호부 기록 인원수 = " + map.size());
		
		//거래처사원의 전화번호부 수정. key 중복 저장 허용x key는 Set 형태로 관리됨
		map.put("거래처사원", new String[] {"010-3240-0353", "slsl07@naver.com"});
		System.out.println("현재 전화번호부 기록 인원수 = " + map.size());
		
		//map.remove("김자영");
		//System.out.println("현재 전화번호부 기록 인원수 = " + map.size());
		
		//전화번호부 모든 사람의 이름 출력 key는 set 형태로 관리되니까
		/*Set<String> names = map.keySet();
		for(String onename : names) {
			System.out.println(onename);
		}*/
		//전화번호부 이름 : ... 출력
		Set<String> names = map.keySet();
		for(String onename : names) {
			String[] phone = map.get(onename);
			System.out.print(onename + " : ");
			for(String one : phone) {
				System.out.print(one + " , ");
			}
			System.out.println();
		}
		//명령행 매개변수 김자영 입력하면
		//김자영의 전화번호 정보들 출력
		//Set<String> names3 = map.keySet();
		//String[] phone = map.get(args[0]);
		//System.out.println(phone + " , ");	
		if(map.containsKey(args[0])) { //if를 안하는 이유는 없는경우 다른거 나오게
			String[] phone = map.get(args[0]); // 배열이니까 배열선언 해야댕
			for(String one : phone) {
				System.out.print(one + " , ");
			}
		} else {
			System.out.println("해당 이름은 저장되지 않았습니다.");
		}
	}

}
