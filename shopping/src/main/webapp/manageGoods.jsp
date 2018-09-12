<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	</head>

	<body>
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
												<th>图片</th>
												<th>商品销量</th>
												<th>编辑</th>
												<th>删除</th>
												
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>1</td>
												<td>商品1</td>
												<td>1000</td>
												<td>肉类</td>
												<td>100</td>
												<td></td>
												<td>10</td>
												<td class="edit"><button onclick="btn_edit(1)"><i class="icon-edit bigger-120"></i>编辑</button></td>
												<td class="delete"><button onclick="btn_delete(1)"><i class="icon-trash bigger-120"></i>删除</button></td>
											</tr>
										</tbody>
									
									</table>
								</div>
								<!--分页显示角色信息 end-->
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
					$.jq_Panel({
						url: "updateGoods?gid=" + gid,
						title: "编辑分类",
						dialogModal: true,
						iframeWidth: 500,
						iframeHeight: 400
					});
				}
				var btn_delete = function(id) {
					$.jq_Confirm({
						message: "您确定要删除吗?",
						btnOkClick: function() {
							
						}
					});
				}
			</script>

		</div>
	</body>

</html>