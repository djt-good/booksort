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
    <title>读者借阅记录</title>
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
<h1 align="center">云初书店-读者借阅管理</h1>

<button class="btn  btn-success btn-sm" data-toggle="modal" data-target="#my" >
    添加借阅
</button>
<button class="btn  btn-success btn-sm" data-toggle="modal" onclick="returnAdmin()" >
    返回管理首页
</button>
<table id="table" class="table table-bordered table-striped">
    <tr>
        <td class="td1">记录编号</td>
        <td class="td1">读者编号</td>
        <td class="td1">书籍编号</td>
        <td class="td1">书籍状态</td>
        <td class="td1">所借数量</td>
        <td class="td1">修改</td>
        <td class="td1">删除</td>


    </tr>
    <c:forEach var="book" items="${vo}">
        <tr id="${boook.orderid}" class="info">
            <td>${book.orderid}</td>
            <td>${book.rid}</td>
            <td>${book.bid}</td>
            <td>${book.orderstatus}</td>
            <td>${book.num}</td>
            <td class="td2"><input type="button" class="btn btn-warning btn-sm " value="修改" onclick="clickModify('${book.orderid}','${book.rid}','${book.bid}','${book.orderstatus}','${book.num}');" data-toggle="modal" data-target="#modify" /></td>
            <td class="td2"><input type="button" class="btn btn-danger btn-sm " value="删除" onclick="deleteUser(${book.orderid});"/></td>


        </tr>
    </c:forEach>
</table>

<!-- 模态框（Modal） -->
<div class="modal fade" id="my" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:80%">
        <form id="myform1" action="/order/add" method="get">
            <div class="modal-content" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel1">
                        新增借阅
                    </h4>
                </div>
                <div class="modal-body" id="dialogContent">

                    <div class="row">
                        <div class="col-sm-1">读者编号</div>
                        <div class="col-sm-5"><input name="rid"  value="" id="rid" class="form-control"></div>
                        <div class="col-sm-1">书籍编号</div>
                        <div class="col-sm-5"><input name="bid" value="" id="bid" class="form-control"></div>
                        <div class="col-sm-1">书籍状态</div>
                        <div class="col-sm-5"><input name="orderstatus" value="" id="orderstatus"  class="form-control"></div>
                        <div class="col-sm-1">书籍数量</div>
                        <div class="col-sm-5"><input name="num" value="" id="num"  class="form-control"></div>
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
                       读者借阅修改
                    </h4>
                </div>
                <div class="modal-body" id="dialogContent1">

                    <div class="row">
                        <input id="orderid1" style="display: none" type="text" value="" />
                        <div class="col-sm-1">读者编号</div>
                        <div class="col-sm-5"><input id="rid1" class="form-control" value=""></div>
                        <div class="col-sm-1">书籍编号</div>
                        <div class="col-sm-5"><input id="bid1"  class="form-control" value=""></div>
                        <div class="col-sm-1">书籍状态</div>
                        <div class="col-sm-5"><input id="orderstatus1" class="form-control" value=""></div>
                        <div class="col-sm-1">所借数量</div>
                        <div class="col-sm-5"><input id="num1" class="form-control" value=""></div>
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
        window.location.href = "<%=request.getContextPath()%>/reader/find";
    }
    function deleteUser(eid){
        $.ajax({
            type:"get",
            url:"<%=request.getContextPath()%>/order/delete",
            dataType:"json",
            data:{"orderid":eid},
            success:function (data) {
                alert("删除成功~·")
                window.location="http://localhost:8080/order/find"
            }
        })
    }
    function clickModify(orderid,rid,bid,orderstatus,num) {

        document.getElementById("orderid1").value = orderid;
        document.getElementById("rid1").value = rid;
        document.getElementById("bid1").value = bid;
        document.getElementById("orderstatus1").value = orderstatus;
        document.getElementById("num1").value = num;
    }

    function modifyUser() {
        var orderid = document.getElementById("orderid1").value;
       var rid = document.getElementById("rid1").value;
        var bid =  document.getElementById("bid1").value;
        var orderstatus =  document.getElementById("orderstatus1").value;
        var num =   document.getElementById("num1").value;

        $.ajax({
            type:"post",
            url:"<%=request.getContextPath()%>/order/update",
            dataType:"json",
            data:{"orderid":orderid, "rid":rid,"bid":bid,"orderstatus":orderstatus,"num":num},
            success:function (id) {
                $('#modify').modal("hide");
                alert("修改成功！")
                window.location="http://localhost:8080/order/find"
            }
        })
    }
</script>
</html>
