package day8;

import java.util.ArrayList;
import java.util.List;

class SameSentence{
	String[] compare(ArrayList<String> list1, ArrayList<String> list2){
		String[] result = new String[10]; //�迭�� ���̸� �ٲ� ���� ����
		int cnt = 0;
		int len1 = list1.size();
		int len2 = list2.size();
		if(len1 == len2) {
			for(int i = 0 ; i < len1 ; i++) {
				if(list1.get(i).equals(list2.get(i))) {
					result[cnt] = list1.get(i);
					cnt++;//cnt ������ null ���� �ϴ� ����̷�
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
			System.out.println("list1 �� ������ �� ���� = " + list1.size());
			System.out.println("list3 �� ������ �� ���� = " + list2.size());
		}*/
		
		//null�̸� ���� ����Ʈ�� ���� ������ if�� �ʿ���� 
		String[] result2 = new String[cnt]; 
		System.arraycopy(result, 0, result2, 0, cnt);
         return result2;
	}
}

public class SameSentenceTest {
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
	
	SameSentence ss = new SameSentence();
	String[] r1 = ss.compare(list1, list2);//list1, list2���� ���� ���븸 ���
	for(int i = 0; i < r1.length ; i++) { //return �� �ٲٷ��� �̷���
		//�迭�� ���̸� �ٲ� �� ������ null������ �ʰ� 
		//if(r1[i] != null) {
		System.out.println(r1[i]);
	
		//}
	}
	String[] r2 = ss.compare(list1, list3);//list1, list3�� ������ �Ѱ��� ���	
	for(int i = 0 ; i < r2.length ; i++) {
		if(r2[i] !=null) {
		System.out.println(r2[i]);
		}
	}	
}
}

