package com.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Roles {

	@Id
	private String roleName;
	private String description;
	
	public Roles() {
	}
	public Roles(String roleName, String description) {
		super();
		this.roleName = roleName;
		this.description = description;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
