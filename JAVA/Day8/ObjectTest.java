package day7;

public class ObjectTest {

	public static void main(String[] args) {
		MyObject o1 = new MyObject("test");
		MyObject o2 = new MyObject("test");
		
		//패키지명.클래스명 + '@' + Integer.toHexString(hashCode()) 16진수(객체주소값)
		//					출력문장 객체 출력시 자동 호출
		//					문장열형태 . 사람들이 이해하기 쉬운 객체 정보 제공
		//사용자가 객체 출력시 출력값을 정하는 메소드임 - 다른 클래스에서 오버라이딩 가능
		System.out.println(o1);
		//System.out.println(o1.toString());
		System.out.println(o2);
		//System.out.println(o2.toString());
		System.out.println(o1.equals(o2)); 
		System.out.println(o1 == o2); // 객체 주소값 비교
	}

}

class MyObject{
	String msg;
	MyObject(String msg){
		this.msg = msg;
	}
	@Override
	public String toString() {
		return msg;
		
		
	}
	@Override
	public boolean equals(Object obj) {
		// equals 메소드 전달 객체 MyObject 타입이고 smg 필드변수값이 같으면 true
		// if(o1.equals(o2)) 호출시에는 obj = o2(상위클래스 obj = 하위객체)  자동 대입 발생
		// if(o1.equals(new String("test"))) 호출해도 obj = nwe String("test") 자동 대입 발생
		// msg 존재x
		if(obj instanceof MyObject) {
			//return toString().Equals(obj.toString()); 밑 내용을 한문장으로 만들기
			
			String me = toString();
			String other = obj.toString();
			if(me.equals(other)) { // 문자열 내용 동등하니
				return true;
			}
			else {
				return false;
			}
		}
		return true;
	}
}