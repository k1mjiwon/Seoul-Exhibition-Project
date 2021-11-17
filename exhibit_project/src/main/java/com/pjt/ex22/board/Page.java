package com.pjt.ex22.board;

public class Page {
	private int page;
	private int pageLength; 
	
	public Page() { // Page 생성자
		this.page = 1; // 페이지
		this.pageLength = 5; // 페이지당 들어갈 게시글의 수
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public int getPageLength() {
		return pageLength;
	}

	public void setPageLength(int pageLength) {
		this.pageLength = pageLength;
	}
	
	
}
