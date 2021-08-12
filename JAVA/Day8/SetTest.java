package settest;

import java.util.HashSet;

class Employee{
	int id;
	String name;
	double pay;
	public Employee(int id, String name, double pay) {
		//super(); ������ ������ ù���忡 �ִ� �� Object��
		this.id = id;
		this.name = name;
		this.pay = pay;
	}
	@Override
	public String toString() { //toString �������̵�
		return id + "-" + name + "-" + pay;
	}
	
}
public class SetTest {

	public static void main(String[] args) {
		HashSet list = new HashSet(5);
		list.add(100); //IntegerŬ������ ����ϴµ� �̹� toString�������̵��� �Ǿ�����.
		list.add(100); //HashSet�� ���� ���� ������ �ȵǱ� ������ �����ع��� ������ �Ȼ���
		list.add(3.14);//DoubleŬ������ ����ϴµ� �̹� toString�������̵��� �Ǿ�����.
		list.add("java");//StringŬ������ ����ϴµ� �̹� toString�������̵��� �Ǿ�����.
		
		Employee e1 = new Employee(100, "����", 99999.99);
		Employee e2 = new Employee(200, "�ڴ븮", 999999.99);
		Employee e3 = new Employee(300, "�ֽ���", 99999.99);
		
		list.add(e1); // ���ϴ� ����� 100-����-99999.99 �̹Ƿ� toString �������̵� �ؾ���
		list.add(e2);
		list.add(e3);
		//list.remove(1);
		//list.set(0, 200); //0�� �ε����� ���� 200���� ����
		System.out.println(list.size());
		
		for(Object one : list) {
			System.out.println(one); //���� Ÿ������ Object�� �ޱ� ������ toString�� ����ؾ� ���ϴ� �� ���� �� ����.
		}
		//java ���ڿ��� �����ϴ��� �˾ƺ��� ���
		boolean search = list.contains(args[0]);
		System.out.println(search);
		
		
		
	}

}
