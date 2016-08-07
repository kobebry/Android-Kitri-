package com.zmarket.my.product;

import java.sql.Date;
import java.util.List;

import com.zmarket.my.board.BenchBoard;
import com.zmarket.my.product.img.ProductImg;
import com.zmarket.my.product.opt.ProductOpt;

public class Products {
	private int num;
	private String name;
	private int category_num;
	private int seller_num;
	private String seller_name;
	private Date sell_date;
	private int price;
	private String details;
	private String origin;
	private Date made_date;
	private int weight;
	private String option_indexes;
	private List<ProductOpt> poList;
	private List<ProductImg> piList;
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Products(int num, String name, int category_num, int seller_num, String seller_name, Date sell_date,
			int price, String details, String origin, Date made_date, int weight, String option_indexes,
			List<ProductOpt> poList, List<ProductImg> piList) {
		super();
		this.num = num;
		this.name = name;
		this.category_num = category_num;
		this.seller_num = seller_num;
		this.seller_name = seller_name;
		this.sell_date = sell_date;
		this.price = price;
		this.details = details;
		this.origin = origin;
		this.made_date = made_date;
		this.weight = weight;
		this.option_indexes = option_indexes;
		this.poList = poList;
		this.piList = piList;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategory_num() {
		return category_num;
	}
	public void setCategory_num(int category_num) {
		this.category_num = category_num;
	}
	public int getSeller_num() {
		return seller_num;
	}
	public void setSeller_num(int seller_num) {
		this.seller_num = seller_num;
	}
	public String getSeller_name() {
		return seller_name;
	}
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	public Date getSell_date() {
		return sell_date;
	}
	public void setSell_date(Date sell_date) {
		this.sell_date = sell_date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public Date getMade_date() {
		return made_date;
	}
	public void setMade_date(Date made_date) {
		this.made_date = made_date;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public List<ProductOpt> getPoList() {
		return poList;
	}
	public void setPoList(List<ProductOpt> poList) {
		this.poList = poList;
	}
	public List<ProductImg> getPiList() {
		return piList;
	}
	public void setPiList(List<ProductImg> piList) {
		this.piList = piList;
	}

	@Override
	public String toString() {
		return "Products [num=" + num + ", name=" + name + ", category_num=" + category_num + ", seller_num="
				+ seller_num + ", seller_name=" + seller_name + ", sell_date=" + sell_date + ", price=" + price
				+ ", details=" + details + ", origin=" + origin + ", made_date=" + made_date + ", weight=" + weight
				+ ", option_indexes=" + option_indexes + ", poList=" + poList + ", piList=" + piList + "]";
	}

	public String getOption_indexes() {
		return option_indexes;
	}

	public void setOption_indexes(String option_indexes) {
		this.option_indexes = option_indexes;
	}

	
	

	
}
