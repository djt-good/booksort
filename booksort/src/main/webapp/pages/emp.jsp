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
    <title>书店员工信息</title>
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
<h1 align="center">云初书店-员工管理</h1>
<button class="btn  btn-success btn-sm" data-toggle="modal" data-target="#my" >
    添加员工
</button>
<button class="btn  btn-success btn-sm" data-toggle="modal" onclick="returnAdmin()" >
    返回管理首页
</button>
<table id="table" class="table table-bordered table-striped">
    <tr>
        <td class="td1">编号</td>
        <td class="td1">姓名</td>
        <td class="td1">密码</td>
        <td class="td1">权限</td>
        <td class="td1">修改</td>
        <td class="td1">删除</td>


    </tr>
    <c:forEach var="user" items="${emp}">
        <tr id="${user.id}" class="info">
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.grade}</td>

            <td class="td2"><input type="button" class="btn btn-warning btn-sm " value="修改" onclick="clickModify('${user.id}','${user.username}','${user.password}','${user.grade}');" data-toggle="modal" data-target="#modify" /></td>
            <td class="td2"><input type="button" class="btn btn-danger btn-sm " value="删除" onclick="deleteUser(${user.id});"/></td>

        </tr>
    </c:forEach>
</table>

<!-- 模态框（Modal） -->
<div class="modal fade" id="my" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:80%">
        <form id="myform1" action="/emp/add" method="get">
            <div class="modal-content" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel1">
                        新增员工
                    </h4>
                </div>
                <div class="modal-body" id="dialogContent">

                    <div class="row">
                        <div class="col-sm-1">姓名</div>
                        <div class="col-sm-5"><input name="username"  value="" class="form-control"></div>
                        <div class="col-sm-1">密码</div>
                        <div class="col-sm-5"><input name="password" value=""  class="form-control"></div>
                        <div class="col-sm-1">权限</div>
                        <div class="col-sm-5"><input name="grade" value=""  class="form-control"></div>

                        <div>
                            <input type="submit" value="提交">
                        </div>


                    </div>

                </div>
                <%--                <div class="modal-footer">--%>
                <%--                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭--%>
                <%--                    </button>--%>
                <%--                    <button type="button" id="bookSubmit" class="btn btn-primary" onclick="addBook()">--%>
                <%--                        添加--%>
                <%--                    </button>--%>
                <%--                </div>--%>
            </div><!-- /.modal-content -->
        </form>
    </div><!-- /.modal -->
</div>


<!-- 模态框（Modal） -->
<div class="modal fade" id="modify" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:80%">
        <form id="myform" >
            <div class="modal-content" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                       员工信息修改
                    </h4>
                </div>
                <div class="modal-body" id="dialogContent1">

                    <div class="row">
                        <input id="id1" style="display: none" type="text" value="" />
                        <div class="col-sm-1">姓名</div>
                        <div class="col-sm-5"><input id="username1" class="form-control" value=""></div>
                        <div class="col-sm-1">密码</div>
                        <div class="col-sm-5"><input id="password1"  class="form-control" value=""></div>
                        <div class="col-sm-1">权限</div>
                        <div class="col-sm-5"><input id="grade1" class="form-control" value=""></div>

                    </div>

                </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" id="bookSubmit" class="btn btn-primary" onclick="modifyUser()">
                        修改
                    </button>
                </div>

        </form>
    </div><!-- /.modal -->
</div>
</body>
<script type="text/javascript">
    function returnAdmin() {
        window.location.href = "<%=request.getContextPath()%>/pages/admin.jsp";
    }
    function deleteUser(id){
        $.ajax({
            type:"get",
            url:"<%=request.getContextPath()%>/emp/delete",
            dataType:"json",
            data:{"id":id},
            success:function (data) {
                alert("删除成功~·")
                window.location="http://localhost:8080/emp/find"
            }
        })
    }
    function clickModify(id,username,password,grade) {

        document.getElementById("id1").value = id;
        document.getElementById("username1").value = username;
        document.getElementById("password1").value = password;
        document.getElementById("grade1").value = grade;
    }

    function modifyUser() {
        var id = document.getElementById("id1").value;
        var username = document.getElementById("username1").value;
        var password = document.getElementById("password1").value;
        var grade = document.getElementById("grade1").value;

        $.ajax({
            type:"post",
            url:"<%=request.getContextPath()%>/emp/update",
            dataType:"json",
            data:{"id":id, "username":username,"password":password,"grade":grade},
            success:function (id) {
                $('#modify').modal("hide");
                window.location="http://localhost:8080/emp/find"
            }
        })
    }
</script>
</html>
