<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/20
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${empty stuInfo}">
    <jsp:forward page="/StudentInfoServlet?info=all"/>
</c:if>
<html>
<head>
    <title>学员信息</title>
</head>
<body>
<h1 align="center">学员信息列表</h1>
<table border="1px" align="center">
    <tr style="background-color: aqua;">
        <td>编号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>地址</td>
        <td>邮箱</td>
    </tr>
    <c:forEach items="${stuInfo}" var="stu" varStatus="status">
        <tr <c:if test="${status.index%2==1}"> style="background-color: aqua;" </c:if>>
            <td><a href="${pageContext.request.contextPath}/StudentInfoServlet?info=idAll&id=${stu.sid}">${stu.sid}</a></td>
            <td>${stu.sname}</td>
            <td>${stu.sgender}</td>
            <td>${stu.sage}</td>
            <td>${stu.saddress}</td>
            <td>${stu.semail}</td>
        </tr>
    </c:forEach>
</table>
<h2 align="center" style="color: red">${tishi}</h2>
</body>
</html>
