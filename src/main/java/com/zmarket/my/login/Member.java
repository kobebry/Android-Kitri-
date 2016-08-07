package com.zmarket.my.login;

public class Member {
	private int num;
	private String id;
	private String password;
	private String name;
	private String address;
	private String phone;
	private String email;
	private int type;
	private char valid;
	
	public Member() {}
	public Member(int num, String id, String password, String name, String address, String phone, String email,
			int type, char valid) {
		this.num = num;
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.type = type;
		this.valid = valid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public char getValid() {
		return valid;
	}
	public void setValid(char valid) {
		this.valid = valid;
	}
	@Override
	public String toString() {
		return "Member [num=" + num + ", id=" + id + ", password=" + password + ", name=" + name + ", address="
				+ address + ", phone=" + phone + ", email=" + email + ", type=" + type + ", valid=" + valid + "]";
	}
}
