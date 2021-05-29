package com.ssafy.happyhouse.dto;

public class HousedealDto {
	int no;
	String dong;
	String AptName;
	String code;
	String dealAmount;
	String buildYear;
	String dealYear;
	String dealMonth;
	String dealDay;
	String area;
	String floor;
	String jibun;
	String type;
	String rentMoney;
	String lat;
	String lng;
	
	
	public HousedealDto() {
		
	}
	public HousedealDto(String aptName, String dealAmount, String buildYear) {
		setAptName(aptName);
		setDealAmount(dealAmount);
		setBuildYear(buildYear);
	}
	public HousedealDto(String dong, String aptName, String dealAmount, String buildYear) {
		setDong(dong);
		setAptName(aptName);
		setDealAmount(dealAmount);
		setBuildYear(buildYear);
	}
	public HousedealDto(int no, String dong, String aptName, String code, String dealAmount, String buildYear,
			String dealYear, String dealMonth, String dealDay, String area, String floor, String jibun, String type,
			String rentMoney) {
		setAptName(aptName);
		setArea(area);
		setBuildYear(buildYear);
		setCode(code);
		setDealAmount(dealAmount);
		setDealDay(dealDay);
		setDealMonth(dealMonth);
		setDealYear(dealYear);
		setDong(dong);
		setFloor(floor);
		setJibun(jibun);
		setNo(no);
		setRentMoney(rentMoney);
		setType(type);
	}
	
	public HousedealDto( String dong, String aptName, String code, String dealAmount, String buildYear,
			String dealYear, String dealMonth, String dealDay, String area, String floor, String jibun, String type,
			String rentMoney, String lat, String lng) {
		super();
		this.dong = dong;
		AptName = aptName;
		this.code = code;
		this.dealAmount = dealAmount;
		this.buildYear = buildYear;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.area = area;
		this.floor = floor;
		this.jibun = jibun;
		this.type = type;
		this.rentMoney = rentMoney;
		this.lat = lat;
		this.lng = lng;
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
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}
	public String getDealYear() {
		return dealYear;
	}
	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}
	public String getDealMonth() {
		return dealMonth;
	}
	public void setDealMonth(String dealMonth) {
		this.dealMonth = dealMonth;
	}
	public String getDealDay() {
		return dealDay;
	}
	public void setDealDay(String dealDay) {
		this.dealDay = dealDay;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getJibun() {
		return jibun;
	}
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRentMoney() {
		return rentMoney;
	}
	public void setRentMoney(String rentMoney) {
		this.rentMoney = rentMoney;
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
		builder.append("HousedealDto [no=").append(no).append(", dong=").append(dong).append(", AptName=")
				.append(AptName).append(", code=").append(code).append(", dealAmount=").append(dealAmount)
				.append(", buildYear=").append(buildYear).append(", dealYear=").append(dealYear).append(", dealMonth=")
				.append(dealMonth).append(", dealDay=").append(dealDay).append(", area=").append(area)
				.append(", floor=").append(floor).append(", jibun=").append(jibun).append(", type=").append(type)
				.append(", rentMoney=").append(rentMoney).append("]");
		return builder.toString();
	}
	
	
	
}
