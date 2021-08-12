package day9;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Student {
	String name;
	int kor, eng, mat, sum, avg;
	
	public Student(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	void calc() {
		sum = kor + eng + mat;
		avg = sum / 3;
	}
	@Override
	public String toString() {
		return name + "-" + kor + "-" + eng + "-" + mat + "-" + sum + "-" + avg;
	}
	
	
}
public class StudentTest2 {
public static void main(String[] args) throws IOException {
	//input.dat 파일 입력해야함
	FileReader fr = new FileReader("input.dat");
	//Filenotfound 예외처리 해라, close 해라
	//fr.read() 은 2바이트 정수를 처리 못해서 얘 못씀
	Scanner s = new Scanner(fr); //키보드랑 파일 둘 다 들어올 수 있다~ 파일이면 fr을 넣고 키보드면 System.in)
	
	//방법1
	/*
	while(s.hasNextLine() == true) {
		String line = s.nextLine();  //한줄 읽은 상태  => 김수미 99 100 45
		String inform[] = line.split(" "); // 빈공간 기준으로 잘라
	
		Student s1 = new Student(inform[0] ,Integer.parseInt(inform[1]) , Integer.parseInt(inform[2]), Integer.parseInt(inform[3]));
		
		s1.calc();
		System.out.println(s1);
	}
	*/
	//방법2
	while(s.hasNext() ==true) {
		/*s.next(); //김수미
		s.nextInt(); //99
		s.nextInt(); //100
		s.nextInt(); //45*/
		Student s1 = new Student(s.next(), s.nextInt(), s.nextInt(), s.nextInt());
		s1.calc();
		list.add(s1);
	}
	
	int maxSum = 0;
	int rank = 0; //최대 총점을 가진 학생이 list index를 알고싶은 것
	for(int i = 0; i < list.size() ; i++) {
		if(list.get(i).sum > maxSum) {
			maxSum = one.sum;
			rank = i;
		}
	}
	//파일 출력
	FileWriter fw = new FileWriter("output.dat");
	for(Student one : list) {
		fw.write(one.toString() + "\n");
		
	}
	fw.write("\n");
	fw.write("1등" + list.get(rank).name + " " + list.get(rank).sum + " " + list.get(rank).avg);
	fr.close();
	fw.close();
}
}