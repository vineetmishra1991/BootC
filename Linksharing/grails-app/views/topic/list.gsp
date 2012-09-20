<%@ page import="com.ig.bc.Topic" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'topic.label', default: 'Topic')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
    <script type="text/javascript">
        $(document).ready(function () {

            $('#selectAllSubscribe').click(function () {
                var checked = $(this).attr('checked') ? true : false;
                $('.selectSubscribe').attr('checked', checked);

            });

            $('#selectAllUnSubscribe').click(function () {
                var checked = $(this).attr('checked') ? true : false;
                $('.selectUnSubscribe').attr('checked', checked);

            });

            $('#inverse').click(function () {

                $('.selectSubscribe').each(function () {
                    if ($(this).is(':checked')) {
                        $(this).attr('checked', false)
                    }
                    else {
                        $(this).attr('checked', true)
                    }

                })

            });
        });

        function subscribeToTopic() {

            var list = '';

            $(".selectSubscribe:checked").each(function () {

                if (list != '') {
                    list = list + ",";
                }
                list = list + $(this).val()
            });

            var url = "${createLink(controller: 'topic', action: 'addSubscriptionToUser')}";
            $.ajax({
                type:"GET",
                url:url,
                dataType:"html",
                data:{ item:list}
            }).done(function (data) {
                        if (data == "true")
                            $("#topicNew").html("");
                        $("#topicNew").html("<br><a href='${createLink(controller: 'user',action: 'dashboard')}'>Topics subscribed,Now go to Dashboard</a>");
                    });

        }

        function unSubscribeToTopic() {

            var list = '';

            $(".selectSubscribe:checked").each(function () {

                if (list != '') {
                    list = list + ",";
                }
                list = list + $(this).val()
            });

            var url = "${createLink(controller: 'topic', action: 'removeSubscriptionFromUser')}";
            $.ajax({
                type:"GET",
                url:url,
                dataType:"html",
                data:{ item:list}
            }).done(function (data) {
                        if (data == "true")
                            $("#topicNew").html("");
                        $("#topicNew").html("<br><a href='${createLink(controller: 'user',action: 'dashboard')}'>Topics UnSubscribed,Now go to Dashboard</a>");
                    });

        }

    </script>
</head>

<body>
<a href="#list-topic" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-topic" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>
            <th>Subscribe/UnSubscribe:    <g:checkBox value="1" id="selectAllSubscribe" name="topicIdsSubscribe" checked="false"/>
            Subscribe/UnSubscribe(InverseCheck):    <input type="button" id="inverse" name="inverse" value="Inverse"/></th>
        </tr>
        <tr>

            <g:sortableColumn property="name" title="${message(code: 'topic.name.label', default: 'Name')}"/>

            <th><g:message code="topic.owner.label" default="Owner"/></th>

            <g:sortableColumn property="visibility" title="${message(code: 'topic.visibility.label', default: 'Visibility')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${topicInstanceList}" status="i" var="topicInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>
                    <g:checkBox class="selectSubscribe" value="${topicInstance.id}" id="topicIdsSubscribe_${i}" name="topicIdsSubscribe" checked="false"/>
                    <g:link action="show" id="${topicInstance.id}">${fieldValue(bean: topicInstance, field: "name")}</g:link>
                </td>
                <td>${fieldValue(bean: topicInstance, field: "owner")}</td>

                <td>${fieldValue(bean: topicInstance, field: "visibility")}</td>

            </tr>
        </g:each>

        </tbody>
        <input type="button" value="Subscribe to Topic" onclick="subscribeToTopic()"/>
        <input type="button" value="UnSubscribe to Topic" onclick="unSubscribeToTopic()"/>
        <g:link controller="user" action="dashboard" style="background-color: orange;">Go to Dashboard</g:link>
        <div id="topicNew">
        </div>
    </table>

    <div class="pagination">
        <g:paginate total="${topicInstanceTotal}"/>
    </div>
</div>
<br>

<div>
    <g:form controller="topic" action="sendInvite" method="POST">
        Email1: <input type="text" name="email1"> <br> <br>
        Email2: <input type="text" name="email2"> <br> <br>
        Email3: <input type="text" name="email3"> <br> <br>
        <textarea maxlength="1000">
        </textarea><br> <br>
        <b>Invite From These !!</b> <br> <br>
        <g:select id="topic" name="topicIdList" multiple="true" from="${com.ig.bc.Topic.list()}" optionKey="id" required="" optionValue="name"/>
        <br><g:submitButton value="Invite" name="Invite"/>
    </g:form>
</div>
</body>
</html>