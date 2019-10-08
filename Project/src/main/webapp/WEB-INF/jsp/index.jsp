<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF8">
    <title>Index</title>
    <script src="${path}/static/jquery-3.1.1.min.js"></script>
</head>
<body>
<p>
    Hello Spring MVC!
</p>
<p>
    服务器时间：<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/>
</p>

<form id="upload" >
    账号:<input type="text" name="adminName" id="adminName"><br/>
    密码:<input type="password" name="adminPassWord" id="adminPassWord"><br/>
    <input type="button" value=" 保  存 " id="sendTo"/>
</form>

<script type="text/javascript">
    $("#sendTo").click(function () {
        var data =  {"userName" : $("#adminName").val(),"password" : $("#adminPassWord").val()}
        $.ajax({
            url : "http://127.0.0.1:8080/user/register",
            async : false,
            type : "POST",
            contentType : 'application/json',
            dataType : 'json',
            data :JSON.stringify(data),
            success : function(result) {
                if (result.status == 1)  {
                    alert("注册成功")
                } else {
                    alert(result.msg);
                }
            }
        });
    })
</script>
</body>
</html>