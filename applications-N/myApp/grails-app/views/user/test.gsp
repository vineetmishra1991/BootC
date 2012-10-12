<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 11/10/12
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
${flash.message}
<g:link action="test2">click</g:link>
<g:form controller="user" action="test4">
    Password:<input type="text" name="password">
    Confirm Password:<input type="text" name="cpassword">
    <input type="submit" name="Submit">
</g:form>
</body>
</html>