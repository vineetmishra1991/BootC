<%@ page import="com.intelligrape.learngrails.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}"/>
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

        <g:sortableColumn property="username" title="${message(code: 'user.username.label', default: 'Username')}"/>

        <g:sortableColumn property="address" title="${message(code: 'user.dateCreated.label', default: 'Address')}"/>

        <g:sortableColumn property="email" title="${message(code: 'user.email.label', default: 'Email')}"/>

        <g:sortableColumn property="dateOfBirth" title="${message(code: 'user.dateOfBirth.label', default: 'Date of birth')}"/>

        <g:sortableColumn property="gender" title="${message(code: 'user.gender.label', default: 'Gender')}"/>

    </tr>
    </thead>
    <tbody>
    <g:each in="${userInstanceList}" status="i" var="userInstance">
        <tr>

            <td><g:link action="show" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "username")}</g:link></td>

            <td>${fieldValue(bean: userInstance, field: "address")}</td>

            <td>${fieldValue(bean: userInstance, field: "email")}</td>

            <td>${fieldValue(bean: userInstance, field: "dateOfBirth")}</td>

            <td>${fieldValue(bean: userInstance, field: "gender")}</td>

        </tr>
    </g:each>
    </tbody>
</table>

<div class="pagination pagination-right">
    <g:paginate total="${userInstanceTotal}"/>
</div>
</body>
</html>
