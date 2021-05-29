package com.ssafy.happyhouse.dto;

public class UserDto {
	private String userid;
	private String userpw;
	private String username;
	private String useremail;
	private String code;
	
	
	public UserDto(String userid, String userpw, String username, String useremail, String code) {
		setUserid(userid);
		setUserpw(userpw);
		setUsername(username);
		setUseremail(useremail);
		setCode(code);
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getUserpw() {
		return userpw;
	}


	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}



	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	@Override
	public String toString() {
		return "User [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", useremail=" + useremail
				+ ", code=" + code + "]";
	}
	
}
