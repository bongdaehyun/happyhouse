package com.ssafy.happyhouse.dto;

public class myArea {
	String dongCode;
	String typeName;
	String name;
	String dong;
	String lat;
	String lng;
	
	public myArea() {
		super();
	}

	public myArea(String dongCode, String typeName, String name, String dong, String lat, String lng) {
		setDong(dong);
		setDongCode(dongCode);
		setLat(lat);
		setLng(lng);
		setName(name);
		setTypeName(typeName);
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String sidoCode) {
		this.dongCode = sidoCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("myArea [dongCode=").append(dongCode).append(", typeName=").append(typeName).append(", name=")
				.append(name).append(", dong=").append(dong).append(", lat=").append(lat).append(", lng=").append(lng)
				.append("]");
		return builder.toString();
	}
	
	
	
	
}
