<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>
	<title>登陆</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/main.css">
	<script type="text/javascript">
	function checkSub() {
		var username =document.getElementById("username").value;
		var password=document.getElementById("password").value;
		if(username.length==0){
			alert("用户名不能为空");
			return false;
		}
		if(password.length==0){
			alert("密码不能为空");
			return false;
		}
		
	}
	
	</script>
  </head>
  
  <body>
    <div class="headerBar">
	<div class="logoBar login_logo">
		<div class="comWidth">
			<div class="logo fl">
				<a href="#"><img src="${pageContext.request.contextPath}/images/logo.jpg" alt="慕课网"></a>
			</div>
			<h3 class="welcome_title">欢迎登陆</h3>
		</div>
	</div>
</div>
<s:form action="home" method="post" namespace="/" theme="simple" onsubmit="return checkSub()">
<div class="loginBox">
	<h3 style="text-align: center;color: red;"><s:actionerror/></h3>
	<div class="login_cont">
		<ul class="login">
			<li class="l_tit">用户名</li>
			<li class="mb_10"><input type="text" name="username" class="login_input user_icon" id="username" placeholder="请输入用户名"></li>
			<li class="l_tit">密码</li>
			<li class="mb_10"><input type="password" name="password" class="login_input user_icon" id="password"  placeholder="请输入密码"></li>
			
			<li><input type="submit" value="" class="login_btn"></li>
		</ul>
		<div class="login_partners">
			<p class="l_tit">使用合作方账号登陆网站</p>
			<ul class="login_list clearfix">
				<li><a href="#">QQ</a></li>
				<li><span>|</span></li>
				<li><a href="#">网易</a></li>
				<li><span>|</span></li>
				<li><a href="#">新浪微博</a></li>
				<li><span>|</span></li>
				<li><a href="#">腾讯微薄</a></li>
				<li><span>|</span></li>
				<li><a href="#">新浪微博</a></li>
				<li><span>|</span></li>
				<li><a href="#">腾讯微薄</a></li>
			</ul>
		</div>
	</div>
	
</div>
</s:form>
<div class="hr_25"></div>
<div class="footer">
	<p><a href="#">慕课简介</a><i>|</i><a href="#">慕课公告</a><i>|</i> <a href="#">招纳贤士</a><i>|</i><a href="#">联系我们</a><i>|</i>客服热线：400-675-1234</p>
	<p>Copyright &copy; 2006 - 2014 慕课版权所有&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;京ICP证B1034-8373号&nbsp;&nbsp;&nbsp;某市公安局XX分局备案编号：123456789123</p>
	<p class="web"><a href="#"><img src="${pageContext.request.contextPath}/images/webLogo.jpg" alt="logo"></a><a href="#"><img src="${pageContext.request.contextPath}/images/webLogo.jpg" alt="logo"></a><a href="#"><img src="${pageContext.request.contextPath}/images/webLogo.jpg" alt="logo"></a><a href="#"><img src="${pageContext.request.contextPath}/images/webLogo.jpg" alt="logo"></a></p>
</div>
  </body>
</html>
