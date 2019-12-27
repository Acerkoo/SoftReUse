<%--
  Created by IntelliJ IDEA.
  User: 74798
  Date: 2019/12/26
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <div class="login">
        <h2>登陆账号</h2>
        <form action="/login" method="GET">
            用户名:<input type="text" name="username"><br>
            密码:&emsp;<input type="password" name="password"><br>
            <input type="submit" value="登陆">
        </form>
    </div>
    <div class="add">
        <h2>添加账号</h2>
        <form action="/add" method="GET">
            用户名:<input type="text" name="username"><br>
            邮箱:&emsp;<input type="text" name="email"><br>
            密码:&emsp;<input type="password" name="password"><br>
            <input type="submit" value="注册">
        </form>
    </div>
    <div class="login">
        <h2>删除账号</h2>
        <form action="/del" method="GET">
            用户名:<input type="text" name="username"><br>
            密码:&emsp;<input type="password" name="password"><br>
            <input type="submit" value="删除">
        </form>
    </div>
    <div class="all">
        <h3><a href="/all">查看所有账号信息</a></h3>
    </div>
</body>
</html>
