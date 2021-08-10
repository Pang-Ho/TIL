package day7;

class BalanceInsufficientException extends Exception {
	public BalanceInsufficientException() {	}
	public BalanceInsufficientException(String message) {
		super(message);
	}
}

class Account {
	private long balance;
	public Account() { } 
	
	public long getBalance () {
		return balance;
	}
	public void deposit(int money) {
		balance += money;
	}
	public void withdraw(int money) throws BalanceInsufficientException {
		if(balance < money) {
			throw new BalanceInsufficientException("�ܰ���� : " + (money - balance) + " ���ڶ�");
		}
		balance -= money;
	}
}
public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		//����
		account.deposit(10000);
		System.out.println("���ݾ� : " + account.getBalance());
		//���
		try {
		account.withdraw(30000);
		} catch(BalanceInsufficientException e) {
			String message = e.getMessage();
			System.out.println(message);
			System.out.println();
			e.printStackTrace();
		}
	}

}
