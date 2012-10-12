<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 20/8/12
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

<meta name="layout" content="main">
  <title></title>
</head>
<body>
  Total Users :   ${count}
<br/>      <br>
Subscriptions Details :
<br/>
<g:each in="${subscriptionDetails}" var="subs">
    <br>
    <tr>
   <td>${subs}</td>
    </tr>
    <br/>
    %{--<ls:formattedDate date="${subs}"/>--}%
</g:each>
</body>
</html>