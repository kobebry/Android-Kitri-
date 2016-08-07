package com.zmarket.my.board;

public class QnABoard {
	private int num;
	private int writer_num;
	private String title;
	private String content;
	private int parent_num;
	
	
	public int getParent_num() {
		return parent_num;
	}


	public void setParent_num(int parent_num) {
		this.parent_num = parent_num;
	}


	public QnABoard() {}
	
	
	public QnABoard(int num, int writer_num, String title, String content,int parent_num) {
		super();
		this.num = num;
		this.writer_num = writer_num;
		this.title = title;
		this.content = content;
		this.parent_num = parent_num;

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

}
