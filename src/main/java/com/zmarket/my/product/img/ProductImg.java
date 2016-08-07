package com.zmarket.my.product.img;

public class ProductImg {
	private int num;
	private int prod_num;
	private String path;
	private String name;
	public static final String FOLDERPATH = "C:\\Users\\Administrator\\MAVEN_Project\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\imgs\\";
	
	@Override
	public String toString() {
		return "ProductImg [num=" + num + ", prod_num=" + prod_num + ", path=" + path + ", name=" + name + "]";
	}

	public ProductImg(int num, int prod_num, String path, String name) {
		super();
		this.num = num;
		this.prod_num = prod_num;
		this.path = path;
		this.name = name;
	}

	public ProductImg() {
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
