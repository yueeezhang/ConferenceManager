<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Conference.ConferenceAttr"%>
<%@page import="Factor.UserFactorImp"%>
<%@page import="Person.UserAttr"%>
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
<form class="form-inline definewidth m20"  method="get" action="/ConferenceManager/SearchConfByUser">
    <div class="form-group">
        <label for="name" >选择查询条件</label>
        <select class="form-control" name="req">
            <option>会议名称</option>
            <option>主办方</option>
            <option>城市</option>
        </select>


         <input type="text" id="menuname"class="abc input-default" placeholder="" name="str">&nbsp;
        <button type="submit" class="btn btn-primary" name="search" value="search" >查询</button>
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
        <th>已报名人数</th>
        <th>参会人员上限</th>
        <th>详细信息</th>
        <th>报名</th>
    </tr>
    </thead>
    <% 
    	Date date=new Date();
    	DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String time=format.format(date);
    	UserFactorImp userFactor = new UserFactorImp();
    	UserAttr user = (UserAttr)session.getAttribute("user");
    	ArrayList<ConferenceAttr> list = (ArrayList<ConferenceAttr>)session.getAttribute("confList");
    	
    	for(int i = 0 ; i < list.size(); i++){
			int canApply = time.compareTo(list.get(i).GetStartTime());
			if(canApply>0)list.get(i).SetEndOrNot('1');
    		String status;
			if(list.get(i).GetEndOrNot() == '0'){
				status = "报名中";
			}    
			else status = "报名截止";
			int applyOrNot = 0;
			if(userFactor.ApplyOrNot(user.GetUID(), list.get(i).GetCID())){
				applyOrNot = 1;
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
            <td><%=list.get(i).GetMembers() %></td>
            <td><%=list.get(i).GetMemLimit() %></td>
            <td><button type="submit" class="btn btn-primary" name="viewer" value="<%=list.get(i).GetCID()%>">
            	查看</button>
            <td><button type="submit" class="btn btn-primary" name="view1" value="<%=list.get(i).GetCID()%>" <%if(canApply>0||applyOrNot==1){ %> disabled="true" <%} %>>
            	<%if(canApply>0){ %> 截止<%} else { if(applyOrNot==0){%>报名<%} else{%>已报名<%}} %></button>
        </tr>
    <%} %>
      </table>
</form>
</body>
</html>
<script>
    $(function () {
        

		
		$('#see').click(function(){

			window.location.href='see.jsp';
	 });
		$('#people').click(function(){

			window.location.href="people.jsp";
	 });
		$('#add_Menu').click(function(){

			alert("报名成功！");
	 });


    });
	
</script>