package com.akash.bean;

import com.akash.utility.MD5Encryption;

public class Users {
	private int id;
	private String name;
	private String email;
	private String password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() throws Exception {
		MD5Encryption md5 = new MD5Encryption();
		return md5.decrypt(password);
	}
	public void setPassword(String password) throws Exception {
		MD5Encryption md5 = new MD5Encryption();
		this.password = md5.encrypt(password);
	}
}
