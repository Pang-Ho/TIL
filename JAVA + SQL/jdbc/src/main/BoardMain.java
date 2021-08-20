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
		System.out.println("===게시판 관리 프로그램===");
		System.out.println("===1. 글쓰기===");
		System.out.println("===2. 글 조회===");
		System.out.println("===3. 종료===");
		System.out.print("번호입력 : ");
		
		Scanner key = new Scanner(System.in);
		int menu = key.nextInt();
		if(menu == 3 ) {return; }
		else if(menu == 1) {
			//번호(sequence or max(seq)+1) 
			//제목 내용 작성자 
			//시간 sysdate
			//암호 
			//조회수 0
			System.out.println("제목입력 : ");
			String title = key.nextLine();
			key.next();
			System.out.println("내용입력 : ");
			String contents = key.nextLine();
			key.next();
			System.out.println("작성자입력 : ");
			String writer = key.nextLine();
			key.next();
			System.out.println("암호입력 : ");
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
			System.out.print("조회 글 번호 : ");
			int seq = key.nextInt();
			BoardDAO dao = new BoardDAO();
			BoardVO vo = dao.getBoard(seq);
			System.out.println(vo);
		}
	}
	}
}
