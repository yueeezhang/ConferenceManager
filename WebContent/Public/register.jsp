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
        <input type="text" name="username" class="input-block-level" placeholder="用户名(必填)">
        <input type="text" name="truename" class="input-block-level" placeholder="真实姓名(必填)">
        <input type="text" name="sex" class="input-block-level" placeholder="性别">
        <input type="text" name="age" class="input-block-level" placeholder="年龄">
        <input type="text" name="tele" class="input-block-level" placeholder="电话号码(必填)">
         <input type="text" name="E-mail" class="input-block-level" placeholder="邮箱(必填)">
        <input type="password" name="password" class="input-block-level" placeholder="密码(必填)">
        <input type="password" name="password" class="input-block-level" placeholder="确认密码(必填)">
        <input type="text" name="verify" class="input-medium" placeholder="验证码(必填)">
       <p>
        <button class="btn btn-large btn-primary" name="finish" value="fi">注册完成</button>
       </p>

</div>
</body>
</html>