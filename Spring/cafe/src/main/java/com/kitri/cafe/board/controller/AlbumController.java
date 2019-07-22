package com.kitri.cafe.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kitri.cafe.board.model.AlbumDto;
import com.kitri.cafe.board.service.AlbumService;
import com.kitri.cafe.common.service.CommonService;
import com.kitri.cafe.member.model.MemberDto;

@Controller
@RequestMapping("/album")
public class AlbumController {
	
	@Autowired
	private CommonService commonService;

	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private ServletContext servletContext;
	
	// #### 단순 페이지 이동(게시글 작성) ####
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void write(@RequestParam Map<String, String> parameter, Model model) {
		model.addAttribute("parameter", parameter);
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(AlbumDto albumDto,
						@RequestParam("picture") MultipartFile multipartFile,
						@RequestParam Map<String, String> parameter,
						Model model, HttpSession session) {
		
		// 제목, 내용, 파일 받기
		// id, name 세션에서 받기
		
		
		// 로그인 여부 확인
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			
			// 등록할 게시글의 글번호(seq) 받아옴
			int seq = commonService.getNextSeq(); //여러 게시판에서 공통으로 필요한 작업이므로 common에 기능추가
			
			// data setting
			albumDto.setSeq(seq);
			albumDto.setId(memberDto.getId());
			albumDto.setName(memberDto.getName());
			albumDto.setEmail(memberDto.getEmail());
			
			//파일 정보 가져와서 dto에 넣기
			if(multipartFile != null && !multipartFile.isEmpty()) {
				
				// 파일 원래 이름 가져오기
				String originPicture = multipartFile.getOriginalFilename();
				
				// 파일 저장 경로 설정
				String realPath = servletContext.getRealPath("/upload/album"); // 파일 저장 경로
				DateFormat df = new SimpleDateFormat("yyMMdd"); // 날짜 포멧 설정
				String saveFolder = df.format(new Date()); // 오늘 날짜 받아오기
				String realSaveFolder = realPath + File.separator + saveFolder; // 날짜별 폴더 경로 
				File dir = new File(realSaveFolder); // 파일 객체 생성
				
				if(!dir.exists()) {	// 오늘 날짜 폴더 없는 경우
					dir.mkdir(); // 날짜별 폴더 생성
				}
				
				// 새로운 파일 이름 설정
				String savePicture = UUID.randomUUID().toString() + originPicture.substring(originPicture.lastIndexOf('.'));
				
				// 파일 저장
				File file = new File(realSaveFolder, savePicture);
				try {
					multipartFile.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// Dto에 set
				albumDto.setOriginPicture(originPicture);
				albumDto.setSavePicture(savePicture);
				albumDto.setSaveFolder(saveFolder);
			}
			
//			TODO : 1. image file 검사 (확장자가 이미지 파일이 아닌 경우 에러메시지 발생시키기)
//			TODO : 2. thumbnail image 
			seq = albumService.writeArticle(albumDto);
			
			
			
			// insert 실패한 경우 service가 글번호 0을 반환함
			if(seq != 0) {
				model.addAttribute("seq", seq);
			} else {
				model.addAttribute("errorMsg", "서버문제로 글작성에 실패하였습니다. 나중에 다시 시도하세요.");
			}
		} else {
			model.addAttribute("errorMsg", "로그인이 필요한 서비스입니다.");
		}
		model.addAttribute("parameter", parameter);
		return "album/writeok";
	}
}
