<%@page import="com.yc.bean.Gtype"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<title>首页</title> 
	<%
 	/*  List<Object[]> list =(List<Object[]>)request.getSession().getAttribute("list");
 	for(Object[] a:list){
 	   out.print(a[0]);
 	   out.print(a[1]);
 	   out.print("&nbsp;");
 	} */

 	/* List<Object[]> list2=(List<Object[]>)session.getAttribute("GoodAndImg");
 	out.print(list2);
 	 */
    %>

	<c:set value="${pageContext.request.contextPath}" var="path"
		scope="page" />
	<link href="${path}/AmazeUI-2.4.2/assets/css/amazeui.css"
		rel="stylesheet" type="text/css" />
	<link href="${path}/AmazeUI-2.4.2/assets/css/admin.css"
		rel="stylesheet" type="text/css" />

	<link href="${path}/basic/css/demo.css" rel="stylesheet"
		type="text/css" />

	<link href="${path}/css/hmstyle.css" rel="stylesheet" type="text/css" />
	<script src="${path}/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
	<script src="${path}/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
	
	<script>
	   $(function(){
		   $.ajax({
			   url:"${path}/findGoodsAndImgs.do",
			   success:function(data){}
		   });
	   });
	</script>
</head>

<body>
	<div class="hmtop">
		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<%
							if (session.getAttribute("loginedUser") != null) {
						%>
						欢迎您： ${loginedUser.uname }
						<%
							} else {
						%>
						<a href="login.html" target="_top" class="h">亲，请登录</a>
						<%
							}
						%>
						<a href="register" target="_top">免费注册</a>
					</div>
				</div>
			</ul>
			<ul class="message-r">
				<div class="topMessage home">
					<div class="menu-hd">
						<a href="home3.html" target="_top" class="h">商城首页</a>
					</div>
				</div>
				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng">
						<a href="${path}/person/index.html" target="_top"><i
							class="am-icon-user am-icon-fw"></i>个人中心</a>
					</div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd">
						<a id="mc-menu-hd" href="shopcart.html" target="_top"><i
							class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
							id="J_MiniCartNum" class="h">0</strong></a>
					</div>
				</div>
				<div class="topMessage favorite">
					<div class="menu-hd">
						<a href="${path}/person/collection.html" target="_top"><i
							class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>

					</div>
			</ul>
		</div>

		<!--悬浮搜索框-->


		<div class="nav white">
			<div class="logo">
				<img src="${path}/images/logo.png" />
			</div>
			<div class="logoBig">
				<li><img src="${path}/images/logobig.png" /></li>
			</div>

			<div class="search-bar pr">
				<a name="index_none_header_sysc" href="#"></a>
				<form>
					<input id="searchInput" name="index_none_header_sysc" type="text"
						placeholder="搜索" autocomplete="off"/> <input
						id="ai-topsearch" class="submit am-btn" value="搜索" index="1"
						type="submit"/>
				</form>
			</div>
		</div>

		<div class="clear"></div>
	</div>



	<div class="banner">
		<!--轮播 -->
		<div class="am-slider am-slider-default scoll" data-am-flexslider
			id="demo-slider-0">
			<ul class="am-slides">
				<li class="banner1"><a href="introduction.html"><img
						src="${path}/images/ad1.jpg" /></a></li>
				<li class="banner2"><a><img src="${path}/images/ad2.jpg" /></a></li>
				<li class="banner3"><a><img src="${path}/images/ad3.jpg" /></a></li>
				<li class="banner4"><a><img src="${path}/images/ad4.jpg" /></a></li>

			</ul>
		</div>
		<div class="clear"></div>
	</div>


	<div class="shopNav">
		<div class="slideall">


			<div class="long-title">
				<span class="all-goods">全部分类</span>
			</div>



			<!--侧边导航 -->
			<div id="nav" class="navfull">
				<div class="area clearfix">
					<div class="category-content" id="guide_2">
						<%-- <%
									List<Gtype> list2=(List<Gtype>)request.getAttribute("list2");
									/* String gtypename=list2.get(0).getTypename();
									System.out.print(gtypename); */
									%> --%>
						<div class="category">
							<ul class="category-list" id="js_climit_li">
								<c:forEach items="${list2 }" var="list2">
									<li class="appliance js_toggle relative first" id="classf">
										<div class="category-info edit" edit="${list2.typeid}"
											id="findChildGood">
											<h3 class="category-name b-category-name">
												<i><img src="${path}/images/cake.png"></i><a
													class="ml-22" title="点心">${list2.typename}</a>
											</h3>
											<em>&gt;</em>
										</div>
										<div class="menu-item menu-in top">
											<div class="area-in">
												<div class="area-bg">
													<div class="menu-srot">
														<div class="sort-side second_class">
															<dl class="dl-sort">
															</dl>
														</div>
													</div>
												</div>
											</div>
										</div> <b class="arrow"></b>
									</li>
								</c:forEach>

							</ul>

						</div>
					</div>
				</div>
			</div>
			<b class="arrow"></b>
		</div>
	</div>


	<!--轮播 -->
	<script type="text/javascript">
		(function() {
			$('.am-slider').flexslider();
		});
		$(document)
				.ready(
						function() {
							$("li")
									.hover(
											function() {
												$(
														".category-content .category-list li.first .menu-in")
														.css("display", "none");
												$(
														".category-content .category-list li.first")
														.removeClass("hover");
												$(this).addClass("hover");
												$(this)
														.children("div.menu-in")
														.css("display", "block")
											},
											function() {
												$(this).removeClass("hover")
												$(this).children("div.menu-in")
														.css("display", "none")
											});
						})

		$(".edit")
				.on(
						"click",
						function() {
							$("#js_climit_li .second_class ").empty();
							var id = $(this).attr("edit");
							var $id = $(this);
							$
									.post({
										url : "../findChildGoods.do",
										data : "gtypeid=" + id,
										success : function(data) {
											var flag = 1;
											$
													.each(
															data,
															function(i, n) {
																if (flag == 1) {
																	$id
																			.parent()
																			.find(
																					".second_class")
																			.append(
																					"<dt><span title='蛋糕'>"
																							+ n[1]
																							+ "</span> </dt> <br>");
																	flag = 0;
																}
																$id
																		.parent()
																		.find(
																				".second_class")
																		.append(
																				"<dd><a href=''>"
																						+ n[0]
																						+ "</a></dd>");
															});

										}
									});
						});

		var data = null;
		$(document).ready(function() {
			$.post('../findAll.do', data, function(data) {
			});
		});
		
	 

		
		
		
		/* $(".document").ready(function() {
					var id = $(".gtid").attr("gtid");
					var $id = $(".gtid"); 
					$.post({
								url : "../findGoodsAndImgs.do",
								data : "gtypeid=" + id,
								success : function(data) {
								}
							});
				});
 */
		
		
		
		
		/* $(document).ready(function() {
			var id = $("#gtid").attr("gtid");
			var $id = $(this);
			alert($id.val);
			$.post('../findChildGoods.do', {'gtypeid':2}, function(data) {
			});
		}); */
		
	
	</script>


	<!--小导航 -->
	<div class="am-g am-g-fixed smallnav">
		<div class="am-u-sm-3">
			<a href="sort.html"><img src="${path}/images/navsmall.jpg" />
				<div class="title">商品分类</div></a>
		</div>


		<div class="am-u-sm-3">
			<a href="${path}/person/index.html"><img
				src="${path}/images/mansmall.jpg" />
				<div class="title">个人中心</div> </a>
		</div>


	</div>

	<!--走马灯 -->

	<div class="marqueen">
		<span class="marqueen-title">商城头条</span>
		<div class="demo">

			<ul>
				<li class="title-first"><a target="_blank" href="#"> <img
						src="${path}/images/TJ2.jpg"></img> <span>[特惠]</span>商城爆品1分秒
				</a></li>
				<li class="title-first"><a target="_blank" href="#"> <span>[公告]</span>商城与广州市签署战略合作协议
						<img src="${path}/images/TJ.jpg"></img>
						<p>XXXXXXXXXXXXXXXXXX</p>
				</a></li>

				<div class="mod-vip">
					<div class="m-baseinfo">
						<a href="${path}/person/index.html"> <img
							src="${path}/images/getAvatar.do.jpg"></a> <em> Hi,<span
							class="s-name">小叮当</span> <a href="#"><p>点击更多优惠活动</p></a>
						</em>
					</div>

					<div class="member-logout">
						<a class="am-btn-warning btn" href="login.html">登录</a> <a
							class="am-btn-warning btn" href="register.html">注册</a>
					</div>
					<div class="member-login">
						<a href="${path}/person/order.html"><strong>0</strong>待收货</a> <a
							href="#"><strong>0</strong>待发货</a> <a href="#"><strong>0</strong>待付款</a>
						<a href="#"><strong>0</strong>待评价</a>
					</div>
					<div class="clear"></div>
				</div>


				<li><a target="_blank" href="#"><span>[特惠]</span>洋河年末大促，低至两件五折</a></li>
				<li><a target="_blank" href="#"><span>[公告]</span>华北、华中部分地区配送延迟</a></li>
				<li><a target="_blank" href="#"><span>[特惠]</span>家电狂欢千亿礼券
						买1送1！</a></li>

			</ul>
			<div class="advTip">
				<img src="${path}/images/advTip.jpg" />
			</div>
		</div>
	</div>
	<div class="clear"></div>
	</div>
	<script type="text/javascript">
		if ($(window).width() < 640) {
			function autoScroll(obj) {
				$(obj).find("ul").animate({
					marginTop : "-39px"
				}, 500, function() {
					$(this).css({
						marginTop : "0px"
					}).find("li:first").appendTo(this);
				})
			}
			$(function() {
				setInterval('autoScroll(".demo")', 3000);
			})
		}
	</script>
	</div>
	<div class="shopMainbg">
		<div class="shopMain" id="shopmain">

			<!--今日推荐 -->

			<div class="am-g am-g-fixed recommendation">
				<div class="clock am-u-sm-3"">
					<img src="${path}/images/2016.png "></img>
					<p>
						今日<br>推荐 
					</p>
				</div>
				<div class="am-u-sm-4 am-u-lg-3 ">
					<div class="info ">
						<h3>真的有鱼</h3>
						<h4>开年福利篇</h4>
					</div>

					<div class="recommendationMain ">
						<img src="${path}/images/tj.png "></img>
					</div>
				</div>
				<div class="am-u-sm-4 am-u-lg-3 ">
					<div class="info ">
						<h3>囤货过冬</h3>
						<h4>让爱早回家</h4>
					</div>
					<div class="recommendationMain ">
						<img src="${path}/images/tj1.png "></img>
					</div>
				</div>
				<div class="am-u-sm-4 am-u-lg-3 ">
					<div class="info ">
						<h3>浪漫情人节</h3>
						<h4>甜甜蜜蜜</h4>
					</div>
					<div class="recommendationMain ">
						<img src="${path}/images/tj2.png "></img>
					</div>
				</div>

			</div>
			<div class="clear "></div>
			<!--热门活动 -->

			<div class="am-container activity ">
				<div class="shopTitle ">
					<h4>活动</h4>
					<h3>每期活动 优惠享不停</h3>
					<span class="more "> <a class="more-link " href="# ">全部活动</a>
					</span>
				</div>

				<div class="am-g am-g-fixed ">
					<div class="am-u-sm-3 ">
						<div class="icon-sale one "></div>
						<h4>秒杀</h4>
						<div class="activityMain ">
							<img src="${path}/images/activity1.jpg "></img>
						</div>
						<div class="info ">
							<h3>春节送礼优选</h3>

						</div>
					</div>

					<div class="am-u-sm-3 ">
						<div class="icon-sale two "></div>
						<h4>特惠</h4>
						<div class="activityMain ">
							<img src="${path}/images/activity2.jpg "></img>
						</div>
						<div class="info ">
							<h3>春节送礼优选</h3>
						</div>
					</div>


					<div class="am-u-sm-3 ">
						<div class="icon-sale three "></div>
						<h4>团购</h4>
						<div class="activityMain ">
							<img src="${path}/images/activity3.jpg "></img>
						</div>
						<div class="info ">
							<h3>春节送礼优选</h3>
						</div>
					</div>

					<div class="am-u-sm-3 last ">
						<div class="icon-sale "></div>
						<h4>超值</h4>
						<div class="activityMain ">
							<img src="${path}/images/activity.jpg "></img>
						</div>
						<div class="info ">
							<h3>春节送礼优选</h3>
						</div>

					</div>

				</div>
			</div>
			<div class="clear "></div>
 
			<!--甜点-->
            <c:forEach items="${list2 }" var="l2" begin="0" end="0">
						<div class="am-container ">
							<div class="shopTitle gtid">
								<h4>${l2.typename}</h4>
								<h3>纯天然，让你融入大自然</h3>
								<div class="today-brands ">
									<a href="# ">葡萄</a> <a href="# ">苹果</a> <a href="# ">香蕉 </a> <a
										href="# ">西瓜</a> <a href="# ">菠萝</a> <a href="# ">梨子</a>
								</div>
								<span class="more "> <a class="more-link " href="# ">更多美味</a>
								</span>
							</div>
						</div>

						<c:forEach items="${GoodsAndImgs.get(0)}" var="a">
							
								<div class="am-u-sm-5 am-u-md-3 am-u-lg-4 text-one "  style="width:350px;">
									<a href="introduction.jsp?op=${a[3]}&Gname=${a[0]}&Gsail=${a[4]}&Gcount=${a[5]}&Gid=${a[6]}&Gprice=${a[2]}">
											<div class="sub-title " style="padding-left:50px;">${a[0]}</div>
											<div class="sub-title " style="padding-left:50px;">仅售：¥  ${a[2]}</div>
										 <img  class="imgs" src="${path}/images/${a[3]}"  style="width:300px;height:250px;padding-left:50px;"/>
									</a>
								</div>
							
						</c:forEach>
						<div class="clear "></div>
			</c:forEach>
			
			 <c:forEach items="${list2 }" var="l2" begin="1" end="1">
						<div class="am-container ">
							<div class="shopTitle gtid">
								<h4>${l2.typename}</h4>
								<h3>一日香畔之旅，永恒快乐灵感</h3>
								<div class="today-brands ">
									<a href="# ">桂花糕</a> <a href="# ">奶皮酥</a> <a href="# ">栗子糕 </a> <a
										href="# ">马卡龙</a> <a href="# ">铜锣烧</a> <a href="# ">豌豆黄</a>
								</div>
								<span class="more "> <a class="more-link " href="# ">更多美味</a>
								</span>
							</div>
						</div>
						<c:forEach items="${GoodsAndImgs.get(1)}" var="a">
							
								<div class="am-u-sm-5 am-u-md-3 am-u-lg-4 text-one "  style="width:350px;">
									<a href="introduction.jsp?op=${a[3]}&Gname=${a[0]}&Gsail=${a[4]}&Gcount=${a[5]}&Gid=${a[6]}&Gprice=${a[2]}">
											<div class="sub-title " style="padding-left:50px;">${a[0]}</div>
											<div class="sub-title " style="padding-left:50px;">仅售：¥  ${a[2]}</div>
										 <img  class="imgs" src="${path}/images/${a[3]}"  style="width:300px;height:250px;padding-left:50px;"/>
									</a>
								</div>
							
						</c:forEach>
						<div class="clear "></div>
			</c:forEach>
			
			<c:forEach items="${list2 }" var="l2" begin="2" end="2">
			          
						<div class="am-container ">
							<div class="shopTitle gtid">
								<h4>${l2.typename}</h4>
								<h3>美味，非我莫“熟”</h3>
								<div class="today-brands ">
									<a href="# ">卤鸭脖</a> <a href="# ">烤鸭</a> <a href="# ">烧鸡 </a> <a
										href="# ">脆骨</a> <a href="# ">铜锣烧</a> <a href="# ">豌豆黄</a>
								</div>
								<span class="more "> <a class="more-link " href="# ">更多美味</a>
								</span>
							</div>
						</div>
						<c:forEach items="${GoodsAndImgs.get(2)}" var="a">
							
								<div class="am-u-sm-5 am-u-md-3 am-u-lg-4 text-one "  style="width:350px;">
									<a href="introduction.jsp?op=${a[3]}&Gname=${a[0]}&Gsail=${a[4]}&Gcount=${a[5]}&Gid=${a[6]}&Gprice=${a[2]}">
											<div class="sub-title " style="padding-left:50px;">${a[0]}</div>
											<div class="sub-title " style="padding-left:50px;">仅售：¥  ${a[2]}</div>
											
										 <img   class="imgs" src="${path}/images/${a[3]}"  style="width:300px;height:250px;padding-left:50px;"/>
									</a>
								</div>
							
						</c:forEach>
						<div class="clear "></div>
			</c:forEach>
			

	<script>
		window.jQuery
				|| document
						.write('<script src="basic/js/jquery.min.js "><\/script>');
	</script>
	<script type="text/javascript " src="${path}/basic/js/quick_links.js "></script>


<%@ include file="/footer.jsp"%>

 		
