<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

		<script type="text/javascript">
	/*
		当用户选择新的页面时触发，回调函数包含两个参数：
		page:新的页码
		size:新的页面尺寸
	*/
	
	function queryPage(page,size){
		//param EL表达式的内置对象，表示的是请求参数的Map集合
		window.location.href=
			"findGtypeByPage.do?"+
			"page="+page+"&"+
			"size="+size;
	}
</script>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" />
		<link rel="stylesheet" href="common/css/Site.css" />
		<link rel="stylesheet" href="common/css/zy.all.css" />
		<link rel="stylesheet" href="common/css/font-awesome.min.css" />
		<link rel="stylesheet" href="common/css/amazeui.min.css" />
		<link rel="stylesheet" href="common/css/admin.css" />
		
		
		<!-- easyui 引入 -->
		<link rel="stylesheet" type="text/css"
			href="easyui/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css"
			href="easyui/themes/icon.css" />
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="easyui/locale/easyui-lang-zh_CN.js"></script> 
	<body>
	
	<%
			 if(request.getAttribute("datas")==null){
				 request.getRequestDispatcher("findGtypeByPage.do").forward(request, response);
			 }
%>


		<div class="dvcontent">

			<div>
				<!--tab start-->
				<div class="tabs">
					<div class="hd">
						<ul style="">
							<li style="box-sizing: initial;-webkit-box-sizing: initial;" class="on">查看分类</li>
							<li class="" style="box-sizing: initial;-webkit-box-sizing: initial;">添加分类</li>
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
												<th>分类编号</th>
												<th>分类名称</th>
												<th>父编号</th>
												<th>编辑</th>
												<th>删除</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${datas.content}" var="t">
											<tr>
												<td>${t.typeid }</td>
												<td>${t.typename }</td>
												<td>${t.pid }</td>
												<td class="edit"><button onclick="btn_edit(${t.typeid })"><i class="icon-edit bigger-120"></i>编辑</button></td>
												<td class="delete"><button onclick="btn_delete(${t.typeid })"><i class="icon-trash bigger-120"></i>删除</button></td>
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
							action="addGtype.do" method="post">
						
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
									分类名称</label>
								<div class="am-u-sm-9">
									<input type="text" id="typename" required
										placeholder="分类名称" name="typename">
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-intro" class="am-u-sm-3 am-form-label">
									父编号</label>
								<div class="am-u-sm-9">
									<input type="text" id="pid" required
										placeholder="父编号" name="pid">
								</div>
							</div>
							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<input type="submit" class="am-btn am-btn-success" value="添加分类" />
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		
		</div>
		<!-- content end -->
	</div>
							<!-- end-->
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


				var btn_edit = function(typeid) {
					window.location.href="findGtypeById.do?typeid="+typeid;
				}
				
				
				var btn_delete = function(typeid) {
					$.jq_Confirm({
						message: "您确定要删除吗?",
						btnOkClick: function() {
							$.ajax({
								type: "post",
								url: "delGtype.do",
								data: { typeid: typeid },
								success: function() {
										$.jq_Alert({
											message: "删除成功",
											btnOkClick: function() {
												location.reload();
											}
										});
								}
							});
						}
					});
				}
			</script>

		</div>
	</body>

</html>