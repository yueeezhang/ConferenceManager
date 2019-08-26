<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<form  method="post" class="definewidth m20" action="/ConferenceManager/addConf" >
<table class="table table-bordered table-hover m10">
    <tr>
        <td width="10%" class="tableleft">会议名称</td>
        <td><input type="text" id="Cname" name="Cname" required="required"/></td>
    </tr>
    <tr>
        <td class="tableleft">会议起始时间</td>
        <td><input type="text" id="Starttime" name="Starttime" required="required" onclick="lhgcalendar({ format: 'yyyy-MM-dd HH:mm:ss' });"/></td>
    </tr>
    <tr>
        <td class="tableleft">会议结束时间</td>
        <td><input type="text" id="Endtime" name="Endtime" required="required" onclick="lhgcalendar({ format: 'yyyy-MM-dd HH:mm:ss' });"/></td>
    </tr>
    <tr>
        <td class="tableleft">参加人员的上限</td>
        <td><input type="text" id="Memlimit" name="Memlimit" required="required" onkeyup="this.value=this.value.replace(/[^\d]/ig,'')"/></td>
    </tr>
    <tr>
        <td class="tableleft">城市</td>
        <td><input type="text" id="Endtime" name="city" required="required"/></td>
    </tr>
    <tr>
        <td class="tableleft">主办方</td>
        <td><input type="text" id="Organizer" name="Organizer" required="required"/></td>
    </tr>
    <tr>
        <td class="tableleft">联系电话</td>
        <td><input type="text" id="Tel" name="tel" required="required"/></td>
    </tr>
    <tr>
        <td class="tableleft">联系邮箱</td>
        <td><input type="text" id="Emails" name="Emails" required="required"/></td>
    </tr>
    <tr>
        <td class="tableleft">会议的详细介绍</td>
        <td><input type="text" id="Information" name="information" required="required"/></td>
    </tr>
    <tr>
        <td class="tableleft">会议地点的详细地址</td>
        <td>
           <input type="text" id="Adress" name="address" required="required"/>
        </td>
    </tr>
    <tr>
        <td class="tableleft">会议类别</td>
        <td><input type="text" id="Category" name="category" required="required"/></td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button" id="save" name="save" value="save">保存</button> &nbsp;&nbsp;
        </td>
    </tr>
</table>
</form>
</body>
</html>

<script>
	
    $(function () {       
        $('#save').click(function(){
    	window.location.href="index.jsp";
       
        
    });

    $(function () {       
		$('#backid').click(function(){
        window.location.href="index.jsp";  
		
	});

</script>