package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.BoardDAO;
import dao.EmpDAO;
import vo.BoardVO;
import vo.EmpVO;

public class BoardMain {
	public static void main(String[] args) {
		while(true) {
		System.out.println("===�Խ��� ���� ���α׷�===");
		System.out.println("===1. �۾���===");
		System.out.println("===2. �� ��ȸ===");
		System.out.println("===3. ����===");
		System.out.print("��ȣ�Է� : ");
		
		Scanner key = new Scanner(System.in);
		int menu = key.nextInt();
		if(menu == 3 ) {return; }
		else if(menu == 1) {
			//��ȣ(sequence or max(seq)+1) 
			//���� ���� �ۼ��� 
			//�ð� sysdate
			//��ȣ 
			//��ȸ�� 0
			System.out.println("�����Է� : ");
			String title = key.nextLine();
			key.next();
			System.out.println("�����Է� : ");
			String contents = key.nextLine();
			key.next();
			System.out.println("�ۼ����Է� : ");
			String writer = key.nextLine();
			key.next();
			System.out.println("��ȣ�Է� : ");
			int pasword = key.nextInt();
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContents(contents);
			vo.setWriter(writer);
			vo.setPw(pasword);
			BoardDAO dao = new BoardDAO();
			int rows = dao.insertBoard(vo);
			System.out.println(rows);
		}
		else if(menu == 2) {
			System.out.print("��ȸ �� ��ȣ : ");
			int seq = key.nextInt();
			BoardDAO dao = new BoardDAO();
			BoardVO vo = dao.getBoard(seq);
			System.out.println(vo);
		}
	}
	}
}
