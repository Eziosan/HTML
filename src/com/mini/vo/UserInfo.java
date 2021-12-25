package com.mini.vo;

public class UserInfo {
	private String user_id;
	private String password;
	private String name;
	private String sex;
	private String birth;
	private String email;
	private String phone;
	private String address;
	
	public UserInfo() {}

	public UserInfo(String user_id, String password, String name, String sex, String birth, String email, String phone,
			String address) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserInfo [user_id=" + user_id + ", password=" + password + ", name=" + name + ", sex=" + sex
				+ ", birth=" + birth + ", email=" + email + ", phone=" + phone + ", address=" + address + "]";
	}
	
	
}
