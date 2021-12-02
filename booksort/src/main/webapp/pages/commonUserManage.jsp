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
    <title>读者管理（普通用户管理）</title>
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
<h1 align="center">云初书店-读者管理</h1>
<button class="btn  btn-success btn-sm" data-toggle="modal" data-target="#my" >
    添加读者
</button>
<button class="btn  btn-success btn-sm" data-toggle="modal" onclick="returnAdmin()" >
    返回管理首页
</button>
<table id="table" class="table table-bordered table-striped">
    <tr>
        <td class="td1">编号</td>
        <td class="td1">读者姓名</td>
        <td class="td1">电话</td>
        <td class="td1">地址</td>
        <td class="td1">修改</td>
        <td class="td1">删除</td>
        <td class="td1">借书记录</td>

    </tr>
    <c:forEach var="user" items="${reader}">
        <tr id="user${user.eid}" class="info">
            <td>${user.eid}</td>
            <td>${user.ename}</td>
            <td>${user.phone}</td>
            <td>${user.adders}</td>
            <td class="td2"><input type="button" class="btn btn-warning btn-sm " value="修改" onclick="clickModify('${user.eid}','${user.ename}','${user.phone}','${user.adders}');" data-toggle="modal" data-target="#modify" /></td>
            <td class="td2"><input type="button" class="btn btn-danger btn-sm " value="删除" onclick="deleteUser(${user.eid});"/></td>
            <td class="td2"><a href="${pageContext.request.contextPath }/order/find?eid=${user.eid}" style="color: red">查看</a></td>
        </tr>
    </c:forEach>
</table>

<!-- 模态框（Modal） -->
<div class="modal fade" id="my" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:80%">
        <form id="myform1" action="/reader/add" method="get">
            <div class="modal-content" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel1">
                        新增读者
                    </h4>
                </div>
                <div class="modal-body" id="dialogContent">

                    <div class="row">
                        <div class="col-sm-1">读者姓名</div>
                        <div class="col-sm-5"><input name="ename"  value="" id="ename" class="form-control"></div>
                        <div class="col-sm-1">电话</div>
                        <div class="col-sm-5"><input name="phone" value="" id="phone" class="form-control"></div>
                        <div class="col-sm-1">地址</div>
                        <div class="col-sm-5"><input name="adders" value="" id="adders"  class="form-control"></div>

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
                        用户信息修改
                    </h4>
                </div>
                <div class="modal-body" id="dialogContent1">

                    <div class="row">
                        <input id="eid1" style="display: none" type="text" value="" />
                        <div class="col-sm-1">读者姓名</div>
                        <div class="col-sm-5"><input id="ename1" class="form-control" value=""></div>
                        <div class="col-sm-1">电话</div>
                        <div class="col-sm-5"><input id="phone1"  class="form-control" value=""></div>
                        <div class="col-sm-1">地址</div>
                        <div class="col-sm-5"><input id="adders1" class="form-control" value=""></div>

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
    function deleteUser(eid){
        $.ajax({
            type:"get",
            url:"<%=request.getContextPath()%>/reader/delete",
            dataType:"json",
            data:{"eid":eid},
            success:function (data) {
                alert("删除成功~·")
                window.location="http://localhost:8080/reader/find"
            }
        })
    }
    function clickModify(eid,ename,phone,adders) {

        document.getElementById("eid1").value = eid;
        document.getElementById("adders1").value = adders;
        document.getElementById("ename1").value = ename;
        document.getElementById("phone1").value = phone;
    }

    function modifyUser() {
        var eid = document.getElementById("eid1").value;
        var ename = document.getElementById("ename1").value;
        var phone = document.getElementById("phone1").value;
        var adders = document.getElementById("adders1").value;

        $.ajax({
            type:"post",
            url:"<%=request.getContextPath()%>/reader/update",
            dataType:"json",
            data:{"eid":eid, "ename":ename,"adders":adders,"phone":phone},
            success:function (id) {
                $('#modify').modal("hide");
                window.location="http://localhost:8080/reader/find"
            }
        })
    }
</script>
</html>
