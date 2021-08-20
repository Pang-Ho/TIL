package main;

import java.util.ArrayList;

import dao.EmpDAO;
import vo.EmpVO;

public class EmpMain {
	public static void main(String [] args) {
		EmpDAO dao = new EmpDAO();
		
		EmpVO empVO = new EmpVO(500, "박사장", "사장", 20, 900000);//5개 필드변수 초기화 pubic 생성자 정의
		int rows = dao.insertEmp(empVO);//empVO 전달값 5개와 sysdate함수 입사일로,   EMP 테이블 INSERT 구현
		System.out.println(rows + "  개의 행 삽입");
				
		ArrayList<EmpVO> list = dao.getEmp();//연결-rs-list-연결해제
		//list조회
		for(EmpVO vo : list) {
			System.out.println(vo/*.toString()*/);
			//사번-이름-직급-...- 입사일 형식 출력 
		}
	}
}
//5시2분