package com.ssafy.happyhouse.dto;

public class HouseinfoDto {
	int no;
	String dong;
	String AptName;
	String code;
	
	String jibun;
	String lat;
	String lng;
	String img;
	
	
	public HouseinfoDto() {
		
	}
	public HouseinfoDto(int no, String dong, String aptName, String code, String jibun, String lat, String lng,
			String img) {
		setAptName(aptName);
		setCode(code);
		setDong(dong);
		setImg(img);
		setJibun(jibun);
		setLat(lat);
		setLng(lng);
		setNo(no);
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getAptName() {
		return AptName;
	}
	public void setAptName(String aptName) {
		AptName = aptName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getJibun() {
		return jibun;
	}
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HouseinfoDto [no=").append(no).append(", dong=").append(dong).append(", AptName=")
				.append(AptName).append(", code=").append(code).append(", jibun=").append(jibun).append(", lat=")
				.append(lat).append(", lng=").append(lng).append(", img=").append(img).append("]");
		return builder.toString();
	}
	
	
}
