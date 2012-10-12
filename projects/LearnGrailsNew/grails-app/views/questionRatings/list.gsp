
<%@ page import="com.intelligrape.learngrails.QuestionRatings" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'questionRatings.label', default: 'QuestionRatings')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>

<div class="block">
    <div class="block_head">
        <div class="bheadl"></div>

        <div class="bheadr"></div>

        <h2><g:message code="default.list.label" args="[entityName]"/></h2>

        <ul>
            <li><g:link class="create" action="create">Add QuestionRatings</g:link></li>
        </ul>
    </div>

    <div class="block_content">
        <table cellpadding="0" cellspacing="0" width="100%">
            <thead>
            <tr>
                
                <th><g:message code="questionRatings.answerOption.label" default="Answer Option"/></th>
                
                <th><g:message code="questionRatings.question.label" default="Question"/></th>
                
                <g:sortableColumn property="usefulness" title="${message(code: 'questionRatings.usefulness.label', default: 'Usefulness')}"/>
                
                <th><g:message code="questionRatings.user.label" default="User"/></th>
                
            </tr>
            </thead>
            <tbody>
            <g:each in="${questionRatingsInstanceList}" status="i" var="questionRatingsInstance">
                <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                    
                    <td><g:link action="show" id="${questionRatingsInstance.id}">${fieldValue(bean: questionRatingsInstance, field: "answerOption")}</g:link></td>
                    
                    <td><g:link controller="question" action="show"
                                id="${questionRatingsInstance?.question?.id}">${questionRatingsInstance?.question?.encodeAsHTML()}</g:link></td>
                    
                    <td>${fieldValue(bean: questionRatingsInstance, field: "usefulness")}</td>
                    
                    <td><g:link controller="user" action="show"
                                id="${questionRatingsInstance?.user?.id}">${questionRatingsInstance?.user?.encodeAsHTML()}</g:link></td>
                    
                </tr>
            </g:each>
            </tbody>
        </table>

        <div class="pagination right">
            <g:paginate total="${questionRatingsInstanceTotal}"/>
        </div>
    </div>

    <div class="bendl"></div>

    <div class="bendr"></div>

</div>
</body>
</html>
