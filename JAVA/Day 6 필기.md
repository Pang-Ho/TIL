# Day 6

## 인터페이스

인터페이스 = 다중상속

* 학생과 교직원 특징을 가진 클래스가 있다.

  조교는 학생과 교직원 특정 모두 가지고 있으므로

  class 조교 extends 학생, 교직원 (??)  => 불가능

* 다중상속을 위해 학생과 교직원 클래스를 인터페이스로 변경

  **class 조교 implements 학생, 교직원** 

implement(구현)

| 개발 코드 -메소드호출----><br />                <-----리턴 값---- | 인터페이스 --메소드호출----><br />                   <------리턴 값----<br />                      추상 메소드 | 구현 객체<br /><br />실체 메소드 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | -------------------------------- |

* 인터페이스는?
1. 개발 코드와 객체가 서로 통신하는 접점이다.

   개발코드가 왜 직접 객체의 메소드를 호출하지 않을까?

   ㄴ 인터페이스는 다양한 객체를 사용하면서 개발 코드는 변경없이 실행 내용과 		리턴값을 다양하게 사용할 수 있도록

| 클래스<br />필드, 생성자, 메소드 | 인터페이스<br />상수, 메소드(추상, 디폴트, 정적) |
| -------------------------------- | ------------------------------------------------ |

* 상수 필드

  (public static final) int MAX_VOLUME = 10;

  자동적으로 public static final이 붙음

  상수 필드 변수명은 모두 대문자, _(언더바) 이용해서 만듦

  반드시 초기값 대입해야함.

* 추상 메소드

  인터페이스로 호출된 메소드는 최종적으로 객체에서 실행됨(실행 블록 없음)

  public void method ( );

* 디폴트 메소드

  (public) default void setMute( boolean mute ) { ... }

* 정적 메소드

  (public) static void changeBattery( ... ) { ... }

### 구현 클래스

* 보통 클래스와 동일함

* implements 인터페이스 명 을 명시해서 인터페이스 타입으로 사용할 수 있음을 알려줘야함

* 인터페이스에서 선언된 추상메소드를 구현클래스에서 구현 메소드로 작성하지 않으면 

  구현클래스는 자동적으로 추상클래스가 된다
  ㄴ 객체 생성 불가!

### 인터페이스 선언

* RemoteControl rc;	=> 인터페이스 변수 선언 

  rc = new Television;	=> 변수에 구현 객체 대입

```java
package Interface;
public interface RemoteControl {
	public int MAX_VOLUM = 10;
	public int MIN_VOLUM = 0;
	
	public void turnOn();
	public void turnOff();
	public void setVolume(int volume);
	
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음");
		} else {
			System.out.println("무음 해제");
		}
	}
	
	static void changeBattery() {
		System.out.println("건전지 교환");
	}
}
```

```java
import Interface.RemoteControl;

class Television implements RemoteControl {
	private int volume;
	
	public void turnOn() {
		System.out.println("TV 켜짐");
	}
	public void turnOff() {
		System.out.println("TV 꺼짐");
	}
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUM) {
			this.volume = RemoteControl.MAX_VOLUM;
		} else if(volume < RemoteControl.MIN_VOLUM) {
			this.volume = RemoteControl.MIN_VOLUM;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨 : " + this.volume);
	}
	
}
public class RemoteControlExample {
	public static void main(String[] args) {
		RemoteControl rc;
		rc = new Television();
	}
}
```



