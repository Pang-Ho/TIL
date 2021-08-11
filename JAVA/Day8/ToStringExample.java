package day7;

class SmartPhone {
	private String com;
	private String os;
	
	public SmartPhone(String com, String os) {
		this.com = com;
		this.os = os;
	}
	
	public String toString() {
		return com + ", " + os;
	}
}
public class ToStringExample {
	public static void main(String args[]) {
		SmartPhone myPhone = new SmartPhone("삼성", "안드로이드");
		
		System.out.println(myPhone);
	}
}
