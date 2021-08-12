package day8;

class Apple {
	String origin;
	Apple(String origin){
		this.origin = origin;
	}
}
class Paper {
	String size;
	Paper(String size){
		this.size = size;
	}
}
class Box<T> {//Object ��ſ� Type�� �����ٰ�  ���׸� Ŭ���� ����
	/*Object*/ T contents; //apple�̳� paper Ÿ�� �Ѵ� �����ϰ�
	void setContents(T contents) {
		this.contents = contents;
	}
	T getContents() {
		return contents;
	}
}
public class BoxTest {
public static void main(String[] args) {
	Apple a = new Apple("���");
	Box<Apple> aBox = new Box<Apple>();
	aBox.setContents(a);
	Apple o = aBox.getContents();
	System.out.println(o.origin);
	
	Paper p = new Paper("A4������");
	Box<Paper> pBox = new Box<Paper>();
	pBox.setContents(p);
	System.out.println(pBox.getContents().size);
}
}
