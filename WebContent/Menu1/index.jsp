<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Conference.ConferenceAttr"%>
<%@page import="Conference.ConferenceAttr"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<form class="form-inline definewidth m20"  method="get" action="/ConferenceManager/SearchConfByAdmin">
    <div class="form-group">
        <label for="name" >选择查询条件</label>
        <select class="form-control" name="req">
            <option>会议名称</option>
            <option>主办方</option>
            <option>城市</option>
            <option>状态</option>
        </select>


         <input type="text" id="menuname"class="abc input-default" placeholder="" name="str">&nbsp;
        <button type="submit" class="btn btn-info" name="search" value="search" size="8px">查询</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        &nbsp;&nbsp; &nbsp;<button type="button" class="btn btn-info" id="addnew" size="8px">新增会议</button>
    </div>
</form>
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
        <th>会议详细信息</th>
        <th>报名人员信息</th>
        <th>管理操作</th>
    </tr>
    </thead>
    <% 
   		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
	
    	ArrayList<ConferenceAttr> list = (ArrayList<ConferenceAttr>)session.getAttribute("confList");
    
    	for(int i = 0 ; i < list.size(); i++){
    		String status;
			if(time.compareTo(list.get(i).GetStartTime())<0){
				status = "报名中";
			}    
			else {
				status = "已截止";
				list.get(i).SetEndOrNot('1');
			}
    %>
       <tr>
            <td><%=list.get(i).GetCID() %></td>
            <td><%=list.get(i).GetCName() %></td>
            <td><%=list.get(i).GetStartTime() %></td>
            <td><%=list.get(i).GetEndTime() %></td>
            <td><%=list.get(i).GetCity() %></td>
            <td><%=list.get(i).GetOrganizer() %></td>
            <td><%=status %></td>
            <td><button type="submit" class="btn btn-primary" name="viewConf" value="<%=list.get(i).GetCID()%>">查看</button></td>
            <td><button type="submit" class="btn btn-primary" name="viewApply" value="<%=list.get(i).GetCID()%>">查看</button></td>
            <td><button type="submit" class="btn btn-primary" name="edit" value="<%=list.get(i).GetCID()%>">修改</button></td>
        </tr>
    
    <% } %>
</table>
</form>
</body>
</html>
<script>
    $(function () {
        

		$('#addnew').click(function(){

				window.location.href="add.jsp";
		 });
		$('#see').click(function(){

			window.location.href="see.jsp";
	 });
		$('#people').click(function(){

			window.location.href="people.jsp";
	 });
		$('#edit').click(function(){

			window.location.href="edit.jsp";
	 });


    });
	
</script>