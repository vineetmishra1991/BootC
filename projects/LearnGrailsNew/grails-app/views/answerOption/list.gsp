
<%@ page import="com.intelligrape.learngrails.AnswerOption" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'answerOption.label', default: 'AnswerOption')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>

<div class="block">
    <div class="block_head">
        <div class="bheadl"></div>

        <div class="bheadr"></div>

        <h2><g:message code="default.list.label" args="[entityName]"/></h2>

        <ul>
            <li><g:link class="create" action="create">Add AnswerOption</g:link></li>
        </ul>
    </div>

    <div class="block_content">
        <table cellpadding="0" cellspacing="0" width="100%">
            <thead>
            <tr>
                
                <g:sortableColumn property="justification" title="${message(code: 'answerOption.justification.label', default: 'Justification')}"/>
                
                <g:sortableColumn property="description" title="${message(code: 'answerOption.description.label', default: 'Description')}"/>
                
                <g:sortableColumn property="isCorrect" title="${message(code: 'answerOption.isCorrect.label', default: 'Is Correct')}"/>
                
                <th><g:message code="answerOption.question.label" default="Question"/></th>
                
            </tr>
            </thead>
            <tbody>
            <g:each in="${answerOptionInstanceList}" status="i" var="answerOptionInstance">
                <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                    
                    <td><g:link action="show" id="${answerOptionInstance.id}">${fieldValue(bean: answerOptionInstance, field: "justification")}</g:link></td>
                    
                    <td>${fieldValue(bean: answerOptionInstance, field: "description")}</td>
                    
                    <td><g:formatBoolean boolean="${answerOptionInstance.isCorrect}"/></td>
                    
                    <td><g:link controller="question" action="show"
                                id="${answerOptionInstance?.question?.id}">${answerOptionInstance?.question?.encodeAsHTML()}</g:link></td>
                    
                </tr>
            </g:each>
            </tbody>
        </table>

        <div class="pagination right">
            <g:paginate total="${answerOptionInstanceTotal}"/>
        </div>
    </div>

    <div class="bendl"></div>

    <div class="bendr"></div>

</div>
</body>
</html>
