<%@ page import="com.intelligrape.learngrails.QuestionOption" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'questionOption.label', default: 'QuestionOption')}"/>
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

        <g:sortableColumn property="justification" title="${message(code: 'questionOption.justification.label', default: 'Justification')}"/>

        <g:sortableColumn property="description" title="${message(code: 'questionOption.description.label', default: 'Description')}"/>

        <g:sortableColumn property="isCorrect" title="${message(code: 'questionOption.isCorrect.label', default: 'Is Correct')}"/>

        <th><g:message code="questionOption.question.label" default="Question"/></th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${questionOptionInstanceList}" status="i" var="questionOptionInstance">
        <tr>

            <td><g:link action="show" id="${questionOptionInstance.id}">${fieldValue(bean: questionOptionInstance, field: "justification")}</g:link></td>

            <td>${fieldValue(bean: questionOptionInstance, field: "description")}</td>

            <td><g:formatBoolean boolean="${questionOptionInstance.isCorrect}"/></td>

            <td>${fieldValue(bean: questionOptionInstance, field: "question")}</td>

        </tr>
    </g:each>
    </tbody>
</table>

<div class="pagination pagination-right">
    <g:paginate total="${questionOptionInstanceTotal}"/>
</div>
</body>
</html>
