package com.zmarket.my.board;

import java.util.ArrayList;
import java.util.List;

public interface QnABoardService {
	QnABoard getQnABoard(int num);
	List getQnABoardAll();
	void WriteQnABoard(QnABoard q);
	void editQnABoard(QnABoard q);
	void delQnABoard(int num);
	void WriteRep(QnABoard q);
	List getRep(int num);
	QnABoard getRepByNum(int num);
}
