package com.pjt.ex22.exhibit;


public class Exhibit {
	private String latClick; // 위도
	private String lngClick; // 경도
	private String address; // 주소
	private String name; // 전시 기관명
	private String subject; // 진행 중 전시회
	private String periodDate; // 전시기간
	private String periodTime; // 영업시간
	private String dayOff; //휴무일
	private String fare; // 입장요금
	private String farePlace; // 티켓 구매처
	private String website; // 웹사이트
	private String phone; // 연락처
	private String metro; // 인근 지하철역(대중교통)
	private String thumbnail; // 썸네일 사진
	// 전시회 사진
	
	public Exhibit() {
		latClick = "37.55627537083571";
		lngClick = "126.97239492638606";
		name = "서울역";
	}
	
	public String getLatClick() {
		return latClick;
	}
	public void setLatClick(String latClick) {
		this.latClick = latClick;
	}
	public String getLngClick() {
		return lngClick;
	}
	public void setLngClick(String lngClick) {
		this.lngClick = lngClick;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPeriodDate() {
		return periodDate;
	}
	public void setPeriodDate(String periodDate) {
		this.periodDate = periodDate;
	}
	public String getPeriodTime() {
		return periodTime;
	}
	public void setPeriodTime(String periodTime) {
		this.periodTime = periodTime;
	}
	public String getDayOff() {
		return dayOff;
	}
	public void setDayOff(String dayOff) {
		this.dayOff = dayOff;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	public String getFarePlace() {
		return farePlace;
	}
	public void setFarePlace(String farePlace) {
		this.farePlace = farePlace;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMetro() {
		return metro;
	}

	public void setMetro(String metro) {
		this.metro = metro;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	
}