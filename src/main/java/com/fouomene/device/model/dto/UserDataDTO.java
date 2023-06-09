package com.fouomene.device.model.dto;


import com.fouomene.device.model.entities.Role;

import java.util.List;

public class UserDataDTO {
	private String username;

	private String email;

	List<Role> roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
