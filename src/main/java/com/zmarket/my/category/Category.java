package com.zmarket.my.category;

public class Category {
	private int num;
	private String name;
	private int parent_category_num;
	
	@Override
	public String toString() {
		return "Category [num=" + num + ", name=" + name + ", parent_category_num=" + parent_category_num + "]";
	}

	public Category(int num, String name, int parent_category_num) {
		super();
		this.num = num;
		this.name = name;
		this.parent_category_num = parent_category_num;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getParent_category_num() {
		return parent_category_num;
	}

	public void setParent_category_num(int parent_category_num) {
		this.parent_category_num = parent_category_num;
	}
	
	
}
