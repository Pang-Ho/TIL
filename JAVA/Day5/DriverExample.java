package study;

class Vehicle {
	public void run() {
		System.out.println("달립니다.");
	}
}

class Driver {
	public void drive(Vehicle vehicle) {
		vehicle.run();
	}
}

class Bus extends Vehicle {
	public void run() {
		System.out.println("버스가 달립니다.");
	}
}

class Taxi extends Vehicle {
	public void run() {
		System.out.println("택시가 달립니다.");
	}
}
public class DriverExample {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.drive(bus);
		driver.drive(taxi);
	}

}
