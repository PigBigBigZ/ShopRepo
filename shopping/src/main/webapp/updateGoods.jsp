<%@page import="com.yc.bean.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


		<link rel="stylesheet" />
		<link rel="stylesheet" href="common/css/Site.css" />
		<link rel="stylesheet" href="common/css/zy.all.css" />
		<link rel="stylesheet" href="common/css/font-awesome.min.css" />
		<link rel="stylesheet" href="common/css/amazeui.min.css" />
	 	<link rel="stylesheet" href="common/css/admin.css" />


</head>
<body>

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
							action="updateGoods.do" method="post">
						<input type="hidden" name="gid" value="${goods.gid }"/>
							<div class="am-form-group">
								<label for="name" class="am-u-sm-3 am-form-label">
									商品名称</label>
								<div class="am-u-sm-9">
									<input type="text" id="gname" required
										 name="gname" value="${goods.gname }">
								</div>
							</div>
							<div class="am-form-group">
								<label for="name" class="am-u-sm-3 am-form-label">
									商品单价</label>
								<div class="am-u-sm-9">
									<input type="text" id="gprice" required
										 name="gprice" value="${goods.gprice }">
								</div>
							</div>
							
							<div class="am-form-group">
								<label for="user-email" class="am-u-sm-3 am-form-label">
								分类</label>
								<div class="am-u-sm-9">
										<input type="text" id="typeid" required
										 name="typeid" value="${goods.gtype.typeid }">
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
										 name="gcount" value="${goods.gcount }">
								</div>
							</div>

							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<input type="submit" class="am-btn am-btn-success" value="更新商品" />
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		
		</div>
		<!-- content end -->
	</div>


			 <script src="common/js/jquery-1.7.2.min.js" type="text/javascript"></script>
              <script src="common/js/plugs/Jqueryplugs.js" type="text/javascript"></script>
              <script src="common/js/_layout.js"></script>
             <script src="common/js/plugs/jquery.SuperSlide.source.js"></script>
</body>
</html>