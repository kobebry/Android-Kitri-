package com.zmarket.my.board;

import org.springframework.web.multipart.MultipartFile;

public class BenchBoard {
	private int num;
	private int writer_num;
	private String title;
	private String content;
	private int prod_num;
	private String img_path;
	private MultipartFile file;
	public static final String FOLDERPATH = "C:\\Users\\Administrator\\MAVEN_Project\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\boardImg\\";

	public BenchBoard() {}
	
	public BenchBoard(int num, int writer_num, String title, String content, int prod_num, String img_path) {
		super();
		this.num = num;
		this.writer_num = writer_num;
		this.title = title;
		this.content = content;
		this.prod_num = prod_num;
		this.img_path = img_path;
	}
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getWriter_num() {
		return writer_num;
	}
	public void setWriter_num(int writer_num) {
		this.writer_num = writer_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}	
	
	
}
