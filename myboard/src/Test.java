import java.util.List;

import com.kitri.dto.RepBoardDto;
import com.kitri.service.RepBoardService;

public class Test {

	public static void main(String[] args) {
		int currentPage = 12;
		
		int cntPerPage = 10;
		
		int endRow = currentPage * cntPerPage;
		int startRow = endRow - cntPerPage + 1;
		
		
		//----------------------------------------------------------------------------------
		//총페이지 수 계산
		
		int totalPage = 1;
		
		int totalCnt = 150; //총 게시글 수 
		totalPage = (int)Math.ceil((float)totalCnt/cntPerPage);	//총 페이지 수
		//---------------------------------------------------------------------------------
		
		
		int cntPerPageGroup = 3;	//페이지 그룹에 보여줄 페이지 수
		int cntPageGroup = totalPage / cntPerPageGroup;
		int endPage = 0;
		int startPage = 0;
		
		
		for(int i=1; i<=cntPageGroup+1; i++) {
			endPage = i * cntPerPageGroup;
			startPage = 1 + (i-1)*cntPerPageGroup;
			
			if(endPage+cntPageGroup > totalPage) {
				endPage = totalPage;
				startPage = cntPageGroup * cntPerPageGroup + 1;
			}
			
			if(currentPage >= startPage && currentPage <= endPage) {
				break;
			} 
				
		}
		
		
		System.out.println("시작 페이지: " + startPage);
		System.out.println("끝 페이지: " + endPage);
		System.out.println("전체 페이지: " + totalPage);
		
		
	}
}
