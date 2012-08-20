<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 20/8/12
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <meta name="layout" content="main">

  <title></title>
</head>
<body>

<g:form controller="login" action="logout">

You Are successfully logged in !!!
      <br>
 Your unread items are :  <br>
    <g:each in="${list}" var="subs">
        ${subs}
        <br/>
    </g:each>

  Your subscribed items are : <br>
    <g:each in="${subslist}" var="subp">
        ${subp}
        <br/>
    </g:each>

  The topic you own are : <br>
    <g:each in="${subslist}" var="subp">
        ${subp}
        <br/>
    </g:each>


<input type="Submit" value="Logout" >
    </g:form>


</body>
</html>