package com.zmarket.my.cont;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zmarket.my.category.Category;
import com.zmarket.my.category.CategoryService;
import com.zmarket.my.product.Product;
import com.zmarket.my.product.ProductService;
import com.zmarket.my.product.img.ProductImg;
import com.zmarket.my.product.img.ProductImgService;
import com.zmarket.my.product.opt.ProductOpt;
import com.zmarket.my.product.opt.ProductOptService;
import com.zmarket.my.product.opt.ProductOpts;

@Controller
public class SellerController {
	@Resource(name="productService")
	private ProductService productService;
	@Resource(name="productImgService")
	private ProductImgService productImgService;
	@Resource(name="productOptService")
	private ProductOptService productOptService;
	@Resource(name="categoryService")
	private CategoryService categoryService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setProductImgService(ProductImgService productImgService) {
		this.productImgService = productImgService;
	}

	public void setProductOptService(ProductOptService productOptService) {
		this.productOptService = productOptService;
	}
	
	@RequestMapping(value="/")
	public String defaultPage() {
		return "redirect:/seller/main.do";
	}
	
	@RequestMapping(value="/seller/main.do")
	public ModelAndView main(HttpSession session) {
		ArrayList<Product> prodList = productService.getProductsBySeller(Integer.parseInt(session.getAttribute("num").toString()));
		ModelAndView mav = new ModelAndView("seller/main");
		mav.addObject("PRODLIST", prodList);
		return mav;
	}
	
	@RequestMapping(value="/seller/newProduct.do")
	public ModelAndView newProduct() {
		ArrayList<Category> list = categoryService.getAllCategory();
		ModelAndView mav = new ModelAndView("seller/new");
		mav.addObject("CATE_LIST", list);
		return mav; 
	}

