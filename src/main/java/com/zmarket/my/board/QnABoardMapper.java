package com.zmarket.my.board;

import java.util.List;

public interface QnABoardMapper {
	
	QnABoard select(int num);
	List selectAll();
	void insert(QnABoard q);
	void update(QnABoard q);
	void delete(int num);
	void insert_rep(QnABoard q);
	List select_rep(int num);
	QnABoard get_rep(int num);

}
