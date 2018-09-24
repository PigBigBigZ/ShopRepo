package com.yc.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.yc.bean.Goods;
import com.yc.bean.Gtype;
import com.yc.biz.GtypeBiz;

@Controller
public class GtypeAction {
	@Resource
	private GtypeBiz gtypeBiz;
	
	@RequestMapping("addGtype.do")
	public String addGtype(String typename,Integer pid){
		Gtype gtype=new Gtype();
		gtype.setTypename(typename);
		gtype.setPid(pid);
		gtypeBiz.addGtype(gtype);
		return "redirect:type.jsp";
	}
	
	@RequestMapping("findGtypeByPage.do")
	public String findGtypeByPage(ModelMap modelMap,@RequestParam(value = "page", defaultValue = "1") Integer page,
	        @RequestParam(value = "size", defaultValue = "10") Integer size){

		Page<Gtype> datas=gtypeBiz.findGtypeByPage(page, size);
		
		modelMap.addAttribute("datas", datas);
		modelMap.addAttribute("count", gtypeBiz.countGtype());
		return "type";
		//spring.mvc.view.prefix=/WEB-INF/page/
	}
	
	
	//删除某个分类
	@RequestMapping("delGtype.do")
	public void delGoods(@RequestParam(value="typeid") Integer typeid){
		gtypeBiz.delGtype(typeid);
	}
	
	
	@RequestMapping("findGtypeById.do")
	public String findGtypeById(Integer typeid,Model model){
		Gtype gtype=gtypeBiz.findGtypeById(typeid);
		model.addAttribute("gtype",gtype);
		return "updateGtype";
	}
	
	
	@RequestMapping("updateGtype.do")
	public String updateGtype(Integer typeid,String typename,Integer pid){
		Gtype gtype=new Gtype();
		gtype.setTypeid(typeid);
		gtype.setTypename(typename);
		gtype.setPid(pid);
		gtypeBiz.updateGtype(gtype);
		
		return "redirect:type.jsp";
	}
	
	@RequestMapping("findAllGtype.do")
	public void findAllGtype(){
		Gson gson=new Gson();
		
		gtypeBiz.findAllGtype();
		
	}
	
	@RequestMapping("findAll.do")
	public void findAll(HttpSession model){
		//System.out.println("shy");
		List<Gtype> list=gtypeBiz.findAll();
		//System.out.println(list);
		model.setAttribute("list2", list);
	}
}
