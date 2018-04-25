package com.daldal.springboot.writedto;


public class WriteDto {
	
	private String id;
	private String division;
	private int month;
	private int day;
	private int starttime; // 1~24
	private int endtime; // 1~24
	private int peopleno;
	private int cost;
	private String volunteer;
	private String city;
	private String borough;
	private String dong;
	private float radius; // 0.5 , 1 , 1.5 , 2.0 
	public WriteDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WriteDto(String id, String division, int month, int day, int starttime, int endtime, int peopleno, int cost,
			String volunteer, String city, String borough, String dong, float radius) {
		super();
		this.id = id;
		this.division = division;
		this.month = month;
		this.day = day;
		this.starttime = starttime;
		this.endtime = endtime;
		this.peopleno = peopleno;
		this.cost = cost;
		this.volunteer = volunteer;
		this.city = city;
		this.borough = borough;
		this.dong = dong;
		this.radius = radius;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getStarttime() {
		return starttime;
	}
	public void setStarttime(int starttime) {
		this.starttime = starttime;
	}
	public int getEndtime() {
		return endtime;
	}
	public void setEndtime(int endtime) {
		this.endtime = endtime;
	}
	public int getPeopleno() {
		return peopleno;
	}
	public void setPeopleno(int peopleno) {
		this.peopleno = peopleno;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getVolunteer() {
		return volunteer;
	}
	public void setVolunteer(String volunteer) {
		this.volunteer = volunteer;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBorough() {
		return borough;
	}
	public void setBorough(String borough) {
		this.borough = borough;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public float getRadius() {
		return radius;
	}
	public void setRadius(float radius) {
		this.radius = radius;
	}
	@Override
	public String toString() {
		return "WriteDto [id=" + id + ", division=" + division + ", month=" + month + ", day=" + day + ", starttime="
				+ starttime + ", endtime=" + endtime + ", peopleno=" + peopleno + ", cost=" + cost + ", volunteer="
				+ volunteer + ", city=" + city + ", borough=" + borough + ", dong=" + dong + ", radius=" + radius + "]";
	}
	
	
	
}
