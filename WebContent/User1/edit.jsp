<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Conference.ConferenceAttr"%>
<%@page import="Conference.ConferenceAttr"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Person.UserAttr"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>

 

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<form  method="post" class="definewidth m20" action="/ConferenceManager/editUser">
<input type="hidden" name="id" />
    <table class="table table-bordered table-hover definewidth m10">
    	<% 
    		UserAttr user = (UserAttr)session.getAttribute("user");
    	%>
        <tr>
            <td width="10%" class="tableleft">用户ID</td>
            <td><input type="text" name="UID" value="<%=user.GetUID()%>" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">登录名</td>
            <td><input type="text" name="username" value="<%=user.GetUserName()%>" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">密码</td>
            <td><input type="password" name="password" value="<%=user.GetPassword()%>" /></td>
        </tr>
        <tr>
            <td class="tableleft">真实姓名</td>
            <td><input type="text" name="realname" value="<%=user.GetTrueName()%>"/></td>
        </tr>
        <tr>
            <td class="tableleft">性别</td>
            <td><input type="text" name="sex" value="<%=user.GetSex()%>"/></td>
        </tr>
        <tr>
            <td class="tableleft">电话</td>
            <td><input type="text" name="Tel" value="<%=user.GetTel()%>"  onkeyup="this.value=this.value.replace(/[^\d]/ig,'')"/></td>
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td><input type="text" name="email" value="<%=user.GetEmail()%>"/></td>
        </tr>
        <tr>
            <td class="tableleft">年龄</td>
            <td><input type="text" name="age" value="<%=user.GetAge()%>"  onkeyup="this.value=this.value.replace(/[^\d]/ig,'')"/></td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" id="save" name="save">保存</button>	&nbsp;&nbsp;&nbsp;
                <button type="submit" class="btn btn-primary" name="backid" id="backid">返回列表</button>&nbsp;&nbsp;&nbsp;
                <button type="submit" class="btn btn-danger" name="del" id="del">删除</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>