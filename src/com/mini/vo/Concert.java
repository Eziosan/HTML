package com.mini.vo;

public class Concert {
	private int concert_id;
	private String concert_name;
	private int main_sid;
	private String place;
	private String concert_date;
	private String running_time;
	private int price;
	
	//singer_name 변수 추가(12/30)
	private String singer_name;
	
	public Concert() {}

	public Concert(int concert_id, String concert_name, int main_sid, String place, String concert_date,
			String running_time, int price, String singer_name) {
		super();
		this.concert_id = concert_id;
		this.concert_name = concert_name;
		this.main_sid = main_sid;
		this.place = place;
		this.concert_date = concert_date;
		this.running_time = running_time;
		this.price = price;
		//singer_name 변수 추가(12/30)
		this.singer_name = singer_name;
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

	public String getSinger_name() {
		return singer_name;
	}

	public void setSinger_name(String singer_name) {
		this.singer_name = singer_name;
	}

	@Override
	public String toString() {
		return "\nNo. " + concert_id + "\n콘서트명 : " + concert_name + "\n가수명 : " + singer_name;
	}
	
	
}
