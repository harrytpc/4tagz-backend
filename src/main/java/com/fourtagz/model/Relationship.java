package com.fourtagz.model;

import java.util.Date;

public class Relationship {

	private Long id;
	private Date beepedDate;
	private String local; // TODO veriricar melhor forma de armazenar localizacao
	private User user;
	private Profile beepedProfile;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getBeepedDate() {
		return beepedDate;
	}
	public void setBeepedDate(Date beepedDate) {
		this.beepedDate = beepedDate;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Profile getBeepedProfile() {
		return beepedProfile;
	}
	public void setBeepedProfile(Profile beepedProfile) {
		this.beepedProfile = beepedProfile;
	}
	
}
