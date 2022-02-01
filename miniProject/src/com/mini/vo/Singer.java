package com.mini.vo;
// playlist랑 playlist_detail을 조인해서 이 클래스에서 한꺼번에 받음 
public class Singer {
	private int main_sid;
	private String singer_name;
	private String sex;
	private String isGrouped;
	private String introduce;
	private String debut_date;
	
	public Singer() {}

	public Singer(String singer_name, String sex, String isGrouped, String introduce, String debut_date) {
		super();
		this.singer_name = singer_name;
		this.sex = sex;
		this.isGrouped = isGrouped;
		this.introduce = introduce;
		this.debut_date = debut_date;
	}

	public int getMain_sid() {
		return main_sid;
	}

	public void setMain_sid(int main_sid) {
		this.main_sid = main_sid;
	}

	public String getSinger_name() {
		return singer_name;
	}

	public void setSinger_name(String singer_name) {
		this.singer_name = singer_name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIsGrouped() {
		return isGrouped;
	}

	public void setIsGrouped(String isGrouped) {
		this.isGrouped = isGrouped;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getDebut_date() {
		return debut_date;
	}

	public void setDebut_date(String debut_date) {
		this.debut_date = debut_date;
	}

	@Override
	public String toString() {
		return "Singer [main_sid=" + main_sid + ", singer_name=" + singer_name + ", sex=" + sex + ", isGrouped="
				+ isGrouped + ", introduce=" + introduce + ", debut_date=" + debut_date + "]";
	}
	
	
}
