<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Conference.*"%>
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
<form class="form-inline definewidth m20"  method="get" action="/ConferenceManager/SearchConfByUser">
    <div class="form-group">
        <label for="name" >选择查询条件</label>
        <select class="form-control" name="req">
            <option>会议名称</option>
            <option>主办方</option>
            <option>城市</option>
            <option>状态</option>
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
        <th>预订宾馆</th>
        <th>火车号</th>
        <th>发票抬头</th>
        <th>发票内容</th>
        <th>备注</th>
        <th>已参加人员数</th>
        <th>参会人员上限</th>
        <th>取消参加会议</th>
    </tr>
    </thead>
    <% 
    	UserFactorImp userFactor = new UserFactorImp();
    	UserAttr user = (UserAttr)session.getAttribute("user");
    	AdministratorFactorImp adminFactor = new AdministratorFactorImp();
    	ArrayList<ApplyDetailAttr> list = userFactor.ViewApplyHistory(user.GetUID());
    	for(int i = 0 ; i < list.size(); i++){
    		int CID = list.get(i).GetCID();
    		ConferenceAttr conf = adminFactor.SearchConf(CID);
    		System.out.println(conf);
    %>
       <tr>
            <td><%=list.get(i).GetCID() %></td>
            <td><%=conf.GetCName() %></td>
            <td><%=conf.GetStartTime() %></td>
            <td><%=list.get(i).GetHotel() %></td>
            <td><%=list.get(i).GetTrainNum() %></td>
            <td><%=list.get(i).GetInvHead() %></td>
            <td><%=list.get(i).GetInvCon() %></td>
            <td><%=list.get(i).GetRemark() %></td>
            <td><%=conf.GetMembers() %></td>
            <td><%=conf.GetMemLimit() %></td>
            <td><button type="submit" class="btn btn-primary" name="view2" value="<%=list.get(i).GetCID()%>">取消</button>
        </tr>
    
    <% } %>
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