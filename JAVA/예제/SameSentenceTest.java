package test;

import java.util.ArrayList;
import java.util.List;

class SameSentence{
	String[] compare(ArrayList<String> list1, ArrayList<String> list2){
		String[] result = new String[10];
		//�����Ͻÿ�.
                return result;
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
	ss.compare(list1, list2);//list1, list2���� ���� ���븸 ���
	ss.compare(list1, list3);//list1, list3�� ������ �Ѱ��� ���	
	
}
}
