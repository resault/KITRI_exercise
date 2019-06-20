package com.kitri.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
//	@Qualifier("Impl1")
	private MemberService memberService;
	
	@RequestMapping(value = "register.kitri", method = RequestMethod.GET)
	public String register() {
		return "user/member/member";
	}

	@RequestMapping(value = "register.kitri", method = RequestMethod.POST)
	public String register(MemberDetailDto memberDetailDto, Model model) {
		int cnt = memberService.registerMember(memberDetailDto);
		if(cnt != 0) {
			model.addAttribute("userInfo", memberDetailDto);
			return "user/member/registerok";
		}
		return "user/member/registerfail";
	}
	
	@RequestMapping(value = "idcheck.kitri")
//	@ResponseBody
	public @ResponseBody String idcheck(@RequestParam(name = "checkid", defaultValue = "") String id) {
//		logger.info("검색 아이디 : " + checkid);
		String jason = memberService.idCheck(id);
		return jason;	// view의 이름이 아니라, 응답내용 자체라는 것을 알리기 위해 @ResponseBody
	}

	@RequestMapping(value = "zipsearch.kitri")
	@ResponseBody
	public String zipsearch(@RequestParam("doro") String doro) {
//		logger.info("검색할 도로명 : " + doro);
		String jason = memberService.zipSearch(doro);
		return jason;
	}
	

	@RequestMapping("login.kitri")
	public String login() {
		return "user/login/login";
	}
	
	
	
}
