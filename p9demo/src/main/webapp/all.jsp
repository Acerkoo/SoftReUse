<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 74798
  Date: 2019/12/26
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> All Users </title>
</head>
<body>
<table>
    <tr>
        <th>用户名</th>
        <th>密码</th>
        <th>邮箱</th>
        <th> </th>
    </tr>
    <c:forEach items="${userList}" var="user" varStatus="sta">
        <tr>
            <td style="width:18%;">
                <div title='<s:property value="#case[3] == null ? #case[7] : #case[3]"/>'>
                    <c:out value='${user.username }' /> &nbsp;
                </div>
            </td>
        </tr>

        <tr>
            <td style="width:18%;">
                <div title='<s:property value="#case[3] == null ? #case[7] : #case[3]"/>'>
                    <c:out value='${user.password }' /> &nbsp;
                </div>
            </td>
        </tr>

        <tr>
            <td style="width:18%;">
                <div title='<s:property value="#case[3] == null ? #case[7] : #case[3]"/>'>
                    <c:out value='${user.email }' /> &nbsp;
                </div>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
