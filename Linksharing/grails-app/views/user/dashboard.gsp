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

    <script type="text/javascript">
        $(document).ready(function () {
            var $tabs = $('#tabs').tabs();
        });
    </script>
    <title></title>
</head>

<body>

<b style="color: purple;font-size: 17px"><i>Welcome   ${nameUser} !!</i></b>

<g:form controller="login" action="logout">
    <input type="Submit" value="Logout">
</g:form>

<br>

<div id=tabs>
    <ul>
        <li><a href="#tab1">UnRead Items</a></li>
        <li><a href="#tab2">Subscribed Topics</a></li>
        <li><a href="#tab3">Highest Subscribed Public Topics</a></li>
        <li><a href="#tab4">Owned Topics</a></li>
        <li><a href="#tab5">Most Read items From Topics Subscribed by You</a></li>
        <li><a href="#tab6">All Reading Items List</a></li>
    </ul>
    <br>
    <g:link controller="topic" action="list" style="background-color: #00ff00;">Subscribe/UnSubscribe Topics</g:link>

    <div id='tab1'>
        <ls:unreadItems max="15"/>
    </div>

    <div id='tab2'>
        ${flash.message}
        <ls:subscribedTopics/>
    </div>

    <div id='tab3'>
        <ls:highestSubscribedPublicTopics/>
    </div>

    <div id='tab4'>
        <ls:ownedTopics/>

    </div>

    <div id='tab6'>
        <ls:getReadingItems max="20"/>

    </div>

    <div id='tab5'>
        <ls:mostReadItemsForTopicsSubscribedByUser/>
    </div>
</div>

</body>
</html>