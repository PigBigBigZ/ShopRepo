<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head lang="en">
<meta charset="UTF-8">
<title>登录</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="stylesheet" href="AmazeUI-2.4.2/assets/css/amazeui.css" />
<link href="css/dlstyle.css" rel="stylesheet" type="text/css">
</head>

<body>

	<div class="login-boxtitle">
		<a href="home3.html"><img alt="logo" src="images/logobig.png" /></a>
	</div>

	<div class="login-banner">
		<div class="login-main">
			<div class="login-banner-bg">
				<span></span><img src="images/big.jpg" />
			</div>
			<div class="login-box">

				<h3 class="title">管理员登录</h3>

				<div class="clear"></div>
				<form action="adminLogin.do" method="post">
					<div class="login-form">

						<div class="user-name">
							<label for="user"><i class="am-icon-user"></i></label> <input
								type="text" name="user" id="user" placeholder="用户名">
						</div>
						<div class="user-pass">
							<label for="password"><i class="am-icon-lock"></i></label> <input
								type="password" name="password" id="password" placeholder="请输入密码">
						</div>
						<div class="am-cf">
							<input type="submit" name="" value="登 录"
								class="am-btn am-btn-primary am-btn-sm">
						</div>
					</div>
				</form>
			</div>



		</div>
	</div>



	<div class="footer ">
		<div class="footer-hd ">
			<p>


				<a href="home/home3.html ">商城首页</a>
		</div>
		<div class="footer-bd ">
			<p>
				<a href="# ">关于我们</a> <a href="# ">合作伙伴</a> <a href="# ">联系我们</a> <a
					href="# ">网站地图</a> <em>© 2015-2025 PigBigBigZ 版权所有.<a
					href="https://github.com/PigBigBigZ/" target="_blank" title="项目组">项目组</a>
					- Collect from <a href="https://github.com/PigBigBigZ/"
					title="PBBZ" target="_blank">猪大大</a></em>
			</p>
		</div>
	</div>
</body>

</html>