package main;

import java.util.ArrayList;

import dao.EmpDAO;
import vo.EmpVO;

public class EmpMain {
	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		
		EmpVO empVO = new EmpVO(500, "박사장", "사장", 20, 900000);
		int rows = dao.insertEmp(empVO);//전달받은 empVO 값 5개와 sysdate함수 입사일로 EMP 테이블 insert 구현
		System.out.println(rows + " 개의 행 삽입");
		
		ArrayList<EmpVO> list = dao.getEmp(); //연결 - rs - list - 연결해제 그러나 list는 남아있음 그걸 사용할거임
		
		for(EmpVO vo : list) {
			System.out.println(vo); //사번-이름-직급-... 형식으로 출력하고 싶음 toString 오버라이딩 하장 
		}
	}
}
