package com.zmarket.my.cont;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zmarket.my.board.BenchBoard;
import com.zmarket.my.board.BenchBoardService;

@Controller
public class BoardController {
	
	@Resource(name="BenchBoardService")
	private BenchBoardService service; 	
	
	public void setService(BenchBoardService service) {
		this.service = service;
	}

/*	@RequestMapping(value="/board/list.do")
	public ModelAndView list(){
		System.out.println("list컨트롤러 입장");
		ModelAndView mav = new ModelAndView("board/list");
		System.out.println("list컨트롤러 2");
		ArrayList<BenchBoard> list = (ArrayList<BenchBoard>) service.getBenchBoardAll();
		for(int i = 0; i < list.size(); i++) {
			BenchBoard bb = list.get(i);
			if(bb.getContent().length() > 20){
				bb.setContent(bb.getContent().substring(0, 17)+"...");	
			}			
		}
		System.out.println("list컨트롤러 3");
		mav.addObject("list",list);		
		return mav;		
	}*/
	
	@RequestMapping(value="/board/list.do")
	public String list(@RequestParam(value="prod_num")int prod_num){
		System.out.println("list컨트롤러 입장");
		ModelAndView mav = new ModelAndView("board/list");
		System.out.println("list컨트롤러 2");
		ArrayList<BenchBoard> list = (ArrayList<BenchBoard>) service.getBenchBoardAll();
		for(int i = 0; i < list.size(); i++) {
			BenchBoard bb = list.get(i);
			if(bb.getContent().length() > 20){
				bb.setContent(bb.getContent().substring(0, 17)+"...");	
			}			
		}
		System.out.println("list컨트롤러 3");
		mav.addObject("list",list);		
		return "redirect:/viewcont/showitem.do?prod_num="+prod_num+"";		
	}
	
	
	@RequestMapping(value="/board/writeForm.do")
	public String writeForm(){
		return "board/writeForm";
	}
	
	@RequestMapping(value="/board/write.do")
	public String add(BenchBoard b){
		System.out.println(b.getProd_num());
		int prod_num = b.getProd_num();
		String fileName = Long.toString(System.currentTimeMillis());
		String path= BenchBoard.FOLDERPATH + fileName;
		System.out.println(path);
		File f = new File(path);		
		try {
			b.getFile().transferTo(f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.setImg_path("/boardImg/"+fileName);
		service.WriteBenchBoard(b);		
		return "redirect:/viewcont/showitem.do?prod_num="+prod_num;
	}	
	@RequestMapping(value="/board/read.do")
	public ModelAndView read(@RequestParam(value="num")int num){
		BenchBoard board =  service.getBenchBoard(num);
		ModelAndView mav = new ModelAndView("board/readForm");
		mav.addObject("board", board);
		
		return mav;
	}
	
	@RequestMapping(value="/board/edit.do")
	public ModelAndView edit(@RequestParam(value="num")int num){
		BenchBoard board =  service.getBenchBoard(num);
		
		ModelAndView mav = new ModelAndView("board/editForm");
		mav.addObject("board", board);		
		return mav;
	}	
	@RequestMapping(value="/board/edit_ok.do")
	public String editok(BenchBoard b){
		System.out.println("수정한다.");	
		int prod_num = b.getProd_num();
		System.out.println(b.getNum() + b.getContent() + b.getTitle());
		service.editBenchBoard(b);		
		return "redirect:/viewcont/showitem.do?prod_num="+prod_num+"";
	}
	@RequestMapping(value="/board/del.do")
	public String del(@RequestParam(value="num")int num,@RequestParam(value="prod_num")int prod_num){
		service.delBenchBoard(num);
		return "redirect:/viewcont/showitem.do?prod_num="+prod_num+"";
	}
	
	
}
