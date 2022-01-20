package day18;

public class test {

	public static void main(String[] args) {

		int purPageNum = 4;
		int startPage = 1;
		int endPage;
		int maxEndPage = 6;
		int page = 6;
		
		
		int harf = purPageNum / 2;
		
		
		
				
		startPage = page - harf < 1 ? 1 : page-harf;		
		startPage = maxEndPage-purPageNum+1 < startPage ?  maxEndPage-purPageNum+1 : startPage;

		if(purPageNum%2 != 0) {
			endPage = page + harf > maxEndPage ? maxEndPage : page+harf;
		}
		else {
			endPage = page + harf-1 > maxEndPage ? maxEndPage : page+harf-1;
		}
		endPage = startPage+purPageNum-1 >= endPage ? startPage+purPageNum-1 : maxEndPage; 	
		
				
		System.out.println(endPage);
		
		
		
	}

}
