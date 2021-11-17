package com.pjt.ex22.board;

public class Page {
	private int page;
	private int pageLength; 
	
	public Page() { // Page ������
		this.page = 1; // ������
		this.pageLength = 5; // �������� �� �Խñ��� ��
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
