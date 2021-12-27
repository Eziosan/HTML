package com.mini.vo;

public class Concert {
	private int concert_id;
	private String concert_name;
	private int main_sid;
	private String place;
	private String concert_date;
	private String running_time;
	private int price;
	
	public Concert() {}
	
	public Concert(int concert_id, String concert_name, int main_sid, String place, String concert_date,
			String running_time, int price) {
		super();
		this.concert_id = concert_id;
		this.concert_name = concert_name;
		this.main_sid = main_sid;
		this.place = place;
		this.concert_date = concert_date;
		this.running_time = running_time;
		this.price = price;
	}
	public int getConcert_id() {
		return concert_id;
	}
	public void setConcert_id(int concert_id) {
		this.concert_id = concert_id;
	}
	public String getConcert_name() {
		return concert_name;
	}
	public void setConcert_name(String concert_name) {
		this.concert_name = concert_name;
	}
	public int getMain_sid() {
		return main_sid;
	}
	public void setMain_sid(int main_sid) {
		this.main_sid = main_sid;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getConcert_date() {
		return concert_date;
	}
	public void setConcert_date(String concert_date) {
		this.concert_date = concert_date;
	}
	public String getRunning_time() {
		return running_time;
	}
	public void setRunning_time(String running_time) {
		this.running_time = running_time;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "No."+concert_id +"\n"+"콘서트 이름 : " + concert_name +"\n" + "장소 : " + place +"\n"+ "콘서트 일정 : " + concert_date+"\n" 
				+ "시간 : " + running_time +"\n"+ "가격 : "
				+ price + "\n";
	}
	
	
	
}
