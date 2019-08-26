<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Conference.*"%>
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
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    
    <tr>
        <th>用户id</th>
        <th>会议id</th>
        <th>火车号</th>
        <th>发票抬头</th>
        <th>发票内容</th>
        <th>备注</th>
        <th>预定宾馆</th>
    </tr>
    </thead>
    <%
    
    	ConferenceAttr conf = (ConferenceAttr)session.getAttribute("conf");
    	AdministratorFactorImp adminFactor = new AdministratorFactorImp();
    	ArrayList<ApplyDetailAttr> applyAttr = (ArrayList<ApplyDetailAttr>) session.getAttribute("applyList");
    	if(applyAttr == null){
    	}
    	else{
    	for(int i = 0 ; i < applyAttr.size();i++){
    		String hot = applyAttr.get(i).GetHotel();
    		String YoN;
    		if(hot.toCharArray()[0]=='1'){
    			YoN = "预定";
    		}
    		else YoN = "未预定";
    %>
	     <tr>
            <td><%=applyAttr.get(i).GetUID() %></td>
            <td><%=applyAttr.get(i).GetCID() %></td>
            <td><%=applyAttr.get(i).GetTrainNum() %></td>
            <td><%=applyAttr.get(i).GetInvHead() %></td>
            <td><%=applyAttr.get(i).GetInvCon() %></td>
			<td><%=applyAttr.get(i).GetRemark() %></td>
			<td><%=YoN %></td>
        </tr>	
    <%}
    	} %>
</table>
</body>
</html>