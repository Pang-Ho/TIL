package vo;
//emp 테이블 레코드 1개 = 6개 컬럼 구성 = 변수 6개
public class EmpVO {
	int id;
	String name;
	String title;
	int dept_id;
	double salary;
	String hiredate;//to_char(,,,)
	public EmpVO(int id, String name, String title, int dept_id, double salary, String hiredate) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.dept_id = dept_id;
		this.salary = salary;
		this.hiredate = hiredate;
	}
	
	public EmpVO(int id, String name, String title, int dept_id, double salary) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.dept_id = dept_id;
		this.salary = salary;
	}

	@Override
	public String toString() {
		//사번-이름-직급-...- 입사일 형식 출력 
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
