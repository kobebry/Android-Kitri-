package com.zmarket.my.order;

public class Baskets {
	private int num;
	private String name;
	private int price;
	private int customer_num;
	private String options;
	private int amount;
	private int add_price;
	
	public Baskets() {
		// TODO Auto-generated constructor stub
	}
	
	public Baskets(int num, String name, int price, int customer_num, String options, int amount, int add_price) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.customer_num = customer_num;
		this.options = options;
		this.amount = amount;
		this.add_price = add_price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public int getAdd_price() {
		return add_price;
	}

	public void setAdd_price(int add_price) {
		this.add_price = add_price;
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

	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
