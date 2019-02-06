package com.staroot.mybatis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id; 
	
	@Column(nullable=false, length=20)
	private String userId;
	private String password;
	private String name;
	private String email;
	
	
	@JsonProperty
	private String dummy;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Long getId() {
		return id;
	}  
	
	public boolean matchPassword(String inputPassword){
		if(inputPassword == null){
			return false;
		}
		return inputPassword.equals(this.password);
	}	
}
