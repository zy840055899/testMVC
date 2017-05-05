<%--
  Created by IntelliJ IDEA.
  User: zhengying
  Date: 2017/5/2
  Time: 上午11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        #modal-container-954533 tr td input{
            width: 100%;
        }
    </style>
    <script src="../js/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="../js/staff.js"></script>
</head>
<body>
<a id="modal-95453" href="#modal-container-95453" role="button" class="btn" data-toggle="modal" style="display: none">触发遮罩窗体</a>

<div class="modal fade" id="modal-container-95453" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">
                    提示
                </h4>
            </div>
            <div class="modal-body">
                内容...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <%--<button type="button" class="btn btn-primary">保存</button>--%>
            </div>
        </div>
    </div>
</div>


<a id="modal-954533" href="#modal-container-954533" role="button" class="btn" data-toggle="modal" style="display: none">触发遮罩窗体2</a>

<div class="modal fade" id="modal-container-954533" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel2">
                    提示
                </h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>name</th>
                        <th>age</th>
                        <th>phone</th>
                        <th>salary</th>
                        <th>addr</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <form id="updateForm">
                        <td><input type="text" name="id" readonly/></td>
                        <td><input type="text" name="name"/></td>
                        <td><input type="text" name="age"/></td>
                        <td><input type="text" name="phone"/></td>
                        <td><input type="text" name="salary"/></td>
                        <td><input type="text" name="addr"/></td>
                            <input type="hidden" name="startPage" class="startPage" value="${page.startPage}">
                        </form>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>


<div style="vertical-align: middle">
    <div>
        <table class="table table-bordered">
            <caption>员工信息</caption>
            <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>age</th>
                <th>phone</th>
                <th>salary</th>
                <th>addr</th>
                <th id="addStaff">add</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${staffs}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.age}</td>
                    <td>${s.phone}</td>
                    <td>${s.salary}</td>
                    <td>${s.addr}</td>
                    <td>
                        <a href="deleteStaff.do?id=${s.id}&startPage=${page.startPage}">del</a>
                        <a href="javascript:void(0)" class="updateStaff">update</a>
                    </td>
                </tr>
            </c:forEach>
            <form id="newStaffForm">
            <tr style="display: none">
                <td>AUTO</td>
                <td><input type="text" name="name"/></td>
                <td><input type="text" name="age"/></td>
                <td><input type="text" name="phone"/></td>
                <td><input type="text" name="salary"/></td>
                <td><input type="text" name="addr"/></td>
                <td><a href="javascript:void(0)" id="addStaffBtn">ok</a></td>
            </tr>
            </form>
            </tbody>
        </table>
    </div>

    <div style="text-align: center">
        <%--startPage:${page.startPage},totalpage:${page.totalPage}--%>

        <ul class="pagination">

            <c:choose>
                <c:when test="${page.startPage <= 1}">
                    <li class="disabled"><a href="javascript:void(0)">&laquo;</a></li>
                </c:when>
                <c:otherwise>
                    <li class=""><a href="staffsInfo.do?startPage=${page.startPage-1}">&laquo;</a></li>
                </c:otherwise>
            </c:choose>
            <%--<li <c:if test="${page.startPage <= 1}">class="disabled"</c:if>><a href="staffsInfo.do?startPage=${s.index-1}">&laquo;</a></li>--%>

            <c:forEach begin="1" end="${page.totalPage}" varStatus="s">
                <li <c:if test="${s.index == page.startPage}">class="active"</c:if>><a href="staffsInfo.do?startPage=${s.index}">${s.index}</a></li>
            </c:forEach>


            <c:choose>
                <c:when test="${page.startPage >= page.totalPage}">
                    <li class="disabled"><a href="javascript:void(0);">&raquo;</a></li>
                </c:when>
                <c:otherwise>
                    <li class=""><a href="staffsInfo.do?startPage=${page.startPage+1}">&raquo;</a></li>
                </c:otherwise>
            </c:choose>

            <%--<li <c:if test="${page.startPage >= page.totalPage}">class="disabled"</c:if>><a href="staffsInfo.do?startPage=${s.index+1}">&raquo;</a></li>--%>

        </ul>
    </div>
</div>
</body>
</html>
