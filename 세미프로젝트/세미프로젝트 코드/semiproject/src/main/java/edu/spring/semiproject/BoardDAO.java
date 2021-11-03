package edu.spring.semiproject;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO implements BoardService {
	@Autowired
	SqlSession session;
	
	@Override
	public void board_insert(BoardVO vo) {
		// TODO Auto-generated method stub
		session.insert("sale.insert", vo);
	}

	@Override
	public List<BoardVO> board_list() {
		// TODO Auto-generated method stub
		List<BoardVO> list = session.selectList("sale.list");
		return list;
	}

	@Override
	public BoardVO board_detail(String id) {
		// TODO Auto-generated method stub
		return session.selectOne("sale.detail", id);
	}

	@Override
	public void board_cnt(BoardVO vo) {
		session.update("sale.cnt", vo);
		
	}

	@Override
	public void Board_update(BoardVO vo) {
		session.update("sale.update", vo);
		
	}

	@Override
	public void Board_delete(String id) {
		session.delete("sale.delete", id);
		
	}

}
