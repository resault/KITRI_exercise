package com.kitri.cafe.common.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.cafe.common.dao.CommonDao;
import com.kitri.cafe.util.CafeConstance;
import com.kitri.cafe.util.NumberCheck;
import com.kitri.cafe.util.PageNavigation;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int getNextSeq() {
		return sqlSession.getMapper(CommonDao.class).getNextSeq();
	}

	// #### 페이징 처리 ####
	@Override
	public PageNavigation getPageNavigation(Map<String, String> parameter) {
		
		PageNavigation navigation = new PageNavigation();
		
		//새글수
		int newArticleCount = sqlSession.getMapper(CommonDao.class).getNewTotalArticleCount(Integer.parseInt(parameter.get("bcode")));
		navigation.setNewArticleCount(newArticleCount);
		
		//전체글수
		int totalArticleCount = sqlSession.getMapper(CommonDao.class).getTotalArticleCount(parameter);
		navigation.setTotalArticleCount(totalArticleCount);
		
		//전체 페이지수
		int totalPageCount = ( totalArticleCount -1 ) / CafeConstance.ARTICLE_SIZE + 1;
		navigation.setTotalPageCount(totalPageCount);

		
		//이전, 다음 버튼 활성화 여부 설정 (true : 비활성화)
		int pg = NumberCheck.NotNumberToOne(parameter.get("pg"));
		navigation.setNowFirst(pg <= CafeConstance.PAGEE_SIZE);	//이전 버튼
		navigation.setNowEnd((totalPageCount-1) / CafeConstance.PAGEE_SIZE * CafeConstance.PAGEE_SIZE < pg); //다음 버튼
		navigation.setPageNo(pg);
		
		return navigation;
	}



}
