package com.zmarket.my.product.opt;

public class ProductOpt {
	private int num;
	private int prod_num;
	private String options;
	private int amount;
	private int additional_price;
	
	public ProductOpt(int num, int prod_num, String options, int amount, int additional_price) {
		super();
		this.num = num;
		this.prod_num = prod_num;
		this.options = options;
		this.amount = amount;
		this.additional_price = additional_price;
	}

	@Override
	public String toString() {
		return "ProductOpt [num=" + num + ", prod_num=" + prod_num + ", options=" + options + ", amount=" + amount
				+ ", additional_price=" + additional_price + "]";
	}

	public ProductOpt() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAdditional_price() {
		return additional_price;
	}

	public void setAdditional_price(int additional_price) {
		this.additional_price = additional_price;
	}


	
}
