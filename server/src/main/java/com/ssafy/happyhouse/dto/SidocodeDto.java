package com.ssafy.happyhouse.dto;

public class SidocodeDto {
	String sido_code;
	String sido_name;
	
	public SidocodeDto(String sido_code, String sido_name) {
		setSido_code(sido_code);
		setSido_name(sido_name);
	}
	
	public String getSido_code() {
		return sido_code;
	}
	public void setSido_code(String sido_code) {
		this.sido_code = sido_code;
	}
	public String getSido_name() {
		return sido_name;
	}
	public void setSido_name(String sido_name) {
		this.sido_name = sido_name;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SidocodeDto [sido_code=").append(sido_code).append(", sido_name=").append(sido_name)
				.append("]");
		return builder.toString();
	}
	
	
}
