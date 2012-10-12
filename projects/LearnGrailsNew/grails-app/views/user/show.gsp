<%@ page import="com.intelligrape.learngrails.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#"><g:message code="default.show.label" args="[entityName]"/></a>
        <ul class="nav pull-right">
            <li><g:link action="list"><i class="icon-list"></i>&nbsp;<g:message code="default.list.label" args="[entityName]"/></g:link></li>
            <li><g:link action="create"><i class="icon-plus-sign"></i>&nbsp;<g:message code="default.new.label" args="[entityName]"/></g:link></li>
        </ul>
    </div>
</div>
<g:if test="${flash.message}">
    <div class="alert alert-error">
        <button type="button" class="close" data-dismiss="alert">×</button>
        ${flash.message}
    </div>
</g:if>
<table class="table table-bordered">

    <tr>
        <g:if test="${userInstance?.username || false}">
            <td><strong><g:message code="user.username.label" default="Username"/></strong></td>

            <td><g:fieldValue bean="${userInstance}" field="username"/></td>

        </g:if>
    </tr>

    %{--<tr>--}%
    %{--<g:if test="${userInstance?.password||false}">--}%
    %{--<td><strong><g:message code="user.password.label" default="Password" /></strong></td>--}%
    %{----}%
    %{--<td><g:fieldValue bean="${userInstance}" field="password"/></td>--}%
    %{----}%
    %{--</g:if>--}%
    %{--</tr>--}%

    %{--<tr>--}%
    %{--<g:if test="${userInstance?.dateCreated||false}">--}%
    %{--<td><strong><g:message code="user.dateCreated.label" default="Date Created" /></strong></td>--}%
    %{----}%
    %{--<td><g:formatDate date="${userInstance?.dateCreated}" /></td>--}%
    %{----}%
    %{--</g:if>--}%
    %{--</tr>--}%
    %{----}%
    %{--<tr>--}%
    %{--<g:if test="${userInstance?.lastUpdated||false}">--}%
    %{--<td><strong><g:message code="user.lastUpdated.label" default="Last Updated" /></strong></td>--}%
    %{----}%
    %{--<td><g:formatDate date="${userInstance?.lastUpdated}" /></td>--}%
    %{----}%
    %{--</g:if>--}%
    %{--</tr>--}%

    <tr>
        <g:if test="${userInstance?.email || false}">
            <td><strong><g:message code="user.email.label" default="Email"/></strong></td>

            <td><g:fieldValue bean="${userInstance}" field="email"/></td>

        </g:if>
    </tr>

    %{--<tr>--}%
    %{--<g:if test="${userInstance?.accountExpired||true}">--}%
    %{--<td><strong><g:message code="user.accountExpired.label" default="Account Expired" /></strong></td>--}%
    %{----}%
    %{--<td><g:formatBoolean boolean="${userInstance?.accountExpired}" /></td>--}%
    %{----}%
    %{--</g:if>--}%
    %{--</tr>--}%

    %{--<tr>--}%
    %{--<g:if test="${userInstance?.accountLocked||true}">--}%
    %{--<td><strong><g:message code="user.accountLocked.label" default="Account Locked" /></strong></td>--}%
    %{----}%
    %{--<td><g:formatBoolean boolean="${userInstance?.accountLocked}" /></td>--}%
    %{----}%
    %{--</g:if>--}%
    %{--</tr>--}%

    <tr>
        <g:if test="${userInstance?.address || false}">
            <td><strong><g:message code="user.address.label" default="Address"/></strong></td>

            <td><g:fieldValue bean="${userInstance}" field="address"/></td>

        </g:if>
    </tr>

    <tr>
        <g:if test="${userInstance?.answers || false}">
            <td><strong><g:message code="user.answers.label" default="Answers"/></strong></td>

            <td><ul class="unstyled"><g:each in="${userInstance.answers}" var="a">
                <li><g:link controller="answer" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
            </g:each></ul></td>

        </g:if>
    </tr>

    <tr>
        <g:if test="${userInstance?.dateOfBirth || false}">
            <td><strong><g:message code="user.dateOfBirth.label" default="Date Of Birth"/></strong></td>

            <td><g:formatDate date="${userInstance?.dateOfBirth}"/></td>

        </g:if>
    </tr>

    %{--<tr>--}%
    %{--<g:if test="${userInstance?.enabled||true}">--}%
    %{--<td><strong><g:message code="user.enabled.label" default="Enabled" /></strong></td>--}%
    %{----}%
    %{--<td><g:formatBoolean boolean="${userInstance?.enabled}" /></td>--}%
    %{----}%
    %{--</g:if>--}%
    %{--</tr>--}%

    <tr>
        <g:if test="${userInstance?.gender || false}">
            <td><strong><g:message code="user.gender.label" default="Gender"/></strong></td>

            <td><g:fieldValue bean="${userInstance}" field="gender"/></td>

        </g:if>
    </tr>

    %{--<tr>--}%
    %{--<g:if test="${userInstance?.passwordExpired||true}">--}%
    %{--<td><strong><g:message code="user.passwordExpired.label" default="Password Expired" /></strong></td>--}%
    %{----}%
    %{--<td><g:formatBoolean boolean="${userInstance?.passwordExpired}" /></td>--}%
    %{----}%
    %{--</g:if>--}%
    %{--</tr>--}%

    <tr>
        <g:if test="${userInstance?.questions || false}">
            <td><strong><g:message code="user.questions.label" default="Questions"/></strong></td>

            <td><ul class="unstyled"><g:each in="${userInstance.questions}" var="q">
                <li><g:link controller="question" action="show" id="${q.id}">${q?.encodeAsHTML()}</g:link></li>
            </g:each></ul></td>

        </g:if>
    </tr>

</table>
<g:form>
    <g:hiddenField name="id" value="${userInstance?.id}"/>
    <g:link class="btn btn-info" action="create"
            id="${userInstance?.id}"><g:message code="default.button.edit.label" default="Edit"/>&nbsp;<i class="icon-edit icon-white"></i></g:link>
    <g:actionSubmit class="btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                    onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
</g:form>
</body>
</html>
