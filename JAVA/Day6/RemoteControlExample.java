package study;

import Interface.RemoteControl;

class Television implements RemoteControl {
	private int volume;
	
	public void turnOn() {
		System.out.println("TV ÄÑÁü");
	}
	public void turnOff() {
		System.out.println("TV ²¨Áü");
	}
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUM) {
			this.volume = RemoteControl.MAX_VOLUM;
		} else if(volume < RemoteControl.MIN_VOLUM) {
			this.volume = RemoteControl.MIN_VOLUM;
		} else {
			this.volume = volume;
		}
		System.out.println("ÇöÀç TV º¼·ý : " + this.volume);
	}
	
}
public class RemoteControlExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteControl rc;
		rc = new Television();
		rc.setVolume(4);
	}

}
