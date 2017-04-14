package com.mr.attractions;


public class ForAttractions {
	private int id;
	private String name;
	private String detail;
	private String local;
	private String exterior;
	private String routepicture;
	private double time;
	private double price;
	private int forcrowds;
	private int forviewpreference;
	private int forweatherindex;
	private double distance;
	public ForAttractions(Attractions attractions,int forcrowds,
			int forviewpreference,int forweatherindex,double distance){
		id=attractions.getId();
		name=attractions.getName();
		detail=attractions.getDetail();
		local=attractions.getLocal();
		exterior=attractions.getExterior();
		routepicture=attractions.getRoutepicture();
		time=attractions.getTime();
		price=attractions.getPrice();
		this.forcrowds=forcrowds;
		this.forviewpreference=forviewpreference;
		this.forweatherindex=forweatherindex;
		this.distance=distance;
	}
	public ForAttractions(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getExterior() {
		return exterior;
	}
	public void setExterior(String exterior) {
		this.exterior = exterior;
	}
	public String getRoutepicture() {
		return routepicture;
	}
	public void setRoutepicture(String routepicture) {
		this.routepicture = routepicture;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getForcrowds() {
		return forcrowds;
	}
	public void setForcrowds(int forcrowds) {
		this.forcrowds = forcrowds;
	}
	public int getForviewpreference() {
		return forviewpreference;
	}
	public void setForviewpreference(int forviewpreference) {
		this.forviewpreference = forviewpreference;
	}
	public int getForweatherindex() {
		return forweatherindex;
	}
	public void setForweatherindex(int forweatherindex) {
		this.forweatherindex = forweatherindex;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
}
