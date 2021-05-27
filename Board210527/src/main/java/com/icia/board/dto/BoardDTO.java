package com.icia.board.dto;

public class BoardDTO {
	
	private String bnumber;
	private String btitle;
	private String bpassword;
	private String bwriter;
	private String bcontents; 
	private String bdate;
	private String bhits;
	
	public String getBnumber() {
		return bnumber;
	}
	public void setBnumber(String bnumber) {
		this.bnumber = bnumber;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBpassword() {
		return bpassword;
	}
	public void setBpassword(String bpassword) {
		this.bpassword = bpassword;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public String getBcontents() {
		return bcontents;
	}
	public void setBcontents(String bcontents) {
		this.bcontents = bcontents;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getBhits() {
		return bhits;
	}
	public void setBhits(String bhits) {
		this.bhits = bhits;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [bnumber=" + bnumber + ", btitle=" + btitle + ", bpassword=" + bpassword + ", bwriter="
				+ bwriter + ", bcontents=" + bcontents + ", bdate=" + bdate + ", bhits=" + bhits + "]";
	}
	
	
}
