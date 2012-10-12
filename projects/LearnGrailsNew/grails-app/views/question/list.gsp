<%@ page import="com.intelligrape.learngrails.Question" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#"><g:message code="default.list.label" args="[entityName]"/></a>
        <ul class="nav pull-right">
            <li><g:link action="create"><i class="icon-plus-sign"></i>&nbsp;<g:message code="default.new.label" args="[entityName]"/></g:link></li>
        </ul>
    </div>
</div>
<table class="table table-bordered table-striped table-hover">
    <thead>
    <tr>

        <g:sortableColumn property="description" title="${message(code: 'question.description.label', default: 'Description')}"/>

        <g:sortableColumn property="title" title="${message(code: 'question.title.label', default: 'Title')}"/>

        <th><g:message code="question.user.label" default="User"/></th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${questionInstanceList}" status="i" var="questionInstance">
        <tr>

            <td><g:link action="show" id="${questionInstance.id}">${fieldValue(bean: questionInstance, field: "description")}</g:link></td>

            <td>${fieldValue(bean: questionInstance, field: "title")}</td>

            <td>${fieldValue(bean: questionInstance, field: "user")}</td>

        </tr>
    </g:each>
    </tbody>
</table>

<div class="pagination pagination-right">
    <g:paginate total="${questionInstanceTotal}"/>
</div>
</body>
</html>
