<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2019/3/20
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script>
    $(function(){
        $("#gai").click(function(){
            var val1 = $("input[name='user']").val();
            var val2 = $("input[name='age']").val();
            var val3 = $("input[name='sex']").val();
            if((val1==null||val1=="")||(val2==null||val2=="")||(val3==null||val3=="")){
                alert("请填写完整的学生信息再修改")
                return false;
            }
        })
        $("table td:even").css({"background-color":"aqua"})
        $("table h1").css({"background-color":"aqua"})
    })
</script>
<body >
<div border="1px">
<form action="${pageContext.request.contextPath}/StudentInfoServlet?info=update&id=${stuInfoById[0].sid}" method="post">
    <table align="center">
        <h1 align="center">学员信息</h1>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="user" value="${stuInfoById[0].sname}"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age" value="${stuInfoById[0].sage}"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="text" name="sex" value="${stuInfoById[0].sgender}"></td>
        </tr>
        <tr>
            <td>地址</td>
            <td><input type="text" name="address" value="${stuInfoById[0].saddress}"></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="text" name="email" value="${stuInfoById[0].semail}"></td>
        </tr>
    </table>
    <p align="center">
        <input type="submit" value="修改" name="xiugai"  id="gai">
        <input type="reset" value="重置" name="chongzhi" id="chong">
    </p>
</form>

</div>
</body>
</html>
