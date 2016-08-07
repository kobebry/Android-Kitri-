package com.zmarket.my.order;

public class Order {
	private int num;
	private int customer_num;
	private int prod_num;
	private int prod_opt_num;
	private int amount;
	private int status;
	private String order_date;
	private String address;
	private String phone;
	public Order(){}
	
	

	public Order(int num, int customer_num, int prod_num, int prod_opt_num, int amount, int status, String order_date,
			String address, String phone) {
		super();
		this.num = num;
		this.customer_num = customer_num;
		this.prod_num = prod_num;
		this.prod_opt_num = prod_opt_num;
		this.amount = amount;
		this.status = status;
		this.order_date = order_date;
		this.address = address;
		this.phone = phone;
	}



	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCustomer_num() {
		return customer_num;
	}
	public void setCustomer_num(int customer_num) {
		this.customer_num = customer_num;
	}
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	public int getProd_opt_num() {
		return prod_opt_num;
	}
	public void setProd_opt_num(int prod_opt_num) {
		this.prod_opt_num = prod_opt_num;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
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
	
}
