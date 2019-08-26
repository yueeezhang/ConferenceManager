<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Conference.ConferenceAttr"%>
<%@page import="Person.UserAttr"%>

<%@page import="java.util.ArrayList"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>会议管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<% 
	UserAttr user = (UserAttr)session.getAttribute("user");
%>
<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>

    <div class="dl-log">智能会议管理系统欢迎您，<span class="dl-log-user"><%=user.GetUserName() %></span><a href="login.jsp" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home" >普通用户</div></li>
        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="assets/js/bui-min.js"></script>
<script type="text/javascript" src="assets/js/common/main-min.js"></script>
<script type="text/javascript" src="assets/js/config-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var config = 
        [{id:'7',homePage : '9',menu:[{text:'用户界面',items:[{id:'9',text:'会议信息',href:'Menu2/index.jsp'}
        ,{id:'3',text:'个人信息',href:'User2/index.jsp'},{id:'4',text:'已参加会议信息',href:'Attend2/index.jsp'},
        {id:'5',text:'推荐会议',href:'Recom2/recommend.jsp'}]}]}];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
<div style="text-align:right;">
<p>来源：<a href="http://www.mycodes.net/" target="_blank">计算机14-2</a></p>
</div>
</body>
</html>