package main;

import java.util.ArrayList;

import dao.EmpDAO;
import vo.EmpVO;

public class EmpMain {
	public static void main(String [] args) {
		EmpDAO dao = new EmpDAO();
		
		EmpVO empVO = new EmpVO(500, "�ڻ���", "����", 20, 900000);//5�� �ʵ庯�� �ʱ�ȭ pubic ������ ����
		int rows = dao.insertEmp(empVO);//empVO ���ް� 5���� sysdate�Լ� �Ի��Ϸ�,   EMP ���̺� INSERT ����
		System.out.println(rows + "  ���� �� ����");
				
		ArrayList<EmpVO> list = dao.getEmp();//����-rs-list-��������
		//list��ȸ
		for(EmpVO vo : list) {
			System.out.println(vo/*.toString()*/);
			//���-�̸�-����-...- �Ի��� ���� ��� 
		}
	}
}
//5��2��