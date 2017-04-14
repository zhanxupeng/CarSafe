package com.mr.weatherindex;

public class WeatherIndex {
	private int id;
	private int sunny;
	private int cloudy;
	private int yinday;
	private int smallrain;
	private int rainy;
	private int bigrain;
	public int selectWeather(String weather){
		if("sunny".equals(weather)){
			return sunny;
		}else if("cloudy".equals(weather)){
			return cloudy;
		}else if("yinday".equals(weather)){
			return yinday;
		}else if("smallrain".equals(weather)){
			return smallrain;
		}else if("rainy".equals(weather)){
			return rainy;
		}else{
			return bigrain;
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSunny() {
		return sunny;
	}
	public void setSunny(int sunny) {
		this.sunny = sunny;
	}
	public int getCloudy() {
		return cloudy;
	}
	public void setCloudy(int cloudy) {
		this.cloudy = cloudy;
	}
	public int getYinday() {
		return yinday;
	}
	public void setYinday(int yinday) {
		this.yinday = yinday;
	}
	public int getSmallrain() {
		return smallrain;
	}
	public void setSmallrain(int smallrain) {
		this.smallrain = smallrain;
	}
	public int getRainy() {
		return rainy;
	}
	public void setRainy(int rainy) {
		this.rainy = rainy;
	}
	public int getBigrain() {
		return bigrain;
	}
	public void setBigrain(int bigrain) {
		this.bigrain = bigrain;
	}
}
