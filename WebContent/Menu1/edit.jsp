﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Conference.ConferenceAttr"%>
<%@page import="Conference.ConferenceAttr"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <link href="../Css/lhgcalendar.css" rel="Stylesheet" type="text/css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>
	<script type="text/javascript" src="../Js/lhgcalendar.js"></script>
	<script type="text/javascript" src="../Js/lhgcore.min.js"></script>
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
<form  method="post" class="definewidth m20" action="/ConferenceManager/editConf">
<table class="table table-bordered table-hover m10">
	<%
		ConferenceAttr conf = (ConferenceAttr)session.getAttribute("conf");
	
	%>
    <tr>
        <td width="10%" class="tableleft">会议ID</td>
        <td>
             <input type="text" name="CID" value="<%=conf.GetCID()%>" readonly="readonly"/>
        </td>
    </tr>
    <tr>
        <td class="tableleft">会议名称</td>
        <td>
             <input type="text" name="Cname" value="<%=conf.GetCName() %>" required="required"/>
        </td>
    </tr>
    <tr>
        <td class="tableleft">会议起始时间</td>
        <td><input type="text" name="Starttime" value="<%=conf.GetStartTime()%>" required="required" onclick="lhgcalendar({ format: 'yyyy-MM-dd HH:mm:ss' });"/></td>
    </tr>
    <tr>
        <td class="tableleft">会议结束时间</td>
        <td><input type="text" name="Endtime" value="<%=conf.GetEndTime()%>" required="required" onclick="lhgcalendar({ format: 'yyyy-MM-dd HH:mm:ss' });"/></td>
    </tr>
    <tr>
        <td class="tableleft">参加人员的上限</td>
        <td><input type="text" name="Memlimit" value="<%=conf.GetMemLimit()%>" required="required" onkeyup="this.value=this.value.replace(/[^\d]/ig,'')"/></td>
    </tr>
    <tr>
        <td class="tableleft">城市</td>
        <td><input type="text" name="city" value="<%=conf.GetCity()%>" required="required"/></td>
    </tr>
    <tr>
        <td class="tableleft">主办方</td>
        <td><input type="text" name="Organizer" value="<%=conf.GetOrganizer()%>" required="required"/></td>
    </tr>
    <tr>
        <td class="tableleft">联系电话</td>
        <td><input type="text" name="tel" value="<%=conf.GetTel()%>" required="required"/></td>
    </tr>
    <tr>
        <td class="tableleft">联系邮箱</td>
        <td><input type="text" name="Emails" value="<%=conf.GetEmail()%>" required="required"/></td>
    </tr>
    <tr>
        <td class="tableleft">会议的流程介绍</td>
        <td><input type="text" name="information" value="<%=conf.GetIntro()%>" required="required"/></td>
    </tr>
    <tr>
        <td class="tableleft">会议地点的详细地址</td>
        <td>
           <input type="text" name="address" value="<%=conf.GetAddr()%>" required="required"/>
        </td>
    </tr>
    <tr>
        <td class="tableleft">会议分类</td>
        <td>
           <input type="text" name="category" value="<%=conf.GetCategory()%>" required="required"/>
        </td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" name="save" value="save" id="save">保存</button> &nbsp;&nbsp;
            <button type="submit" class="btn btn-success" name="backid" value="backid" id="backid">返回列表</button>&nbsp;&nbsp;
            <button type="submit" class="btn btn-danger" name="del" value="del" id="del">删除</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>