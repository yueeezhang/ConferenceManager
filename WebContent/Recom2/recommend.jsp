<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Conference.ConferenceAttr"%>
<%@page import="Person.UserAttr"%>
<%@page import="Factor.*"%>
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
<form action="/ConferenceManager/ConveyConf">
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
    	<th>会议ID</th>
        <th>会议名称</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>城市</th>
        <th>主办方</th>
        <th>状态</th>
        <th>已报名人数</th>
        <th>参会人员上限</th>
        <th>报名</th>
    </tr>
    </thead>
    <% 
    	UserAttr user = (UserAttr)session.getAttribute("user");
    	UserFactorImp userFactor = new UserFactorImp();
    	ArrayList<ConferenceAttr> list = userFactor.GetRecommend(user.GetUID());
    	System.out.println(list.size());
    	for(int i = 0 ; i < list.size(); i++){
    		String status;
			if(list.get(i).GetEndOrNot() == '0'){
				status = "报名中";
			}    
			else status = "已结束";
    %>
       <tr>
            <td><%=list.get(i).GetCID() %></td>
            <td><%=list.get(i).GetCName() %></td>
            <td><%=list.get(i).GetStartTime() %></td>
            <td><%=list.get(i).GetEndTime() %></td>
            <td><%=list.get(i).GetCity() %></td>
            <td><%=list.get(i).GetOrganizer() %></td>
            <td><%=status %></td>
            <td><%=list.get(i).GetMembers() %></td>
            <td><%=list.get(i).GetMemLimit() %></td>
            <td><button type="submit" class="btn btn-primary" name="view1" value="<%=list.get(i).GetCID()%>">报名</button>
        </tr>
    
    <% } %>
      </table>
   </form>  
</body>
</html>