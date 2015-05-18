<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="./materialize/css/materialize.css"  media="screen,projection"/>

	<!--Let browser know website is optimized for mobile-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
  </head>
  
  <body>
	<!-- Header -->
  	<div class="nav-wrapper">
  	  <ul class="side-nav fixed">
  	  	<li><a class="waves-effect btn-flat" href="#">123</a></li>
  	  	<li><a class="waves-effect btn-flat" href="#">456</a></li>
  	  </ul>
  	</div>
  	<!-- /Header -->
  	
  	<!-- Content -->
  	<div class="container">
  	  <div class="row">
  		<form class="col s12">
  		  <div class="row">
  			<div class="input-field col s12">
  			  <i class="mdi-action-account-circle prefix"></i>
		      <input id="username" type="text" class="validate">
		      <label for="username">用户名</label>
		    </div>
		    <div class="input-field col s12">
		      <i class="mdi-action-account-circle prefix"></i>
		      <input id="password" type="password" class="validate">
		      <label for="password">密码</label>
		    </div>
  		  </div>
  		</form>
  	  </div>
  	</div>
  	<!-- /Content -->
	<script type="text/javascript" src="./js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="./js/jquery.cookie.js"></script>
	<script type="text/javascript" src="./materialize/js/materialize.min.js"></script>
	<script type="text/javascript" src="./js/zankyo.js"></script>
  </body>
</html>
