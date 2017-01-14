package com.fourtagz.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;	
	private String email;
	private String password;
	
	@Transient
	private List<Profile> profile;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Profile> getProfile() {
		return profile;
	}
	public void setProfile(List<Profile> profile) {
		this.profile = profile;
	}
	
	
}
