package day8;

import java.util.HashMap;
import java.util.Set;

public class PhoneMapTest {

	public static void main(String[] args) {
		String [] phone1 = {"010-9166-3275", "031-324-2354", "02-2432-1232", "slsl01@naver.com"};
		String [] phone2 = {"010-3495-3275", "031-324-5454", "02-1562-2315", "slsl03@naver.com"};
		String [] phone3 = {"010-3145-3275", "031-363-2454", "02-2552-1452", "slsl05@naver.com"};
		String [] phone4 = {"010-3240-0353"};
		HashMap<String, String[]> map = new HashMap<String, String[]>(); // �̸�key - ��ȭ��ȣ �迭
		//map.put(key, value)
		map.put("���ڿ�", phone1);
		map.put("����", phone2);
		map.put("�ڻ��", phone3);
		map.put("�ŷ�ó���", phone4);
		System.out.println("���� ��ȭ��ȣ�� ��� �ο��� = " + map.size());
		
		//�ŷ�ó����� ��ȭ��ȣ�� ����. key �ߺ� ���� ���x key�� Set ���·� ������
		map.put("�ŷ�ó���", new String[] {"010-3240-0353", "slsl07@naver.com"});
		System.out.println("���� ��ȭ��ȣ�� ��� �ο��� = " + map.size());
		
		//map.remove("���ڿ�");
		//System.out.println("���� ��ȭ��ȣ�� ��� �ο��� = " + map.size());
		
		//��ȭ��ȣ�� ��� ����� �̸� ��� key�� set ���·� �����Ǵϱ�
		/*Set<String> names = map.keySet();
		for(String onename : names) {
			System.out.println(onename);
		}*/
		//��ȭ��ȣ�� �̸� : ... ���
		Set<String> names = map.keySet();
		for(String onename : names) {
			String[] phone = map.get(onename);
			System.out.print(onename + " : ");
			for(String one : phone) {
				System.out.print(one + " , ");
			}
			System.out.println();
		}
		//����� �Ű����� ���ڿ� �Է��ϸ�
		//���ڿ��� ��ȭ��ȣ ������ ���
		//Set<String> names3 = map.keySet();
		//String[] phone = map.get(args[0]);
		//System.out.println(phone + " , ");	
		if(map.containsKey(args[0])) { //if�� ���ϴ� ������ ���°�� �ٸ��� ������
			String[] phone = map.get(args[0]); // �迭�̴ϱ� �迭���� �ؾߴ�
			for(String one : phone) {
				System.out.print(one + " , ");
			}
		} else {
			System.out.println("�ش� �̸��� ������� �ʾҽ��ϴ�.");
		}
	}

}
