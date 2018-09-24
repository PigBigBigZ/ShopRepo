<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>亚马孙吃货</title>
		<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
		<link href="${path}/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${path}/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="${path}/basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link type="text/css" href="${path}/css/optstyle.css" rel="stylesheet" />
		<link type="text/css" href="${path}/css/style.css" rel="stylesheet" />
		<link href="${path}/css/personal.css" rel="stylesheet" type="text/css">
		
		<script type="text/javascript" src="${path}/basic/js/jquery-1.7.min.js"></script>
		<script type="text/javascript" src="${path}/basic/js/quick_links.js"></script>

		<script type="text/javascript" src="${path}/AmazeUI-2.4.2/assets/js/amazeui.js"></script>
		<script type="text/javascript" src="${path}/js/jquery.imagezoom.min.js"></script>
		<script type="text/javascript" src="${path}/js/jquery.flexslider.js"></script>
		<script type="text/javascript" src="${path}/js/list.js"></script>
		
		<!-- easyui 引入 -->
		<link rel="stylesheet" type="text/css"
			href="${path}/easyui/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css"
			href="${path}/easyui/themes/icon.css" />
		<script type="text/javascript" src="${path}/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="${path}/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="${path}/easyui/locale/easyui-lang-zh_CN.js"></script> 
	</head>

	<body>
		
			<!--顶部导航条 -->
			<div class="am-container header">
				<ul class="message-l">
					<div class="topMessage">
						<div class="menu-hd">
						<%if(session.getAttribute("logineduser") !=null){ %>
							欢迎您： ${logineduser.uname }
							<%} else { %>
							<a href="login.jsp" target="_top" class="h">亲，请登录</a>
							<% }%>
							<a href="register.jsp" target="_top">免费注册</a>
						</div>
					</div>
				</ul>
				<ul class="message-r">
					<div class="topMessage home">
						<div class="menu-hd"><a href="#" target="_top" class="h">商城首页</a></div>
					</div>
					<div class="topMessage my-shangcheng">
						<div class="menu-hd MyShangcheng"><a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
					</div>
					<div class="topMessage mini-cart">
						<div class="menu-hd"><a id="mc-menu-hd" href="#" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
					</div>
					<div class="topMessage favorite">
						<div class="menu-hd"><a href="javascript:void(0);" onclick="findColByPage(uid=${sessionScope.logineduser.uid})" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
				</ul>
				</div>

				<!--悬浮搜索框-->

				<div class="nav white">
					<div class="logo"><img src="${path}/images/logo.png" /></div>
					<div class="logoBig">
						<li><img src="${path}/images/logobig.png" /></li>
					</div>

					<div class="search-bar pr">
						<a name="index_none_header_sysc" href="#"></a>
						<form>
							<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
							<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
						</form>
					</div>
				</div>

				<div class="clear"></div>
			