package com.pjt.ex22.exhibit;


public class Exhibit {
	private String latClick; // ����
	private String lngClick; // �浵
	private String address; // �ּ�
	private String name; // ���� �����
	private String subject; // ���� �� ����ȸ
	private String periodDate; // ���ñⰣ
	private String periodTime; // �����ð�
	private String dayOff; //�޹���
	private String fare; // ������
	private String farePlace; // Ƽ�� ����ó
	private String website; // ������Ʈ
	private String phone; // ����ó
	private String metro; // �α� ����ö��(���߱���)
	private String thumbnail; // ����� ����
	// ����ȸ ����
	
	public Exhibit() {
		latClick = "37.55627537083571";
		lngClick = "126.97239492638606";
		name = "���￪";
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