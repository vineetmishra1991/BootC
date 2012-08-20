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


    You Are successfully logged in !!!
    <br>
    <h1>Unread Items<h1>
<table>
    <thead>
    <tr>

        <th>Title</th>
        <th>is Favourite</th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${list}" status="i" var="item">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td><a href="${item.resource.url}"target="_blank">${item.resource.url}</a></td>
            <td>${item.isfavorite?'Yes':'No'}</td>

        </tr>
    </g:each>
    </tbody>
</table>

         <br>
        <h1>Subscribed Items<h1>
        <table>
            <thead>
            <tr>

                <th>Subscribed_Topic_Name</th>


            </tr>
            </thead>
            <tbody>
            <g:each in="${subslist}" status="i" var="item">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td>${item.topic.name}</td>
                    %{--<td>${item.}</td>--}%

                </tr>
            </g:each>
            </tbody>
        </table>

    %{--Topics you own are : <br>--}%
    %{--<g:each in="${ownedlist}" var="subp">--}%
            %{--${subp}--}%
            %{--<br/>--}%
        %{--</g:each>--}%

            <br>
            <h1>Topics You Own <h1>
                <table>
                    <thead>
                    <tr>

                        <th>Topic_Owned</th>

                    </tr>
                    </thead>
                    <tbody>
                    <g:each in="${ownedlist}" status="i" var="item">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            <td>${item.name}</td>

                        </tr>
                    </g:each>
                    </tbody>
                </table>


<g:form controller="login" action="logout">

<input type="Submit" value="Logout" >
    </g:form>


</body>
</html>