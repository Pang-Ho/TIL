package edu.spring.semiproject;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MarketDAO implements MarketService {
	
	@Autowired
	SqlSession session;
	
	@Override
	public void user_insert(MarketVO vo) {
		session.insert("user.insert", vo);
	}

	@Override
	public List<MarketVO> user_list() {
		// TODO Auto-generated method stub
		return session.selectList("user.list");
	}

	@Override
	public MarketVO user_detail(String id) {
		// TODO Auto-generated method stub
		return session.selectOne("user.detail", id);
	}

	@Override
	public void user_update(MarketVO vo) {
		// TODO Auto-generated method stub
		session.update("user.update", vo);
	}

	@Override
	public void user_delete(MarketVO vo) {
		// TODO Auto-generated method stub
		session.delete("user.delete", vo);
}

	@Override
	public MarketVO user_login(HashMap<String, String> map) {
		return session.selectOne("user.login", map);
	}

	@Override
	public boolean user_id_check(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
