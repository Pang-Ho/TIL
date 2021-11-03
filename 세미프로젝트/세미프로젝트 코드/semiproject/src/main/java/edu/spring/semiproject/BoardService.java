package edu.spring.semiproject;

import java.util.List;

public interface BoardService {
	//글 저장
	void board_insert(BoardVO vo);
	//글 목록 조회
	List<BoardVO> board_list();
	//글 상세내용 조회
	BoardVO board_detail(String id);
	//글 조회수 증가
	void board_cnt(BoardVO vo);
	//글 변경
	void Board_update(BoardVO vo);
	//글 삭제
	void Board_delete(String id);
}