	@RequestMapping(value="/seller/addProduct.do")
	public String addProduct(Product p, ProductOpts pos, @RequestParam(value="img", required=false)MultipartFile[] imgs, HttpSession session) {
		int num = productService.getProductNum();
		p.setNum(num);
		p.setSeller_num(Integer.parseInt(session.getAttribute("num").toString()));
		productService.setProduct(p);	// 제품 기본 정보 저장
		
		// 옵션이 있는 경우에만
		if(pos.getPoList() != null){
			for(ProductOpt po : pos.getPoList()) {
				po.setProd_num(num);
				System.out.println(po);
				productOptService.setProductOpt(po);
			}
		}

		
		// 사진이 있는 경우에만
		if(imgs != null) {
			for(MultipartFile img : imgs) {
				ProductImg pi = new ProductImg();
				pi.setProd_num(num);
				String currTime = Long.toString(System.currentTimeMillis()); 
				pi.setName(currTime);	// 파일명을 현재 시각으로 바꿈
				String path = ProductImg.FOLDERPATH + currTime;
				File file = new File(path);
				try {
					img.transferTo(file);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				pi.setPath("/imgs/" + currTime);
				productImgService.setProductImg(pi);
			}
		}
		
		return "redirect:/seller/main.do";
	}
	
	@RequestMapping(value="/seller/setOptions.do")
	public ModelAndView newOption(@RequestParam(value="level")int level) {
		ModelAndView mav = new ModelAndView("seller/setOptions");
		mav.addObject("level", level);
		return mav;
	}
	
	@RequestMapping(value="/seller/productDetail.do")
	public ModelAndView productDetail(@RequestParam(value="num")int num) {
		ModelAndView mav = new ModelAndView("seller/productDetail");
		Product p = productService.getProduct(num);
		ArrayList<ProductOpt> poList = productOptService.getAllProductOpts(num);
		ArrayList<ProductImg> piList = productImgService.getAllProductImgs(num);
		mav.addObject("PRODUCT", p);
		mav.addObject("PROD_OPTS", poList);
		mav.addObject("PROD_IMGS", piList);
		return mav;
	}
	
	@RequestMapping(value="/seller/deleteProduct.do")
	public String deleteProduct(@RequestParam(value="num")int num) {
		ArrayList<ProductImg> piList = productImgService.getAllProductImgs(num);
		if(piList != null) {
			for(ProductImg pi : piList){
				System.out.println(ProductImg.FOLDERPATH + pi.getName() + "파일 삭제");
				File file = new File(ProductImg.FOLDERPATH + pi.getName());
				file.delete();
			}
		}
		productService.deleteProduct(num);
		return "redirect:/seller/main.do";
	}
	
	@RequestMapping(value="/seller/editDefaultInfoForm.do")
	public ModelAndView editDefaultInfo(@RequestParam(value="num")int num) {
		ModelAndView mav = new ModelAndView("seller/editDefaultInfo");
		Product p = productService.getProduct(num);
		ArrayList<Category> categoryList = categoryService.getAllCategory();
		int parentCategoryNum = 0;
		for(Category c : categoryList) {
			if(c.getNum() == p.getCategory_num())
				parentCategoryNum = c.getParent_category_num();
		}
		mav.addObject("PRODUCT", p);
		mav.addObject("CATE_LIST", categoryList);
		mav.addObject("PARENT_CATE_NUM", parentCategoryNum);
		return mav;
	}
	
	@RequestMapping(value="/seller/editOptionsInfoForm.do")
	public ModelAndView editOptionsInfo(@RequestParam(value="num")int num) {
		ModelAndView mav = new ModelAndView("seller/editOptionsInfo");
		ArrayList<ProductOpt> poList = productOptService.getAllProductOpts(num);
		mav.addObject("PROD_OPT_LIST", poList);
		return mav;
	}
	
	@RequestMapping(value="/seller/editImgsInfoForm.do")
	public ModelAndView editImgsInfo(@RequestParam(value="num")int num, @RequestParam(value="img_num", required=false)Integer imgNum) {
		if(imgNum != null) {
			productImgService.deleteProductImg(imgNum);
		}
		ModelAndView mav = new ModelAndView("seller/editImgsInfo");
		ArrayList<ProductImg> piList = productImgService.getAllProductImgs(num);
		mav.addObject("PROD_NUM", num);
		mav.addObject("PROD_IMG_LIST", piList);
		return mav;
	}
	
	@RequestMapping(value="/seller/addNewOptionsForm.do")
	public ModelAndView addNewOptions(@RequestParam(value="num")int num) {
		ModelAndView mav = new ModelAndView("seller/addNewOptions");
		mav.addObject("PROD_NUM", num);
		return mav;
	}
	
	@RequestMapping(value="/seller/addNewImgsForm.do")
	public ModelAndView addNewImgs(@RequestParam(value="num")int num) {
		ModelAndView mav = new ModelAndView("seller/addNewImgs");
		mav.addObject("PROD_NUM", num);
		return mav;
	}
	
	@RequestMapping(value="/seller/editDefaultInfo.do")
	public String editDefaultInfo(Product p, HttpSession session) {
		p.setSeller_num(Integer.parseInt(session.getAttribute("num").toString()));
		productService.editProduct(p);
		return "redirect:/seller/productDetail.do?num="+p.getNum();
	}
	
	@RequestMapping(value="/seller/addNewImgs.do")
	public String addNewImgs(@RequestParam(value="img", required=false)MultipartFile[] imgs, @RequestParam(value="num")int num) {
		if(imgs != null) {
			for(MultipartFile img : imgs) {
				ProductImg pi = new ProductImg();
				pi.setProd_num(num);
				String currTime = Long.toString(System.currentTimeMillis()); 
				pi.setName(currTime);	// 파일명을 현재 시각으로 바꿈
				String path = ProductImg.FOLDERPATH + currTime;
				File file = new File(path);
				try {
					img.transferTo(file);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				pi.setPath("/imgs/" + currTime);
				productImgService.setProductImg(pi);
			}
		}
		
		return "redirect:/seller/productDetail.do?num="+num;
	}
	
	@RequestMapping(value="/seller/getProductOpt.do")
	public ModelAndView getTotalPrice(@RequestParam(value="options")String options, @RequestParam(value="prod_num")int prod_num) {
		System.out.println("ff");
		ModelAndView mav = new ModelAndView("/JSON/productOptJSON");
		options = options.replace("-", " / ");
		System.out.println("test : "+options);
		ProductOpt po = new ProductOpt();
		po.setProd_num(prod_num);
		po.setOptions(options);
		ProductOpt productOpt = productOptService.getProductOptByProdNumAndOption(po);
//		mav.addObject("NUM", productOpt.getNum());
//		mav.addObject("PRICE", price);
//		mav.addObject("OPTIONS", productOpt.getOptions());
//		mav.addObject("AMOUNT", productOpt.getAmount());
		mav.addObject("PROD_OPT", productOpt);
		return mav;
	}
}
