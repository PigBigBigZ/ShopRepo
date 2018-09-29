<%@page import="com.yc.bean.Address"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

		<title>结算页面</title>

		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />

		<link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="../css/cartstyle.css" rel="stylesheet" type="text/css" />

		<link href="../css/jsstyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="../js/address.js"></script>
		 <%
		    String img = request.getParameter("img");
			String Gname = request.getParameter("Gname");
			String Gprice = request.getParameter("Gprice");
         %>
		
	<script>
	    $(function(){
	    	
		   $.ajax({
			   url:"../addAddress.do",
			   success:function(data){
				   
			   }
		   });
	   });  
	</script>
	
  
	</head>
   
	<body>

		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<a href="login.html" target="_top" class="h">亲，请登录</a>
						<a href="register.html" target="_top">免费注册</a>
					</div>
				</div>
			</ul>
			<ul class="message-r">
				<div class="topMessage home">
					<div class="menu-hd"><a href="home3.html" target="_top" class="h">商城首页</a></div>
				</div>
				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng"><a href="../person/index.html" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd"><a id="mc-menu-hd" href="shopcart.html" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
				</div>
				<div class="topMessage favorite">
					<div class="menu-hd"><a href="../person/collection.html" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
			</ul>
			</div>

			<!--悬浮搜索框-->

			<div class="nav white">
				<div class="logo"><img src="../images/logo.png" /></div>
				<div class="logoBig">
					<li><img src="../images/logobig.png" /></li>
				</div>

				<div class="search-bar pr">
					<a name="index_none_header_sysc" href="#"></a>
					<!-- <form>
						<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
						<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
					</form> -->
				</div>
			</div>

			<div class="clear"></div>
			<div class="concent">
				<!--地址 -->
				<div class="paycont">
					<div class="address">
						<h3>确认收货地址 </h3>
						<div class="control">
							<div class="tc-btn createAddr theme-login am-btn am-btn-danger">使用新地址</div>
						</div>
						<div class="clear"></div>
						<ul>
							<div class="per-border"></div>
							<c:forEach items="${addresslist }" var="a">
							<li class="user-addresslist defaultAddr edit">

								<div class="address-left">
									<div class="user DefaultAddr">
										<span class="buy-address-detail">   
                                        <span class="buy-user name">${a.addname}</span>
										<span class="buy-phone phone">${a.phone}</span>
										</span>
									</div>
									<div class="default-address DefaultAddr">
										<span class="buy-line-title buy-line-title-type">收货地址：</span>
										<span class="buy--address-detail">
								   <span class="province p" >${a.province}</span>
										<span class="city c">${a.city }</span>
										<span class="dist d">${a.dist }</span>
										<span class="street s">${a.street}</span>
										<span class="street xiangxi">${a.address}</span>
										</span>
									</div>
									
								</div>
								<div class="address-right">
									<a href="../person/address.html">
										<span class="am-icon-angle-right am-icon-lg"></span></a>
								</div>
								<div class="clear"></div>

								<div class="new-addr-btn">
									<a href="#" class="hidden">设为默认</a>
									<span class="new-addr-bar hidden">|</span>
									<a href="../person/address.jsp">编辑</a>
									<span class="new-addr-bar">|</span>
									<a href="javascript:void(0);" onclick="delClick(this);">删除</a>
								</div>

							</li>
							</c:forEach>
						</ul>

						<div class="clear"></div>
					</div>
					

					

					<!--订单 -->
					<div class="concent">
						

							<tr id="J_BundleList_s_1911116345_1" class="item-list">
								<div id="J_Bundle_s_1911116345_1_0" class="bundle  bundle-last">
									<div class="bundle-main">
										<ul class="item-content clearfix">
											<div class="pay-phone">
												<li class="td td-item">
													<div class="item-pic">
														<a href="#" class="J_MakePoint">
															<img src="../images/${param.img }" class="itempic J_ItemImg" style="width:80px;height:80px"></a>
													</div>
													<div class="item-info">
														<div class="item-basic-info">
															<a href="#" target="_blank" title="${param.Gname }" class="item-title J_MakePoint" data-point="tbcart.8.11">${param.Gname }</a>
														</div>
													</div>
												</li>
												
												<li class="td td-price">
													<div class="item-price price-promo-promo">
														<div class="price-content">
														    <em class="J_Price price-now">单价:</em>
															<em class="J_Price price-now">${param.Gprice }</em>
														</div>
													</div>
												</li>
											</div>

											<li class="td td-amount">
												<div class="amount-wrapper ">
													<div class="item-amount ">
														<span class="phone-title">购买数量</span>
														<div class="sl" id="price">
															<input class="min am-btn" name="jian" type="button" value="-"  />
															<input  class="text_box" name="price1" type="text" value="1" style="width:30px;" />
															<input class="add am-btn" name="jia" type="button" value="+" />
														</div>
														
													</div>
												</div>
											</li>
											<li class="td td-sum">
												<div class="td-inner">
												    <em tabindex="0" class="J_ItemSum number" >总价:</em>
													<em tabindex="0" class="J_ItemSum number" id="count">117.00</em>
												</div>
											</li>
											<li class="td td-oplist">
												<div class="td-inner">
													<span class="phone-title">配送方式</span>
													<div class="pay-logis">
														包邮
													</div>
												</div>
											</li>

										</ul>
										<div class="clear"></div>

									</div>
							</tr>
							</div>
							<div class="clear"></div>
							<div class="pay-total">
						
							</div>
							<!--含运费小计 -->
							<div class="buy-point-discharge ">
								<p class="price g_price ">
									合计（含运费） <span>¥</span><em class="pay-sum" id="sj">244.00</em>
								</p>
							</div>

							<!--信息 -->
							<form  method="post">
							<div class="order-go clearfix">
								<div class="pay-confirm clearfix">
									<div class="box">
										<div tabindex="0" id="holyshit267" class="realPay"><em class="t">实付款：</em>
											<span class="price g_price ">
                                    <span>¥</span> <em class="style-large-bold-red " id="J_ActualFee" name="AllCount" >244.00</em>
											</span>
										</div>

										<div id="holyshit268" class="pay-address">

											<p class="buy-footer-address">
												<span class="buy-line-title buy-line-title-type">寄送至：</span>
												<span class="buy--address-detail">
								   <span class="province" id="sf">湖北省</span>
												<span class="city" id="cs">武汉市</span>
												<span class="dist" id="dq">洪山区</span>
												<span class="street" id="jd">雄楚大道666号(中南财经政法大学)</span>
												<span class="street" id="xiangxi"></span>
												</span>
												</span>
											</p>
											<p class="buy-footer-address">
												<span class="buy-line-title">收货人：</span>
												<span class="buy-address-detail">   
                                         <span class="buy-user" id="name">艾迪 </span>
												<span class="buy-phone " id="phone">15871145629</span>
												</span>
											</p>
										</div>
									</div>

									<div id="holyshit269" class="submitOrder">
										<div class="go-btn-wrap">
										<a id="J_Go" type="submit" class="btn-go" tabindex="0" title="点击此按钮，提交订单" onclick="order()">提交订单</a>
										    <!-- <a>
											<input id="J_Go" type="submit" class="btn-go" tabindex="0" title="点击此按钮，提交订单" onclick="order()"></input></a> -->
										</div>
									</div>
									<div class="clear"></div>
								</div>
							</div>
							
							</form>
							
						</div>

						<div class="clear"></div>
					</div>
				</div>
				<div class="footer">
					<div class="footer-hd">
						<p>
							<a href="#">恒望科技</a>
							<b>|</b>
							<a href="#">商城首页</a>
							<b>|</b>
							<a href="#">支付宝</a>
							<b>|</b>
							<a href="#">物流</a>
						</p>
					</div>
					<div class="footer-bd">
						<p>
							<a href="#">关于恒望</a>
							<a href="#">合作伙伴</a>
							<a href="#">联系我们</a>
							<a href="#">网站地图</a>
							<em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
						</p>
					</div>
				</div>
			</div>
			<div class="theme-popover-mask"></div>
			
			<div class="theme-popover" >

				<!--标题 -->
				<div class="am-cf am-padding">
					<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add address</small></div>
				</div>
				<hr/>

				<div class="am-u-md-12">
					<form class="am-form am-form-horizontal" method="post">

						<div class="am-form-group">
							<label for="user-name" class="am-form-label">收货人</label>
							<div class="am-form-content">
								<input type="text" id="user-name" placeholder="收货人">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-phone" class="am-form-label">手机号码</label>
							<div class="am-form-content">
								<input id="user-phone" placeholder="手机号必填" type="email">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-phone" class="am-form-label">所在地</label>
							<div class="am-form-content address">
								<select data-am-selected >
									<option value="a">浙江省 </option>
									<option value="b">湖北省 </option>
								</select>
								<select data-am-selected>
									<option value="a">温州市 </option>
									<option value="b">武汉市 </option>
								</select>
								<select data-am-selected>
									<option value="a">瑞安区 </option>
									<option value="b">洪山区 </option>
								</select>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-intro" class="am-form-label">详细地址</label>
							<div class="am-form-content">
								<textarea class="" rows="3" id="user-intro" placeholder="输入详细地址"></textarea>
								<small>100字以内写出你的详细地址...</small>
							</div>
						</div>

						<div class="am-form-group theme-poptit">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<div class="am-btn am-btn-danger" onclick="addAddress()">保存</div>
								<div class="am-btn am-btn-danger close">取消</div>
							</div>
						</div>
					</form>
				</div>

			</div>
			

			<div class="clear"></div>
			
			<script type="text/javascript">
			
			
			
			
			function addAddress(){
				var username=$('#user-name').val();
				var userphone=$('#user-phone').val();
				var address = $(".address option:selected").text();
				var sf=address.split(' ')[0];
				var cs=address.split(' ')[1];
				var dq=address.split(' ')[2];
				var userintro=$('#user-intro').val();
				document.forms[1].action="../address.do?username="+username+"&userphone="
					+userphone+"&sf="+sf+"&cs="+cs+"&dq="+dq+"&userintro="+userintro;
	    		 document.forms[1].submit();
			}
			
			$(document).ready(function(){
			var count = $("input[name='price1']").val();
			var Gprice=${param.Gprice };
			var total =count*Gprice;
			 var divshow = $('#count');
			 var sfk=$('#J_ActualFee');
			 var sj=$('#sj');
			 divshow.text("");// 清空数据
             divshow.append(total);
			 sfk.text("");
			 sfk.append(total);
			 sj.text("");
			 sj.append(total);
		})
		
		 $("input[name='jia']").on("click", function () {
			    var count = $("input[name='price1']").val();
			    count=(parseInt(count)+parseInt(1));
				var Gprice=${param.Gprice };
				var total =count*Gprice;
				 var divshow = $('#count');
				 var divshow = $('#count');
				 var sfk=$('#J_ActualFee');
				 var sj=$('#sj');
				 var sfk=$('#J_ActualFee');
				 var sj=$('#sj');
				 divshow.text("");// 清空数据
	             divshow.append(total);
				 sfk.text("");
				 sfk.append(total);
				 sj.text("");
				 sj.append(total);
          });
			
		$("input[name='jian']").on("click", function () {
				    var count = $("input[name='price1']").val();
				    count=(parseInt(count)-parseInt(1));
					var Gprice=${param.Gprice };
					var total =count*Gprice;
					var divshow = $('#count');
					var sfk=$('#J_ActualFee');
					var sj=$('#sj');
					 divshow.text("");// 清空数据
		             divshow.append(total);
					 sfk.text("");
					 sfk.append(total);
					 sj.text("");
					 sj.append(total);
	      });
		
		 function order(){
			         var sfk=$('#J_ActualFee').text();
			         var address=$('#sf').html()+"  "+$('#cs').html()+"  "+$('#dq').html()+"  "+$('#jd').html()+"  "+$('#xiangxi').html();
			         var name=$('#name').html();
			         var phone=$('#phone').html();
			       	 document.forms[0].action="../addOrderform.do?AllCount="+sfk+"&address="+address+"&name="+name+"&phone="+phone;
		    		 document.forms[0].submit();
		    	}
		  
		 
		 $(".edit").on("click", function(){
			 var p=$('#sf');
			 var c=$('#cs');
			 var d=$('#dq');
			 var s=$('#jd');
			 var name=$('#name');
			 var phone=$('#phone');
			 var address=$('#xiangxi');
			 p.text("");
			 c.text("");
			 d.text("");
			 s.text("");
			 name.text("");
			 phone.text("");
			 address.text("");
			 var oldp=$(this).find('.p').html();
			 var oldc=$(this).find('.c').html();
			 var oldd=$(this).find('.d').html();
			 var olds=$(this).find('.s').html();
			 var oldname=$(this).find('.name').html();
			 var oldphone=$(this).find('.phone').html();
			 var oldaddress=$(this).find('.xiangxi').html();
			 
			 p.append(oldp);
			 c.append(oldc);
			 d.append(oldd);
			 s.append(olds);
			 name.append(oldname);
			 phone.append(oldphone);
			 address.append(oldaddress);
			 });
	
    </script>
	</body>

</html>