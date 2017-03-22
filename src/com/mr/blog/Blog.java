package com.mr.blog;

public class Blog {
	private int id;
	private int car_id;
	private String username;
	private String mysign;
	public Blog(){
		
	}
	public Blog(int car_id,String username,String mysign){
		this.car_id=car_id;
		this.username=username;
		this.mysign=mysign;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMysign() {
		return mysign;
	}
	public void setMysign(String mysign) {
		this.mysign = mysign;
	}
}
