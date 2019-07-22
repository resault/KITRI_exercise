package com.kitri.cafe.board.dao;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.ReboardDto;

public interface ReboardDao {

	int writeArticle(ReboardDto reboardDto);	// 글작성 후 글번호 반환
	List<ReboardDto> listArticle(Map<String, String> parameter); // 글 목록 가져오기 (받아올 항목이 여러개이므로 Map으로 받아옴)
	ReboardDto viewArticle(int seq); // 글 보기
	int modifyArticle(ReboardDto reboardDto); // 글 수정
	int deleteArticle(int seq); // 글 삭제
	int deleteArticleF(int seq); // 글 삭제
	
	void updateStep(ReboardDto reboardDto);
	int replyArticle(ReboardDto reboardDto);
	void updateReply(int pseq);
	
}
