<%--
  Created by IntelliJ IDEA.
  User: 杨永磊
  Date: 2020/10/22
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>错误页面</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootstrap.css" />
    <script src="<%=request.getContextPath()%>/js/jquery-3.5.1.js"></script>
    <style>
        #td1{
            text-align: center;
            background-color: #E3E3DC;
            font-size: 20px;
            font-weight: bold;
        }
        #td2{
            text-align: center;

        }
        body{
            background-image:url("<%=request.getContextPath()%>/js/1.jpg");
            background-size:cover;
            background-attachment:fixed;
            background-repeat:no-repeat;
        }
    </style>
    <script src="<%=request.getContextPath()%>/js/jquery.2.1.1.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
</head>
<body>
<h1 align="center">云初书店-权限错误</h1>

<button class="btn  btn-success btn-sm" data-toggle="modal" onclick="returnAdmin()" >
    返回管理首页
</button>
<table id="table" class="table table-bordered table-striped">
    <tr>

        <center><h1>抱歉你的权限不够，请联系相关人员增加权限来查看</h1></center>

    </tr>

</table>

</body>
<script type="text/javascript">
    function returnAdmin() {
        window.location.href = "<%=request.getContextPath()%>/pages/admin.jsp";
    }
</script>
</html>
