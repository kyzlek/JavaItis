<%--
  Created by IntelliJ IDEA.
  User: Kyzlek_pc
  Date: 20.10.2016
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

    <form>
        Owner is id: <input type="text" name="ownerId">
        Owner is name: <input type="text" name="ownerName">
        <input type="submit"  formaction="handler">
    </form>


    <c:forEach items="${requestScope.allOwners}" var="currentUser">
        <tr>
            <td><c:out value="${currentUser.id}" /><td>
            <td><c:out value="${currentUser.name}" /><td>
        </tr>
    </c:forEach>
</body>
</html>
