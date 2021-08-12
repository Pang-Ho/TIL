package day8;

import java.util.ArrayList;

class Employee{
	int id;
	String name;
	double pay;
	public Employee(int id, String name, double pay) {
		//super(); 언제나 생성자 첫문장에 있는 놈 Object꺼
		this.id = id;
		this.name = name;
		this.pay = pay;
	}
	@Override
	public String toString() { //toString 오버라이딩
		return id + "-" + name + "-" + pay;
	}
	
}
public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList list = new ArrayList(5);
		list.add(100); //Integer클래스로 취급하는데 이미 toString오버라이딩이 되어있음.
		list.add(100);
		list.add(3.14);//Double클래스로 취급하는데 이미 toString오버라이딩이 되어있음.
		list.add("java");//String클래스로 취급하는데 이미 toString오버라이딩이 되어있음.
		
		Employee e1 = new Employee(100, "김사원", 99999.99);
		Employee e2 = new Employee(200, "박대리", 999999.99);
		Employee e3 = new Employee(300, "최신입", 99999.99);
		
		list.add(e1); // 원하는 결과는 100-김사원-99999.99 이므로 toString 오버라이딩 해야함
		list.add(e2);
		list.add(e3);
		//list.remove(1);
		//list.set(0, 200); //0번 인덱스의 값을 200으로 세팅
		System.out.println(list.size());
		
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i)); //리턴 타입으로 Object를 받기 때문에 toString을 사용해야 원하는 값 뽑을 수 있음.
		}
		//java 문자열을 포함하는지 알아보는 방법
		boolean search = list.contains(args[0]);
		if(search) {
			int index = list.indexOf(args[0]);
			System.out.println(index);
		}
		else {
			System.out.println("없다");
		}
		
		
		
	}

}
