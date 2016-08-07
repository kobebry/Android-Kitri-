package com.zmarket.my.order;

public class Basket {
	private int num;
	private int prod_num;
	private int customer_num;
	private int prod_opt_num;
	private int amount;
	private String prod_opt_options;
	
	public Basket(){}
	public Basket(int num, int prod_num, int customer_num, int prod_opt_num, int amount) {
		this.num = num;
		this.prod_num = prod_num;
		this.customer_num = customer_num;
		this.prod_opt_num = prod_opt_num;
		this.amount = amount;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	public int getCustomer_num() {
		return customer_num;
	}
	public void setCustomer_num(int customer_num) {
		this.customer_num = customer_num;
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
	public String getProd_opt_options() {
		return prod_opt_options;
	}
	public void setProd_opt_options(String prod_opt_options) {
		this.prod_opt_options = prod_opt_options;
	}
	
	
	
}
