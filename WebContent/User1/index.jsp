<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form class="form-inline definewidth m20" method="get" action="/ConferenceManager/SearchUserByAdmin">    
      <div class="form-group">
        <label for="name" >选择查询条件</label>
        <select class="form-control" name="req">
            <option>用户ID</option>
            <option>用户姓名</option>
            <option>用户性别</option>
            <option>用户年龄</option>
        </select>
        
    <input type="text" name="str" id="username"class="abc input-default" placeholder="" >&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary" name="search" value="search">查询</button>
    </div>
</form>
<form action="/ConferenceManager/ConveyEditUser">
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>用户id</th>
        <th>用户姓名</th>
        <th>用户性别</th>
        <th>用户年龄</th>
        <th>联系电话</th>
        <th>邮箱</th>
        <th>报名信息</th>
        <th>管理操作</th>
     	
     </tr>
    </thead>
    
    <%
    	ArrayList<UserAttr> userList = (ArrayList<UserAttr>)session.getAttribute("userList");
    	if(userList != null)
    	for(int i = 0 ; i < userList.size(); i++){
    		
    	
    %>
	     <tr>
            <td><%=userList.get(i).GetUID() %></td>
            <td><%=userList.get(i).GetUserName() %></td>
            <td><%=userList.get(i).GetSex() %></td>
            <td><%=userList.get(i).GetAge() %></td>
            <td><%=userList.get(i).GetTel() %></td>
			 <td><%=userList.get(i).GetEmail() %></td> 
			 <td>
                <button type="submit" class="btn btn-primary" id="edituser" name="viewApply" value="<%=userList.get(i).GetUID()%>">查看</button>                
            </td>
			 <td>
                <button type="submit" class="btn btn-primary" id="edituser" name="edit" value="<%=userList.get(i).GetUserName()%>">修改</button>                
            </td>
        </tr>	
			 
	<% } %>
             
        
        
        
</table>
</form>
</body>
</html>
<script>
    $(function () {
        

        $('#edituser').click(function(){

                window.location.href="edit.jsp";
         });


    });

	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "index.jsp";
			
			window.location.href=url;		
		
		}
	
	
	
	
	}
</script>