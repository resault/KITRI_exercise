package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.MemoDto;

public interface MemoService {

	void writeMemo(MemoDto memoDto);	// 글작성 후 글번호 반환
	List<MemoDto> listMemo(Map<String, String> parameter); // 글 목록 가져오기 (받아올 항목이 여러개이므로 Map으로 받아옴)
	void modifyMemo(MemoDto memoDto); // 글 수정
	void deleteMemo(int mseq); // 글 삭제
}
