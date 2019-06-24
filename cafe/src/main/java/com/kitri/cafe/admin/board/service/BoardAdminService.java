package com.kitri.cafe.admin.board.service;

import java.util.List;

import com.kitri.cafe.admin.board.model.BoardListDto;
import com.kitri.cafe.admin.board.model.BoardTypeDto;
import com.kitri.cafe.admin.board.model.CategoryDto;

public interface BoardAdminService {

	// 게시판 목록
	List<BoardListDto> getBoardMeneList(int ccode); // 카테고리별 게시판 목록 불러오기 (인자값이 0인 경우 전체 게시판 목록)
	
	// 카테고리 생성
	List<CategoryDto> getCategoryList(); // 카테고리 목록 불러오기
	void makeCategory(CategoryDto categoryDto); // 카테고리 생성
	
	// 게시판 생성
	List<BoardTypeDto> getBoardTypeList(); // 게시판 형식
	void makeBoard(BoardListDto boardListDto); // 게시판 생성
	
}
