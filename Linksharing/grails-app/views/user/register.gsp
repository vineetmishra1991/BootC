<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 28/8/12
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#date').datepicker()
        });
    </script>

</head>

<body>
<%@ page import="com.ig.bc.User" %>

<g:form controller="user" action="saveUser">

    Email:<g:field type="email" name="email" value=""/><br><br>
    Address:<g:textField name="address" value=""/><br><br>
    FirstName:<g:textField name="firstname" value=""/><br><br>
    LastName:<g:textField name="lastname" value=""/><br><br>
    Sex(Male):<g:checkBox name="male" value=""/><br><br>
    Date of Birth:<g:field type="text" name="dateOfBirth" id="date"/><br><br>
    Password:<g:textField name="password" value=""/><br><br>
    ConfirmPassword<g:textField name="confirmPassword" value=""/><br><br>

    <input type="submit" value="Register">
</g:form>
</body>
</html>