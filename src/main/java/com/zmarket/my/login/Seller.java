package com.zmarket.my.login;

public class Seller {
	private int num;
	private int seller_num;
	private String company;
	private String account;
	private String company_phone;
	private String licensee_no;
	
	public Seller(){}
	public Seller(int num, int seller_num, String company, String account, String company_phone, String licensee_no) {
		this.num = num;
		this.seller_num = seller_num;
		this.company = company;
		this.account = account;
		this.company_phone = company_phone;
		this.licensee_no = licensee_no;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getSeller_num() {
		return seller_num;
	}
	public void setSeller_num(int seller_num) {
		this.seller_num = seller_num;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCompany_phone() {
		return company_phone;
	}
	public void setCompany_phone(String company_phone) {
		this.company_phone = company_phone;
	}
	public String getLicensee_no() {
		return licensee_no;
	}
	public void setLicensee_no(String licensee_no) {
		this.licensee_no = licensee_no;
	}
}
