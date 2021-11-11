<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/11/2021
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search Country</title>
</head>
<body>
<h1>Search User By Country</h1>
<p>
    <a href="/users">Back to User List</a>
</p>
<div align="center">
    <form method="post">
        <fieldset>
            <legend>
                Search Country
            </legend>
            <table>
                <tr>
                    <td>Enter city name:</td>
                    <td><input type="text" name="country" placeholder="Nhập tên thành phố"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Search"></td>
                </tr>
            </table>
        </fieldset>
        <c:if test="${userLists != null}">
            <table border="1">
                <caption><h2>List of Users</h2></caption>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Country</th>
                </tr>
                <c:forEach var="user" items='${requestScope["userLists"]}'>
                    <tr>
                        <td><c:out value="${user.id}"/></td>
                        <td><c:out value="${user.name}"/></td>
                        <td><c:out value="${user.email}"/></td>
                        <td><c:out value="${user.country}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </form>
</div>
</body>
</html>
