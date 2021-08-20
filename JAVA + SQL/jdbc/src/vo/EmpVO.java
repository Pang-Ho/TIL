package vo;
//db에 있는 emp 테이블의 레코드1개 = 6개 컬럼으로 구성돼있음 = 변수 6개
public class EmpVO {
	int id;
	String name;
	String title;
	int dept_id;
	double salary;
	String hiredate; //to_char( ... ) 가져올거니까 string이 편함
	
	//public void setId(){} private int id가 되면 다른 곳에서 못쓰니까 쓰게만들도록 메소드 사용
	//public int getID(){return 1;}
	
	public EmpVO(int id, String name, String title, int dept_id, double salary, String hiredate) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.dept_id = dept_id;
		this.salary = salary;
		this.hiredate = hiredate;
	}
	
	public EmpVO(int id, String name, String title, int dept_id, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.dept_id = dept_id;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return id + "-" + name + "-" + title + "-" + dept_id + "-" + salary + "-" + hiredate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
}
