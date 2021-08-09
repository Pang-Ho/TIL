package Interface;

public interface RemoteControl {
	public int MAX_VOLUM = 10;
	public int MIN_VOLUM = 0;
	
	public void turnOn();
	public void turnOff();
	public void setVolume(int volume);
	
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("����");
		} else {
			System.out.println("���� ����");
		}
	}
	
	static void changeBattery() {
		System.out.println("������ ��ȯ");
	}
}

