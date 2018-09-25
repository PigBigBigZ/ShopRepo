package com.yc.web.controller;



import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yc.bean.Goods;
import com.yc.bean.Gtype;
import com.yc.bean.Image;
import com.yc.biz.GoodsBiz;
import com.yc.dao.ImageDao;

@Controller
public class GoodsAction {
	@Resource
	private GoodsBiz gBiz;
	
	@Resource 
	ImageDao dao;

	@RequestMapping("addGoods.do")
	public String addGoods(String gname,Double gprice,Integer typeid,
		   Integer gcount,HttpSession session,HttpServletRequest request,MultipartFile file){
		
		Goods goods=new Goods();
		goods.setGname(gname);
		goods.setGprice(gprice);
		Gtype gtype=new Gtype();
		gtype.setTypeid(typeid);
		goods.setGtype(gtype);
		goods.setGcount(gcount);
		Image image=new Image();
		
	    String fileName = file.getOriginalFilename();
	    
	    String uploadPath = "/images";
		uploadPath = session.getServletContext().getRealPath(uploadPath);
		System.out.println(uploadPath);
	    
	    String filePath = request.getSession().getServletContext().getRealPath("/")+ "../shopping/images/";
	    try {
			FileUtil.uploadFile(file.getBytes(), filePath, fileName);
			Image image2=new Image();
			image2.setImgname(fileName);
			image2.setImgtype(1);
			String path=uploadPath.substring(uploadPath.lastIndexOf("\\"));
			//System.out.println(path);
			image2.setPath(path);
			
			dao.save(image2);
			image.setImgid(image2.getImgid());
			goods.setImage(image);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		gBiz.addGoods(goods);
		
		return "manageGoods";
	}
	
	/*@RequestMapping("addGoods.do")
	public String addGoods(String gname,Double gprice,Integer typeid,
			Integer gcount,Integer imgid){
		Goods goods=new Goods();
		goods.setGname(gname);
		goods.setGprice(gprice);
		Gtype gtype=new Gtype();
		gtype.setTypeid(typeid);
		goods.setGtype(gtype);
		goods.setGcount(gcount);
		Image image=new Image();
		image.setImgid(imgid);
		goods.setImage(image);
		Integer gsail=0;
		goods.setGsail(gsail);
		gBiz.addGoods(goods);
		return "redirect:manageGoods.jsp";
<<<<<<< HEAD
	}*/



	
	@RequestMapping("findGoodsByPage.do")
	public String findGoodsByPage(ModelMap modelMap,@RequestParam(value = "page", defaultValue = "1") Integer page,
	        @RequestParam(value = "size", defaultValue = "10") Integer size){

		Page<Goods> datas=gBiz.findGoodsByPage(page, size);
		
		modelMap.addAttribute("datas", datas);
		modelMap.addAttribute("count", gBiz.countGoods());
		return "manageGoods";
		//spring.mvc.view.prefix=/WEB-INF/page/
	}
	
	//删除某个商品
	@RequestMapping("delGoods.do")
	public void delGoods(@RequestParam(value="gid") Integer gid){
		gBiz.delGoods(gid);
	}
	
	//更新某个商品
	@RequestMapping("updateGoods.do")
	public String updateGoods(Integer gid, String gname,Double gprice,Integer typeid,
			Integer gcount){
		Goods goods1=gBiz.findGoodsById(gid);
		Goods goods=new Goods();
		goods.setGid(gid);
		goods.setGname(gname);
		goods.setGprice(gprice);
		Gtype gtype=new Gtype();
		gtype.setTypeid(typeid);
		goods.setGtype(gtype);
		goods.setGcount(gcount);
		goods.setGsail(goods1.getGsail());
		goods.setImage(goods1.getImage());
		gBiz.updataGoods(goods);
		return "redirect:manageGoods.jsp";
	}
	
	
	//根据id查商品
	@RequestMapping("findGoodsById.do")
	public String findGoodsById(Integer gid,Model model){
		Goods goods=gBiz.findGoodsById(gid);
		model.addAttribute("goods",goods);
		return "updateGoods";
	}
	

	/*@RequestMapping("findGoodAndImg.do")
	public  void  findGoodAndImg(HttpSession session,HttpSession model){
		List<Object[]> list=gBiz.findAllGoods();
		 String Gname=(String) list.get(0)[0];
		 Double Gprice= (Double) list.get(0)[1];
		 
		String path=(String) list.get(0)[2];
		String imgname=(String) list.get(0)[4];
		
		//File[] files=gBiz.findGoodsImgFile(imgname, path);
		//System.out.println(files);
		//files[0].
	   model.setAttribute("GoodAndImg", list);
	   model.addAttribute("path", path);
	   model.addAttribute("imgname", imgname);
	   model.addAttribute("Gname", Gname);
	   model.addAttribute("Gprice", Gprice);
		
	}*/
	
	@ResponseBody
	@RequestMapping("findChildGoods.do")
	public List<Object[]> findChildGoods(HttpSession session,HttpSession model,Integer gtypeid){
		List<Object[]> list=gBiz.findChildGoods(gtypeid);
		model.setAttribute("list", list);
		return list;
	}
	

	
	@RequestMapping("findGoodsAndImgs.do")
	public void findGoodsAndImgs(HttpSession session,HttpSession model){
		List<Integer> list1=gBiz.GroupByTypeid();
		List<List<Object[]>> list = new ArrayList<List<Object[]>>();
		for(Integer gtypeid:list1){
			List<Object[]> list2=gBiz.findGoodsAndImg(gtypeid);
			if(list2!=null && list2.size()>0){
				list.add(list2);
			}
		}
		model.setAttribute("GoodsAndImgs", list);
	}
	
	@RequestMapping("introduction.do")
	public void findGoodsIntroduction(HttpSession model){
		
		
	}

}
