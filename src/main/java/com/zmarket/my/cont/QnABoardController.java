package com.zmarket.my.cont;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zmarket.my.board.QnABoard;
import com.zmarket.my.board.QnABoardService;

@Controller
public class QnABoardController {

	@Resource(name = "QnABoardService")
	private QnABoardService service;

	public void setService(QnABoardService service) {
		this.service = service;
	}

	@RequestMapping(value = "qnaboard/list.do")
	public ModelAndView list(QnABoard q) {
		ModelAndView mav = new ModelAndView("qnaboard/list");
		ArrayList<QnABoard> list = (ArrayList<QnABoard>) service.getQnABoardAll();
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping(value = "qnaboard/write.do")
	public String write() {
		return "qnaboard/writeForm";
	}

	@RequestMapping(value = "qnaboard/writeok.do")
	public String add(QnABoard q) {
		service.WriteQnABoard(q);
		return "redirect:/qnaboard/list.do";
	}

	@RequestMapping(value = "qnaboard/read.do")
	public ModelAndView read(@RequestParam(value = "num") int num) {
		ModelAndView mav = new ModelAndView("qnaboard/readForm");
		QnABoard qnaboard = service.getQnABoard(num);
		mav.addObject("board", qnaboard);
		return mav;
	}

	@RequestMapping(value = "qnaboard/rep.do")
	public ModelAndView rep(HttpServletRequest request) {
		System.out.println("리플달기 입장");
		QnABoard q = new QnABoard();
		q.setNum(Integer.parseInt(request.getParameter("num")));
		q.setContent(request.getParameter("content"));
		q.setTitle(request.getParameter("title"));
		q.setWriter_num(Integer.parseInt(request.getParameter("writer_num")));

		service.WriteRep(q);

		ModelAndView mav = new ModelAndView("qnaboard/getrepJSON");
		mav.addObject("q", q);

		return mav;
	}

	@RequestMapping(value="qnaboard/replist.do")
	public ModelAndView replist(HttpServletRequest request){		
		int num = Integer.parseInt(request.getParameter("num"));
		ArrayList<QnABoard>list = (ArrayList<QnABoard>) service.getRep(num);
		ModelAndView mav = new ModelAndView("qnaboard/repListJSON");		
		mav.addObject("list", list);		
		return mav;
	}

	@RequestMapping(value="qnaboard/del.do")
	public String del(@RequestParam(value="num")int num){
		System.out.println(num);
		service.delQnABoard(num);
		return "redirect:/qnaboard/list.do";
	}

}
