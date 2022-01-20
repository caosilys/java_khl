package kr.green.khl.utils;

import lombok.Data;

@Data
public class PageMaker {
	
	private int totalCount;		// 가져올 게시글 수 (전체)
	private int startPage;		// 게시글 수 대비 staetPage가 몇 페이지인지
	private int endPage;		// 게시글 수 대비 endPage가 몇 페이지 인지
	
	private boolean prev; 		// prev 활성화 여부
	private boolean next;		// next 활성화 여부
	
	private String type;		// 가져올 게시글 타입
	private String search;		// 검색시 검색어
	
	private Integer page; 					// 현재 페이지 정보
	private int displayPageButton;	// 페이지네이션에 보여줄 버튼 수	
	private int perPageNum;			// 한 페이지에 보여줄 게시글 수
	
	public PageMaker() {
		this.page = 1;
		this.displayPageButton = 5;
		this.perPageNum = 5;
		this.type = "일반";
		this.search = "";
	}
	
	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
	
	public void setCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	
	/* endPage, startPage, prev, next 값 계산 */
//	public void calcData() {
//									
//		int maxEndPage = (int)(Math.ceil(totalCount/(double)perPageNum));
//		/* 현재 페이지가 1페이지면 prev가 없어야 함 */
//		prev = page == 1 ? false : true;
//		
//		/* 현재 페이지가 마지막 페이지이면 next가 없어야함 */
//		next = page >= maxEndPage ? false : true;
//		
//		
//		// 전체 페이지 수가, 표시해고자 하는 페이지 버튼 수 보다 작은경우
//		if(maxEndPage <= displayPageButton) {
//			startPage = 1;
//			endPage = maxEndPage;
//			return;
//		}
//		
//		// 그렇지 않은경우		
//		int harf = displayPageButton / 2;
//		
//		// 표시하고자 하는 버튼은 현제 페이지를 기준으로
//		// 절반은 왼쪽에 절반은 오른쪽에 배치
//		startPage = page - harf < 1 ? 1 : page-harf;
//		
//		startPage = maxEndPage-displayPageButton+1 <= startPage ?  maxEndPage-displayPageButton+1 : startPage;
//		
//		// 표시하고자 하는 버튼개수가 짝수이면 오른쪽에 한개 덜 배치 
//		if(displayPageButton%2 == 0) {
//			endPage = page + harf-1 > maxEndPage ? maxEndPage : page+harf-1;			
//		}
//		else {
//			endPage = page + harf > maxEndPage ? maxEndPage : page+harf;
//		}
//		
//		endPage = startPage+displayPageButton-1 >= endPage ? startPage+displayPageButton-1 : maxEndPage;			
//
//	}
//
	public void calcData() {
		
		int maxEndPage = (int)(Math.ceil(totalCount/(double)perPageNum));
		/* 현재 페이지가 1페이지면 prev가 없어야 함 */
		prev = page == 1 ? false : true;
		
		/* 현재 페이지가 마지막 페이지이면 next가 없어야함 */
		next = page >= maxEndPage ? false : true;
		
		
		int harf = displayPageButton / 2;
		
		// 전체 페이지 수가, 표시해고자 하는 페이지 버튼 수 보다 작은경우
		if(maxEndPage <= displayPageButton) {
			startPage = 1;
			endPage = maxEndPage;
			return;
		}
		
		// 현재 페이지가 앞부분
		if(page <= harf) {
			startPage = 1;
			endPage = displayPageButton;
			return ;
		}
		
		//displayPageButton 홀수인 경우에서 현재 페이지가 가운대로 가는 경우
		if(displayPageButton % 2 != 0 && page + harf <= maxEndPage) {
			startPage = page - harf;
			endPage = page + harf;
			return;
		}
		
		//displayPageButton 짝인 경우에서 현재 페이지가 가운대로 가는 경우
		if(displayPageButton % 2 == 0 && page + harf - 1 <= maxEndPage) {
			startPage = page - harf;
			endPage = page + harf - 1;
			return;
		}
		
		// 현재 페이지가 뒷부분
		endPage = maxEndPage;
		startPage = endPage - displayPageButton + 1;
	}
	
	

}
