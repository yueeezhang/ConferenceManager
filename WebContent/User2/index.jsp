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
<form method="post" class="definewidth m20" action="/ConferenceManager/editBySelf">
<table class="table table-bordered table-hover m10">
	<%
		UserAttr user = (UserAttr)session.getAttribute("user");
	%>
    <tr>
        <td width="10%" class="tableleft">用户ID</td>
        <td>
             <input type="text" name="UID" value="<%=user.GetUID() %>" readonly="readonly"/>
        </td>
    </tr>
    <tr>
        <td class="tableleft">用户名</td>
        <td>
             <input type="text" name="Uname" value="<%=user.GetUserName() %>" readonly="readonly"/>
        </td>
    </tr>
      <tr>
        <td class="tableleft" >真实姓名</td>
        <td>
             <input type="text" name="Rname" value="<%=user.GetTrueName() %>" required="required"/>
        </td>
    </tr>
    
    <tr>
        <td class="tableleft">用户性别</td>
        <td><input type="text" name="Usex" value="<%=user.GetSex() %>" required="required"/></td>
    </tr>
    <tr>
        <td class="tableleft">用户年龄</td>
        <td><input type="text" name="Uage" value="<%=user.GetAge()%>" required="required"  onkeyup="this.value=this.value.replace(/[^\d]/ig,'')"/></td>
    </tr>
    <tr>
        <td class="tableleft">联系电话</td>
        <td><input type="text" name="Tel" value="<%=user.GetTel()%>" required="required"  onkeyup="this.value=this.value.replace(/[^\d]/ig,'')"/></td>
    </tr>
    <tr>
        <td class="tableleft">邮箱</td>
        <td><input type="text" name="Email" value="<%=user.GetEmail() %>" required="required"/></td>
    </tr>
  
   
    
    <tr>
        <td class="tableleft"></td>
        <td>
           <button type="submit" class="btn btn-success" name="save" id="backid" value="save">保存</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
<script>
    $(function () {       
        $('#backid').click(function(){
                window.location.href="index.jsp";
         });

    });
</script>