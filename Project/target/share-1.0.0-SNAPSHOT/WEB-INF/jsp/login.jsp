<%--
  Created by IntelliJ IDEA.
  User: zxx
  Date: 2019/5/23
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="zh">
<head>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户登录注册界面</title>
    <link rel="stylesheet" type="text/css" href="${path}/static/css/styles.css">
    <script src="${path}/static/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="${path}/static/css/jigsaw.css">
    <style>

        #msg {
            width: 100%;
            line-height: 40px;
            font-size: 14px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="jq22-container" style="padding-top:100px">
    <div class="login-wrap">
        <div class="login-html">
            <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">登录</label>
            <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab"></label>
            <div class="login-form">
                <form>
                    <div class="sign-in-htm">
                        <div class="group">
                            <label for="user" class="label">用户名</label>
                            <input id="username" name="username" value="admin" type="text" class="input">
                        </div>
                        <div class="group">
                            <label for="pass" class="label">密码</label>
                            <input id="password" type="password" class="input" data-type="password">
                        </div>
                        <div class="group">
                            <div class="container">
                                <div id="captcha" style="position: relative" data-type="password"></div>
                                <div id="msg"></div>
                            </div>
                        </div>
                        <div class="group">
                            <input id="check" type="checkbox" class="check" checked>
                            <label for="check"><span class="icon"></span> 保持登录</label>
                        </div>
                        <div class="group">
                            <input type="submit" class="button" value="登录" id="sendTo">
                        </div>
                        <div class="hr"></div>
                        <div class="foot-lnk">
                            <a href="#forgot">忘记密码?</a>
                        </div>
                    </div>
                </form>
                <!--<form>
                <div class="sign-up-htm">
                    <div class="group">
                        <label for="user" class="label">用户名</label>
                        <input id="users" type="text" class="input">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">密码</label>
                        <input id="passs" type="password" class="input" data-type="password">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">重复密码</label>
                        <input id="passs" type="password" class="input" data-type="password">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">邮箱地址</label>
                        <input id="pass" type="text" class="input">
                    </div>
                    <div class="group">
                        <a href="register.html"><input type="submit" class="button" value="注册"></a>
                    </div>
                    <div class="hr"></div>
                    <div class="foot-lnk">
                        <label for="tab-1">已经成员?</a>
                    </div>
                </div>
                </form>-->
            </div>
        </div>
    </div>
</div>
<script src="${path}/static/js/jigsaw.js"></script>
<script>
    var flag=false;
    $("#sendTo").click(function () {
        var name=document.getElementById('username').value;
        var pass=document.getElementById('password').value;
        var data =  {"userName" : name,"password" : pass};
        $.ajax({
            url : "http://127.0.0.1:8080/user/login",
            async : false,
            type : "POST",
            contentType : 'application/json',
            dataType : 'json',
            data :JSON.stringify(data),
            success : function(result) {
                if (result.status == 1)  {
                    flag = true;
                    alert("登陆成功！！！");
                } else {
                    alert("登陆失败！！！");
                }
            }
        });
    })
    jigsaw.init(document.getElementById('captcha'), function () {
        flag=true;
            document.getElementById('msg').innerHTML = '登录成功！'
    })
</script>
</body>
</html>
