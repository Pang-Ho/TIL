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
		System.out.println("���� ���� : " + sen );
		
		}
		result.clear();
	}
}
public class SentenceTest {

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("�ڹٴ� ��ü���� ����Դϴ�");
		list1.add("�츮�� ��Ƽķ�۽����� �ڹٸ� ���� ���Դϴ�");
		list1.add("������ �÷��� �����ӿ�ũ�� �����! ");
		list1.add("������ ����°� ��Ʈ��ũ�� ��� �����Դϴ� ");
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("�ڹٴ� ��ü���� ����Դϴ�");
		list2.add("�츮�� MULTI���� �ڹٸ� ���� ���Դϴ�");
		list2.add("������ �ݷ��� �����ӿ�ũ�� �����! ");
		list2.add("������ ����°� ��Ʈ��ũ�� ��� �����Դϴ� ");
		
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("�ڹٴ� ��ü���� ����Դϴ�");
		list3.add("�츮�� kitri���� �ڹٸ� ���� ���Դϴ�");
		list3.add("������ �ݷ��� �����ӿ�ũ�� �����! ");

		SameSent ss = new SameSent();
		ss.compare(list1, list2);
		ss.getResult();
		
		ss.compare(list1, list3);
		ss.getResult();
	}

}
