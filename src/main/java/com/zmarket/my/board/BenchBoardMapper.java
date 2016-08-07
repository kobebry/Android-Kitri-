package com.zmarket.my.board;

import java.util.List;

public interface BenchBoardMapper {
	BenchBoard select(int num);
	List selectAll();
	List selectByProdNum(int prod_num);
	void insert(BenchBoard b);
	void update(BenchBoard b);		
	void delect(int num);
}
