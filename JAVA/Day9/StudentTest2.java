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
	//input.dat ���� �Է��ؾ���
	FileReader fr = new FileReader("input.dat");
	//Filenotfound ����ó�� �ض�, close �ض�
	//fr.read() �� 2����Ʈ ������ ó�� ���ؼ� �� ����
	Scanner s = new Scanner(fr); //Ű����� ���� �� �� ���� �� �ִ�~ �����̸� fr�� �ְ� Ű����� System.in)
	
	//���1
	/*
	while(s.hasNextLine() == true) {
		String line = s.nextLine();  //���� ���� ����  => ����� 99 100 45
		String inform[] = line.split(" "); // ����� �������� �߶�
	
		Student s1 = new Student(inform[0] ,Integer.parseInt(inform[1]) , Integer.parseInt(inform[2]), Integer.parseInt(inform[3]));
		
		s1.calc();
		System.out.println(s1);
	}
	*/
	//���2
	while(s.hasNext() ==true) {
		/*s.next(); //�����
		s.nextInt(); //99
		s.nextInt(); //100
		s.nextInt(); //45*/
		Student s1 = new Student(s.next(), s.nextInt(), s.nextInt(), s.nextInt());
		s1.calc();
		list.add(s1);
	}
	
	int maxSum = 0;
	int rank = 0; //�ִ� ������ ���� �л��� list index�� �˰���� ��
	for(int i = 0; i < list.size() ; i++) {
		if(list.get(i).sum > maxSum) {
			maxSum = one.sum;
			rank = i;
		}
	}
	//���� ���
	FileWriter fw = new FileWriter("output.dat");
	for(Student one : list) {
		fw.write(one.toString() + "\n");
		
	}
	fw.write("\n");
	fw.write("1��" + list.get(rank).name + " " + list.get(rank).sum + " " + list.get(rank).avg);
	fr.close();
	fw.close();
}
}