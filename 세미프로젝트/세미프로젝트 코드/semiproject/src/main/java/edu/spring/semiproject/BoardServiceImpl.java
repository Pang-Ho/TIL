package edu.spring.semiproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("saleservice")
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO dao;
	
	@Override
	public void board_insert(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.board_insert(vo);
	}

	@Override
	public List<BoardVO> board_list() {
		// TODO Auto-generated method stub
		return dao.board_list();
	}

	@Override
	public BoardVO board_detail(String id) {
		// TODO Auto-generated method stub
		return dao.board_detail(id);
	}

	@Override
	public void board_cnt(BoardVO vo) {
		dao.board_cnt(vo);
		
	}

	@Override
	public void Board_update(BoardVO vo) {
		dao.Board_update(vo);
		
	}

	@Override
	public void Board_delete(String id) {
		dao.Board_delete(id);
		
	}

}
