<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Conference.ConferenceAttr"%>
<%@page import="Conference.ConferenceAttr"%>
<%@page import="Person.UserAttr"%>
<%@page import="java.util.ArrayList"%>
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
<form method="post" class="definewidth m20" action="/ConferenceManager/attendConf">
<table class="table table-bordered table-hover m10">
	<% 
		ConferenceAttr conf = (ConferenceAttr)session.getAttribute("conf");
		UserAttr user = (UserAttr)session.getAttribute("user");
	%>
    <tr>
        <td class="tableleft">用户ID</td>
        <td>
             <input type="text" name="UID" value="<%=user.GetUID()%>" readonly="readonly"/>
        </td>
    </tr>
    <tr>
        <td class="tableleft">会议ID</td>
        <td><input type="text" name="CID" value="<%=conf.GetCID() %>" readonly="readonly"/></td>
    </tr>
    <tr>
        <td class="tableleft">火车号</td>
        <td><input type="text" name="TrainNum" required="required"  onkeyup="this.value=this.value.replace(/[^\d]/ig,'')"/></td>
    </tr>
    <tr>
        <td class="tableleft">发票抬头</td>
        <td><input type="text" name="InvHead" /></td>
    </tr>
    <tr>
        <td class="tableleft">发票内容</td>
        <td><input type="text" name="InvCon" /></td>
    </tr>
    <tr>
        <td class="tableleft">是否预定宾馆</td>
        <td><input type="text" name="Hotel" required="required" placeholder="0为不预定，1为预定"/></td>
    </tr>
    <tr>
        <td class="tableleft">备注</td>
        <td><input type="text" name="Remark" /></td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
           <button type="submit" class="btn btn-success" name="apply" id="backid" value="apply">报名</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>