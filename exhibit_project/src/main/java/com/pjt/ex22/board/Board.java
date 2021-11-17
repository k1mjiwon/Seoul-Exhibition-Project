package com.pjt.ex22.board;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class Board {
	private int bno;
	private String btitle;
	private String btext;
	private String bid;
	private Timestamp bdate;
	private int bcnt;
	private String bfile;
	private MultipartFile file;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBtext() {
		return btext;
	}
	public void setBtext(String btext) {
		this.btext = btext;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	
	public Timestamp getBdate() {
		return bdate;
	}
	public void setBdate(Timestamp bdate) {
		this.bdate = bdate;
	}

	public int getBcnt() {
		return bcnt;
	}
	
	public void setBcnt(int bcnt) {
		this.bcnt = bcnt;
	}
	public String getBfile() {
		return bfile;
	}
	public void setBfile(String bfile) {
		this.bfile = bfile;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
