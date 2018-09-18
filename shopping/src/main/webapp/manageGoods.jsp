<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" />
		<link rel="stylesheet" href="common/css/Site.css" />
		<link rel="stylesheet" href="common/css/zy.all.css" />
		<link rel="stylesheet" href="common/css/font-awesome.min.css" />
		<link rel="stylesheet" href="common/css/amazeui.min.css" />
	 	<link rel="stylesheet" href="common/css/admin.css" />

		
		<link rel="stylesheet" type="text/css"
			href="easyui/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css"
			href="easyui/themes/icon.css" />
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="easyui/locale/easyui-lang-zh_CN.js"></script> 
			
<!--	 layui实现分页	
		<link rel="stylesheet" href="layui/css/layui.css"  media="all">

 		<script src="layui/layui.js" charset="utf-8"></script>
		
		<script type="text/javascript">
			layui.use(['laypage', 'layer'], function(){
			  var laypage = layui.laypage
			  ,layer = layui.layer;
			  
			  laypage.render({
				    elem: 'dopage'
				    ,count:100 
				    ,curr:1
				    ,limit: 10
				    ,layout: ['count', 'prev', 'page', 'next', 'limit',  'skip']
				    ,jump: function(obj){
				      console.log(obj)
				    }
				  });
		})
		
		
		</script> -->
		
		<script type="text/javascript">
	/*
		当用户选择新的页面时触发，回调函数包含两个参数：
		page:新的页码
		size:新的页面尺寸
	*/
	
	function queryPage(page,size){
		//param EL表达式的内置对象，表示的是请求参数的Map集合
		window.location.href=
			"findGoodsByPage.do?"+
			"page="+page+"&"+
			"size="+size;
	}
</script>
	</head>

	<body>
	
<%
			 if(request.getAttribute("datas")==null){
				 request.getRequestDispatcher("findGoodsByPage.do").forward(request, response);
			 }
%>

		<div class="dvcontent">

			<div>
				<!--tab start-->
				<div class="tabs">
					<div class="hd">
						<ul>
							<li class="on" style="box-sizing: initial;-webkit-box-sizing: initial;">库存管理</li>
							 <li class="" style="box-sizing: initial;-webkit-box-sizing: initial;">添加商品</li>
						</ul>
					</div>
					<div class="bd">
						<ul style="display: block;padding: 20px;">
							<li>
								<!--分页显示角色信息 start-->
								<div id="dv1">
									<table class="table" id="tbRecord">
										<thead>
											<tr>
												<th>商品编号</th>
												<th>商品名称</th>
												<th>商品单价</th>
												<th>商品类型</th>
												<th>商品库存</th>
												<th>商品销量</th>
												<th>编辑</th>
												<th>删除</th>
												
											</tr>
										</thead>
										<tbody>
										<c:forEach items="${datas.content}" var="t">
											<tr>
												<td>${t.gid }</td>
												<td>${t.gname }</td>
												<td>${t.gprice }</td>
												<td>${t.gtype.typename }</td>
												<td>${t.gcount }</td>
												<td>${t.gsail }</td>
												<td class="edit"><button onclick="btn_edit(${t.gid })"><i class="icon-edit bigger-120"></i>编辑</button></td>
												<td class="delete"><button id="del" onclick="btn_delete(${t.gid },this)"><i class="icon-trash bigger-120"></i>删除</button></td>
											</tr>
										</c:forEach>	
										</tbody>
									</table>
									<!--         翻 页         -->
	<div id="pp" class="easyui-pagination" style="background:#efefef;border:1px solid #ccc;"
	    data-options="
	    	total:${count },
	    	pageSize:${empty param.size ? 10 : param.size },
	    	pageNumber:${empty param.page ? 1 : param.page },
	    	onSelectPage:queryPage">
	</div>
								</div>
					<div id="dopage"></div>
							</li>
						</ul>
						<ul class="theme-popbod dform" style="display: none;">
								<div class="am-cf admin-main" style="padding-top: 0px;">
			<!-- content start -->
			
	<div class="am-cf admin-main" style="padding-top: 0px;">
		<!-- content start -->
		<div class="admin-content">
			<div class="admin-content-body">
				
				<div class="am-g">
					<div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
						
					</div>
					<div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4"
						style="padding-top: 30px;">
						<form class="am-form am-form-horizontal"
							action="addGoods.do" method="post">
						
							<div class="am-form-group">
								<label for="name" class="am-u-sm-3 am-form-label">
									商品名称</label>
								<div class="am-u-sm-9">
									<input type="text" id="gname" required
										placeholder="商品名称" name="gname">
								</div>
							</div>
							<div class="am-form-group">
								<label for="name" class="am-u-sm-3 am-form-label">
									商品单价</label>
								<div class="am-u-sm-9">
									<input type="text" id="gprice" required
										placeholder="商品单价" name="gprice">
								</div>
							</div>
							
							<div class="am-form-group">
								<label for="user-email" class="am-u-sm-3 am-form-label">
								分类</label>
								<div class="am-u-sm-9">
										<input type="text" id="typeid" required
										placeholder="商品分类" name="typeid">
<!-- 									<select name="typeId" required>
										<option value="">请选择分类</option>
									</select>  -->
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-intro" class="am-u-sm-3 am-form-label">
									库存</label>
								<div class="am-u-sm-9">
									<input type="text" id="gcount" required
										placeholder="商品库存" name="gcount">
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-intro" class="am-u-sm-3 am-form-label">
									图片</label>
								<div class="am-u-sm-9">
									<input type="file" id="imgid" required
										placeholder="商品图片" name="imgid">
								</div>
							</div>
							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<input type="submit" class="am-btn am-btn-success" value="添加商品" />
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		
		</div>
		<!-- content end -->
	</div>
							<!--添加 end-->
						</ul>
					</div>
				</div>
				<!--tab end-->

			</div>

			
			 <script src="common/js/jquery-1.7.2.min.js" type="text/javascript"></script>
              <script src="common/js/plugs/Jqueryplugs.js" type="text/javascript"></script>
              <script src="common/js/_layout.js"></script>
             <script src="common/js/plugs/jquery.SuperSlide.source.js"></script>
			<script>
				var num = 1;
				$(function() {

				 $(".tabs").slide({ trigger: "click" });

				});

	

				var btn_edit = function(gid) {
					window.location.href="findGoodsById.do?gid="+gid;
				}
				
				var btn_delete = function(gid) {
					$.jq_Confirm({
						message: "您确定要删除吗?",
						btnOkClick: function() {
							$.ajax({
								url:"delGoods.do",
								type:"POST",
								data:{gid:gid},
								sucess: function(){
									
								}
							})
						}
					});
				}
				

			</script>

		</div>
	</body>

</html>