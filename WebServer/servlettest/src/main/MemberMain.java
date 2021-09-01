package main;

import dao.MemberDAO;

public class MemberMain {

	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		String result = dao.getMember("member1", "1111");
		System.out.println(result);
	}

}
