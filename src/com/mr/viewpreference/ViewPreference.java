package com.mr.viewpreference;

public class ViewPreference {
	private int id;
	private int enjoy;
	private int quiet;
	private int natural;
	private int history;
	private int lively;
	private int stimulate;//´Ì¼¤
	private int hidden;
	public int selectView(String viewpreference){
		if("enjoy".equals(viewpreference)){
			return enjoy;
		}else if("quiet".equals(viewpreference)){
			return quiet;
		}else if("natural".equals(viewpreference)){
			return natural;
		}else if("history".equals(viewpreference)){
			return history;
		}else if("lively".equals(viewpreference)){
			return lively;
		}else if("stimulate".equals(viewpreference)){
			return stimulate;
		}else{
			return hidden;
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEnjoy() {
		return enjoy;
	}
	public void setEnjoy(int enjoy) {
		this.enjoy = enjoy;
	}
	public int getQuiet() {
		return quiet;
	}
	public void setQuiet(int quiet) {
		this.quiet = quiet;
	}
	public int getNatural() {
		return natural;
	}
	public void setNatural(int natural) {
		this.natural = natural;
	}
	public int getHistory() {
		return history;
	}
	public void setHistory(int history) {
		this.history = history;
	}
	public int getLively() {
		return lively;
	}
	public void setLively(int lively) {
		this.lively = lively;
	}
	public int getStimulate() {
		return stimulate;
	}
	public void setStimulate(int stimulate) {
		this.stimulate = stimulate;
	}
	public int getHidden() {
		return hidden;
	}
	public void setHidden(int hidden) {
		this.hidden = hidden;
	}
}
