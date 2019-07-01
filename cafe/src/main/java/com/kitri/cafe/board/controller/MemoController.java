package com.kitri.cafe.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kitri.cafe.board.model.MemoDto;
import com.kitri.cafe.board.service.MemoService;
import com.kitri.cafe.member.model.MemberDto;

@RestController	//모두 responsebody로 넘어감
@RequestMapping("/memo")
public class MemoController {

	@Autowired
	private MemoService memoService;
	
//	class에 그냥 @Controller로 설정한 경우
//	@RequestMapping(method = RequestMethod.POST, headers = {"Content-Type=application/json"})
//	public @ResponseBody String write(@RequestBody MemoDto memoDto, HttpSession session) { //JSON으로 넘어오는 것 받을 때 : @RequestBody, JOSN으로 넘길때 : @ResponseBody
//		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
//		if(memberDto != null) {
//			memoDto.setId(memberDto.getId());
//			memoDto.setName(memberDto.getName());
//			
//			memoService.writeMemo(memoDto);
//			
//			String json = memoService.listMemo(memoDto.getSeq());
//			return json;
//		}
//		return "";
//	}
//	
//	
//	@RequestMapping(method = RequestMethod.GET, headers = {"Content-Type=application/json"})
//	public @ResponseBody String list(int seq) {
//		String json = memoService.listMemo(seq);
//		return json;
//	}
	
	
//	class를 @RestController로 설정한 경우
	@RequestMapping(method = RequestMethod.POST, headers = {"Content-Type=application/json"})
	public String write(@RequestBody MemoDto memoDto, HttpSession session) { //JSON으로 넘어오는 것 받을 때 : @RequestBody, JOSN으로 넘길때 : @ResponseBody
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			memoDto.setId(memberDto.getId());
			memoDto.setName(memberDto.getName());
			
			memoService.writeMemo(memoDto);
			
			String json = memoService.listMemo(memoDto.getSeq());
			return json;
		}
		return "";
	}
	
	
	@RequestMapping(method = RequestMethod.GET, headers = {"Content-Type=application/json"})
	public String list(int seq) {
		String json = memoService.listMemo(seq);
		return json;
	}
	
	
	@RequestMapping(value = "/{seq}/{mseq}", method = RequestMethod.DELETE, consumes = "application/json", headers = {"Content-Type=application/json"})
	public String delete(@PathVariable(name = "seq") int seq, @PathVariable(name = "mseq") int mseq) {
		String json = memoService.deleteMemo(seq, mseq);
		return json;
	}
	
	
}
