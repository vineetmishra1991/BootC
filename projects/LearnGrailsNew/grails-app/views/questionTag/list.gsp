
<%@ page import="com.intelligrape.learngrails.QuestionTag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'questionTag.label', default: 'QuestionTag')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>

<div class="block">
    <div class="block_head">
        <div class="bheadl"></div>

        <div class="bheadr"></div>

        <h2><g:message code="default.list.label" args="[entityName]"/></h2>

        <ul>
            <li><g:link class="create" action="create">Add QuestionTag</g:link></li>
        </ul>
    </div>

    <div class="block_content">
        <table cellpadding="0" cellspacing="0" width="100%">
            <thead>
            <tr>
                
                <th><g:message code="questionTag.question.label" default="Question"/></th>
                
                <th><g:message code="questionTag.tag.label" default="Tag"/></th>
                
            </tr>
            </thead>
            <tbody>
            <g:each in="${questionTagInstanceList}" status="i" var="questionTagInstance">
                <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                    
                    <td><g:link action="show" id="${questionTagInstance.id}">${fieldValue(bean: questionTagInstance, field: "question")}</g:link></td>
                    
                    <td><g:link controller="tag" action="show"
                                id="${questionTagInstance?.tag?.id}">${questionTagInstance?.tag?.encodeAsHTML()}</g:link></td>
                    
                </tr>
            </g:each>
            </tbody>
        </table>

        <div class="pagination right">
            <g:paginate total="${questionTagInstanceTotal}"/>
        </div>
    </div>

    <div class="bendl"></div>

    <div class="bendr"></div>

</div>
</body>
</html>
