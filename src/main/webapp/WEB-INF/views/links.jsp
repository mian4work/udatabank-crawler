<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Crawler Links</title>
</head>
<body>
    <h2>Crawler Links</h2>
    <br/>
    <c:forEach items="${links}" var="link" varStatus="loop">
    <tr>
        <td>Link ${loop.index}: <c:out value="${link}"/></td>
    </tr>
</c:forEach>
</body>
</html>