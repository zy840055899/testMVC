<%--
  Created by IntelliJ IDEA.
  User: zhengying
  Date: 15/11/30
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table cellspacing="1" cellpadding="1" border="1">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
    </tr>
    <c:forEach items="${testers}" var="t">
    <tr>
        <%--<td><a href="detail.do?id=${t.id}" target="_blank">${t.id}</a></td>--%>
        <td><a href="localhost:7002/detail/${t.id}.html" target="_blank">${t.id}</a></td>
        <td>${t.name}</td>
        <td>${t.age}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
