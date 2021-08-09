package study;

class Tire1 {
	public void run() {
		System.out.println("ÀÏ¹Ý Å¸ÀÌ¾î ±¼±¼");
	}
}
class SnowTire extends Tire1{
	public void run() {
		System.out.println("½º³ë¿ì Å¸ÀÌ¾î ±¼±¼");
	}
}
public class SnowTireExample {
public static void main(String[] args) {
		// TODO Auto-generated method stub
	SnowTire s = new SnowTire();
	Tire1 t = new Tire1();
	Tire1 t1 = new SnowTire();
	
	t1.run();
	t.run();
	s.run();
	
	}

}
