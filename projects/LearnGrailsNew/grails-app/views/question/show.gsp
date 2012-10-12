<%@ page import="com.intelligrape.learngrails.Question" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}"/>
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
<table class="table table-bordered">

    <tr>
        <g:if test="${questionInstance?.answers || false}">
            <td><strong><g:message code="question.answers.label" default="Answers"/></strong></td>

            <td><ul class="unstyled"><g:each in="${questionInstance.answers}" var="a">
                <li><g:link controller="answer" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
            </g:each></ul></td>

        </g:if>
    </tr>

    <tr>
        <g:if test="${questionInstance?.description || false}">
            <td><strong><g:message code="question.description.label" default="Description"/></strong></td>

            <td><g:fieldValue bean="${questionInstance}" field="description"/></td>

        </g:if>
    </tr>

    <tr>
        <g:if test="${questionInstance?.questionOptions || false}">
            <td><strong><g:message code="question.questionOptions.label" default="Question Options"/></strong></td>

            <td><ul class="unstyled"><g:each in="${questionInstance.questionOptions}" var="q">
                <li><g:link controller="questionOption" action="show" id="${q.id}">${q?.encodeAsHTML()}</g:link></li>
            </g:each></ul></td>

        </g:if>
    </tr>

    <tr>
        <g:if test="${questionInstance?.questionTags || false}">
            <td><strong><g:message code="question.questionTags.label" default="Question Tags"/></strong></td>

            <td><ul class="unstyled"><g:each in="${questionInstance.questionTags}" var="q">
                <li><g:link controller="questionTag" action="show" id="${q.id}">${q?.encodeAsHTML()}</g:link></li>
            </g:each></ul></td>

        </g:if>
    </tr>

    <tr>
        <g:if test="${questionInstance?.title || false}">
            <td><strong><g:message code="question.title.label" default="Title"/></strong></td>

            <td><g:fieldValue bean="${questionInstance}" field="title"/></td>

        </g:if>
    </tr>

    <tr>
        <g:if test="${questionInstance?.user || false}">
            <td><strong><g:message code="question.user.label" default="User"/></strong></td>

            <td><g:link controller="user" action="show" id="${questionInstance?.user?.id}">${questionInstance?.user?.
                    encodeAsHTML()}</g:link></td>

        </g:if>
    </tr>

</table>
<g:form>
    <g:hiddenField name="id" value="${questionInstance?.id}"/>
    <g:link class="btn btn-info" action="create"
            id="${questionInstance?.id}"><g:message code="default.button.edit.label" default="Edit"/>&nbsp;<i class="icon-edit icon-white"></i></g:link>
    <g:actionSubmit class="btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                    onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
</g:form>
</body>
</html>
