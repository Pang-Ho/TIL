package day7;

public class ObjectTest {

	public static void main(String[] args) {
		MyObject o1 = new MyObject("test");
		MyObject o2 = new MyObject("test");
		
		//��Ű����.Ŭ������ + '@' + Integer.toHexString(hashCode()) 16����(��ü�ּҰ�)
		//					��¹��� ��ü ��½� �ڵ� ȣ��
		//					���忭���� . ������� �����ϱ� ���� ��ü ���� ����
		//����ڰ� ��ü ��½� ��°��� ���ϴ� �޼ҵ��� - �ٸ� Ŭ�������� �������̵� ����
		System.out.println(o1);
		//System.out.println(o1.toString());
		System.out.println(o2);
		//System.out.println(o2.toString());
		System.out.println(o1.equals(o2)); 
		System.out.println(o1 == o2); // ��ü �ּҰ� ��
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
		// equals �޼ҵ� ���� ��ü MyObject Ÿ���̰� smg �ʵ庯������ ������ true
		// if(o1.equals(o2)) ȣ��ÿ��� obj = o2(����Ŭ���� obj = ������ü)  �ڵ� ���� �߻�
		// if(o1.equals(new String("test"))) ȣ���ص� obj = nwe String("test") �ڵ� ���� �߻�
		// msg ����x
		if(obj instanceof MyObject) {
			//return toString().Equals(obj.toString()); �� ������ �ѹ������� �����
			
			String me = toString();
			String other = obj.toString();
			if(me.equals(other)) { // ���ڿ� ���� �����ϴ�
				return true;
			}
			else {
				return false;
			}
		}
		return true;
	}
}