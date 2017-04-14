package com.mr.crowds;

public class Crowds {
	private int id;
	private int teens;
	private int student;
	private int white;
	private int blue;
	private int familys;
	private int oldman;
	private int friend;
	private int couple;
	public int selectCrowds(String crowds){
		if("teens".equals(crowds)){
			return teens;
		}else if("student".equals(crowds)){
			return student;
		}else if("white".equals(crowds)){
			return white;
		}else if("blue".equals(crowds)){
			return blue;
		}else if("familys".equals(crowds)){
			return familys;
		}else if("oldman".equals(crowds)){
			return oldman;
		}else if("friend".equals(crowds)){
			return friend;
		}else{
			return couple;
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTeens() {
		return teens;
	}
	public void setTeens(int teens) {
		this.teens = teens;
	}
	public int getStudent() {
		return student;
	}
	public void setStudent(int student) {
		this.student = student;
	}
	public int getWhite() {
		return white;
	}
	public void setWhite(int white) {
		this.white = white;
	}
	public int getBlue() {
		return blue;
	}
	public void setBlue(int blue) {
		this.blue = blue;
	}
	public int getFamilys() {
		return familys;
	}
	public void setFamilys(int familys) {
		this.familys = familys;
	}
	public int getOldman() {
		return oldman;
	}
	public void setOldman(int oldman) {
		this.oldman = oldman;
	}
	public int getFriend() {
		return friend;
	}
	public void setFriend(int friend) {
		this.friend = friend;
	}
	public int getCouple() {
		return couple;
	}
	public void setCouple(int couple) {
		this.couple = couple;
	}
}
