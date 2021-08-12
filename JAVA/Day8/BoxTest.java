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
class Box<T> {//Object 대신에 Type을 남겨줄게  제네릭 클래스 정의
	/*Object*/ T contents; //apple이나 paper 타입 둘다 가능하게
	void setContents(T contents) {
		this.contents = contents;
	}
	T getContents() {
		return contents;
	}
}
public class BoxTest {
public static void main(String[] args) {
	Apple a = new Apple("경북");
	Box<Apple> aBox = new Box<Apple>();
	aBox.setContents(a);
	Apple o = aBox.getContents();
	System.out.println(o.origin);
	
	Paper p = new Paper("A4사이즈");
	Box<Paper> pBox = new Box<Paper>();
	pBox.setContents(p);
	System.out.println(pBox.getContents().size);
}
}
