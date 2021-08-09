package study;

public class EceptionExample {

	public static void main(String[] args) {
		int i = Integer.parseInt(args[0]);
		int j = Integer.parseInt(args[1]);
		try {
		
			System.out.println(i / j);
		} catch(ArithmeticException e) {
			System.out.println("0제외");
			e.printStackTrace();
		} catch(Exception e) {
			j = 100;
			System.out.println("0을 넣어서 1000으로 만들어쪙");
			e.printStackTrace();
		}
	}

}
