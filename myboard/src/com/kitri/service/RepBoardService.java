package com.kitri.service;

import com.kitri.dao.RepBoardDAO;
import com.kitri.dto.RepBoardDto;
import com.kitri.exception.AddException;

public class RepBoardService {

	private static RepBoardService repBoardService;
	
	static {
		repBoardService = new RepBoardService();
	}
	
	private RepBoardService() {}

	public static RepBoardService getRepBoardService() {
		return repBoardService;
	}
	
	
	public void write(RepBoardDto repBoardDto) throws AddException {
		repBoardDto.setParent_seq(0);
		RepBoardDAO.getRepBoardDAO().insert(repBoardDto);
	}

	public void reply(RepBoardDto repBoardDto) throws AddException {
		if(repBoardDto.getParent_seq() != 0) { 
			RepBoardDAO.getRepBoardDAO().insert(repBoardDto);
		} else {
			throw new AddException("부모글번호가 없는 답글입니다.");
		}
	}
	
}
