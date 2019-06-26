package com.kitri.cafe.board.dao;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.BoardDto;

public interface BoardDao {

	int writeArticle(BoardDto boardDto);	// 글작성 후 글번호 반환
	List<BoardDto> listArticle(Map<String, String> parameter); // 글 목록 가져오기 (받아올 항목이 여러개이므로 Map으로 받아옴)
	BoardDto viewArticle(int seq); // 글 보기
	int modifyArticle(BoardDto boardDto); // 글 수정
	void deleteArticle(int seq); // 글 삭제
}
