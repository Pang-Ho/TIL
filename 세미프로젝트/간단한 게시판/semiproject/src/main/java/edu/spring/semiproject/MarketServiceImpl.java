package edu.spring.semiproject;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class MarketServiceImpl implements MarketService{
	@Autowired
	MarketDAO dao;

	@Override
	public void user_insert(MarketVO vo) {
		dao.user_insert(vo);
		
	}

	@Override
	public List<MarketVO> user_list() {
		// TODO Auto-generated method stub
		return dao.user_list();
	}

	@Override
	public MarketVO user_detail(String id) {
		// TODO Auto-generated method stub
		return dao.user_detail(id);
	}

	@Override
	public void user_update(MarketVO vo) {
		dao.user_update(vo);
	}

	@Override
	public void user_delete(MarketVO vo) {
		dao.user_delete(vo);
	}

	@Override
	public MarketVO user_login(HashMap<String, String> map) {
		return dao.user_login(map);
	}

	@Override
	public boolean user_id_check(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	


	

}
