<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Conference.ConferenceAttr"%>
<%@page import="Conference.ConferenceAttr"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
    <title>会议管理系统</title>
	<meta charset="UTF-8">
   <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="Css/style.css" />
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-register {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-register .form-signin-heading,
        .form-register .checkbox {
            margin-bottom: 10px;
            margin-left: 100px;
        }

        .form-register input[type="text"],
        .form-register input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }
    </style>  
</head>
<body>
<div class="container">
    <form class="form-register" method="post" action="register">
        <h2 class="form-register-heading">注册系统</h2>
        <input type="text" id="username" name="username" class="input-block-level" placeholder="用户名(必填)" required="required">
        <input type="text" id="truename" name="truename" class="input-block-level" placeholder="真实姓名(必填)" required="required">
        <input type="text" id="sex" name="sex" class="input-block-level" placeholder="性别">
        <input type="text" id="age" name="age" class="input-block-level" placeholder="年龄"
         onkeyup="this.value=this.value.replace(/[^\d]/ig,'')"/>
        <input type="text" id="tel" name="tele" class="input-block-level" placeholder="电话号码(必填)" required="required"
         onkeyup="this.value=this.value.replace(/[^\d]/ig,'')"/>
         <input type="text" id="Email" name="E-mail" class="input-block-level" placeholder="邮箱(必填)" required="required"	>
        <input type="password" id="password" name="password" class="input-block-level" placeholder="密码(必填)" required="required">
        <input type="password" id="password1" name="password" class="input-block-level" placeholder="确认密码(必填)" required="required" onkeyup="pw()">
        <input type="text" id="verify" name="verify" class="input-medium" placeholder="验证码(必填)" required="required"	onkeyup="verify()" >
        <img src="getcaptcha.sl" alt="验证码" name="checkImg" id="checkImg" style="position:relative; top:5px; left:20px; " 
        onClick="document.getElementById('checkImg').src='getcaptcha.sl?temp='+ (new Date().getTime().toString(36)); return false"/>  
       <p>
        <button class="btn btn-large btn-primary" name="finish" value="fi" id="finish">注册完成</button>
       </p>
		
</div>
</body>
</html>
<script>
	function pw(){
		var pw1 = document.getElementById("password").value;
		var pw2 = document.getElementById("password1").value;
		if(pw1 != pw2){
			document.getElementById("finish").disabled = true;
			
		}
		else document.getElementById("finish").disabled = false;
	}
</script>