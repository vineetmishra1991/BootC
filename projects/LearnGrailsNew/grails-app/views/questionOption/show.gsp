<%@ page import="com.intelligrape.learngrails.QuestionOption" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'questionOption.label', default: 'QuestionOption')}"/>
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
        <g:if test="${questionOptionInstance?.justification || false}">
            <td><strong><g:message code="questionOption.justification.label" default="Justification"/></strong></td>

            <td><g:fieldValue bean="${questionOptionInstance}" field="justification"/></td>

        </g:if>
    </tr>

    <tr>
        <g:if test="${questionOptionInstance?.description || false}">
            <td><strong><g:message code="questionOption.description.label" default="Description"/></strong></td>

            <td><g:fieldValue bean="${questionOptionInstance}" field="description"/></td>

        </g:if>
    </tr>

    <tr>
        <g:if test="${questionOptionInstance?.isCorrect || true}">
            <td><strong><g:message code="questionOption.isCorrect.label" default="Is Correct"/></strong></td>

            <td><g:formatBoolean boolean="${questionOptionInstance?.isCorrect}"/></td>

        </g:if>
    </tr>

    <tr>
        <g:if test="${questionOptionInstance?.question || false}">
            <td><strong><g:message code="questionOption.question.label" default="Question"/></strong></td>

            <td><g:link controller="question" action="show" id="${questionOptionInstance?.question?.id}">${questionOptionInstance?.question?.
                    encodeAsHTML()}</g:link></td>

        </g:if>
    </tr>

</table>
<g:form>
    <g:hiddenField name="id" value="${questionOptionInstance?.id}"/>
    <g:link class="btn btn-info" action="create"
            id="${questionOptionInstance?.id}"><g:message code="default.button.edit.label" default="Edit"/>&nbsp;<i class="icon-edit icon-white"></i></g:link>
    <g:actionSubmit class="btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                    onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
</g:form>
</body>
</html>
