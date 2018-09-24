package com.yc.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.yc.biz.CollectBiz;

@Controller
public class CollectAction {
	@Resource
	private CollectBiz cBiz;
}
