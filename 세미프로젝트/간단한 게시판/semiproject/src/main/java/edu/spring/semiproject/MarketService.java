package edu.spring.semiproject;

import java.util.HashMap;
import java.util.List;

public interface MarketService {
	 //사용자 정보 삽입
	 void user_insert(MarketVO vo);
	 //목록 조회
	 public List<MarketVO> user_list();
	 //사용자 정보 1건 조회
	 public MarketVO user_detail(String id);
	 //고객 정보 변경
	 public void user_update(MarketVO vo);
	 //회원탈퇴
	 public void user_delete(MarketVO vo);

	 //로그인 처리
	 public MarketVO user_login(HashMap<String, String> map);
	 
	 //아이디 중복 확인
	 boolean user_id_check(String id);
	 
	 
	 
	 
}
