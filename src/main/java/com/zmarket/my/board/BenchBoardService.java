package com.zmarket.my.board;

import java.util.List;

public interface BenchBoardService {
	void WriteBenchBoard(BenchBoard b);	
	BenchBoard getBenchBoard(int num);
	List<BenchBoard> getBenchBoardAll();
	List<BenchBoard> getBenchBoardByProdNum(int prod_num);
	void editBenchBoard(BenchBoard b);
	void delBenchBoard(int num);
}
