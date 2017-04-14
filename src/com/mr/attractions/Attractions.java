package com.mr.attractions;

import com.mr.crowds.Crowds;
import com.mr.viewpreference.ViewPreference;
import com.mr.weatherindex.WeatherIndex;

public class Attractions {
	private int id;
	private String name;
	private String detail;
	private String local;
	private String exterior;
	private String routepicture;
	private double time;
	private double price;
	private Crowds crowds;
	private ViewPreference viewPreference;
	private WeatherIndex weatherIndex;
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
	public Crowds getCrowds() {
		return crowds;
	}
	public void setCrowds(Crowds crowds) {
		this.crowds = crowds;
	}
	public ViewPreference getViewPreference() {
		return viewPreference;
	}
	public void setViewPreference(ViewPreference viewPreference) {
		this.viewPreference = viewPreference;
	}
	public WeatherIndex getWeatherIndex() {
		return weatherIndex;
	}
	public void setWeatherIndex(WeatherIndex weatherIndex) {
		this.weatherIndex = weatherIndex;
	}
}
