package com.fourtagz.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Relationship {
	
	@Id
	private String id;
	
	private Date beepedDate;
	
	@OneToOne(fetch = FetchType.EAGER)
	private User user;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Profile beepedProfile;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getBeepedDate() {
		return beepedDate;
	}
	public void setBeepedDate(Date beepedDate) {
		this.beepedDate = beepedDate;
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
