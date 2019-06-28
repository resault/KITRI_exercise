package com.kitri.cafe.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kitri.cafe.board.model.ReboardDto;
import com.kitri.cafe.board.service.ReboardService;
import com.kitri.cafe.common.service.CommonService;
import com.kitri.cafe.member.model.MemberDto;
import com.kitri.cafe.util.PageNavigation;

@Controller
@RequestMapping("/reboard")
public class ReboardController {
	
	@Autowired
	private CommonService commonService;

	@Autowired
	private ReboardService reboardService;
	
	// #### 단순 페이지 이동(게시글 작성) ####
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void write(@RequestParam Map<String, String> parameter, Model model) {
		model.addAttribute("parameter", parameter);
	}
	 
	
	// #### 게시글 insert ####
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(ReboardDto reboardDto, @RequestParam Map<String, String> parameter, Model model, HttpSession session) {
		
		String path = "";
		
		// 로그인 여부 확인
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			
			// 등록할 게시글의 글번호(seq) 받아옴
			int seq = commonService.getNextSeq(); //여러 게시판에서 공통으로 필요한 작업이므로 common에 기능추가
			
			// data setting
			reboardDto.setSeq(seq);
			reboardDto.setId(memberDto.getId());
			reboardDto.setName(memberDto.getName());
			reboardDto.setEmail(memberDto.getEmail());
			reboardDto.setRef(seq);
			
			seq = reboardService.writeArticle(reboardDto);
			
			// insert 실패한 경우 service가 글번호 0을 반환함
			if(seq != 0) {
				model.addAttribute("seq", seq);
				path = "reboard/writeok";
			} else {
				path = "reboard/writefail";
			}
		} else {
			path = "";
		}
		model.addAttribute("parameter", parameter);
		return path;
	}
	
	
	// #### 글 상세내용 ####
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(@RequestParam("seq") int seq, @RequestParam Map<String, String> parameter, Model model, HttpSession session) {
		
		String path = "";
		
		// 로그인 여부 확인
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			ReboardDto reboardDto = reboardService.viewArticle(seq);
			
			model.addAttribute("article", reboardDto);
			model.addAttribute("parameter", parameter);
			
			path = "reboard/view";
		} else {
			path = "redirect:/index.jsp";
		}
		return path;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(@RequestParam Map<String, String> parameter, Model model, HttpServletRequest request) {
		
		List<ReboardDto> list = reboardService.listArticle(parameter);
		
		// 페이지 처리
		PageNavigation pageNavigation = commonService.getPageNavigation(parameter);
		
		pageNavigation.setRoot(request.getContextPath());
		pageNavigation.makeNavigator();
		
		model.addAttribute("parameter", parameter);
		model.addAttribute("articleList", list);
		model.addAttribute("navigator", pageNavigation);
	}
	
	
	// #### 답글쓰기 ####
	@RequestMapping(value = "/reply", method = RequestMethod.GET)
	public String reply(@RequestParam("seq") int seq, @RequestParam Map<String, String> parameter, Model model, HttpSession session) {
		String path = "";
		
		// 로그인 여부 확인
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			ReboardDto reboardDto = reboardService.getArticle(seq);
			
			model.addAttribute("article", reboardDto);
			model.addAttribute("parameter", parameter);
			
			path = "reboard/reply";
		} else {
			path = "redirect:/index.jsp";
		}
		return path;
	}
	
	
	// #### 답글 insert ####
		@RequestMapping(value = "/reply", method = RequestMethod.POST)
		public String reply(ReboardDto reboardDto, @RequestParam Map<String, String> parameter, Model model, HttpSession session) {
			
			String path = "";
			
			// 로그인 여부 확인
			MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
			if(memberDto != null) {
				
				// 등록할 게시글의 글번호(seq) 받아옴
				int seq = commonService.getNextSeq(); //여러 게시판에서 공통으로 필요한 작업이므로 common에 기능추가
				
				// data setting
				reboardDto.setSeq(seq);
				reboardDto.setId(memberDto.getId());
				reboardDto.setName(memberDto.getName());
				reboardDto.setEmail(memberDto.getEmail());
				
				seq = reboardService.replyArticle(reboardDto);
				
				// insert 실패한 경우 service가 글번호 0을 반환함
				if(seq != 0) {
					model.addAttribute("seq", seq);
					path = "reboard/writeok";
				} else {
					path = "reboard/writefail";
				}
			} else {
				path = "";
			}
			model.addAttribute("parameter", parameter);
			return path;
		}
}


















