
<%@ page import="com.intelligrape.learngrails.QuestionRatings" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'questionRatings.label', default: 'QuestionRatings')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>

<div class="block">
    <div class="block_head">
        <div class="bheadl"></div>

        <div class="bheadr"></div>

        <h2><g:message code="default.show.label" args="[entityName]"/></h2>
        <ul>
            <li><g:link class="create" action="create">Add QuestionRatings</g:link></li>
        </ul>
    </div>

    <div class="block_content">
        <table cellpadding="0" cellspacing="0" width="100%">
            <tbody>
            
            <tr class="prop">
                <td valign="top" class="name"><g:message code="questionRatings.answerOption.label" default="Answer Option"/></td>
                
                <td valign="top" class="value"><g:link controller="answerOption" action="show"
                                                       id="${questionRatingsInstance?.answerOption?.id}">${questionRatingsInstance?.answerOption?.encodeAsHTML()}</g:link></td>
                
            </tr>
            
            <tr class="prop">
                <td valign="top" class="name"><g:message code="questionRatings.question.label" default="Question"/></td>
                
                <td valign="top" class="value"><g:link controller="question" action="show"
                                                       id="${questionRatingsInstance?.question?.id}">${questionRatingsInstance?.question?.encodeAsHTML()}</g:link></td>
                
            </tr>
            
            <tr class="prop">
                <td valign="top" class="name"><g:message code="questionRatings.usefulness.label" default="Usefulness"/></td>
                
                <td valign="top" class="value">${questionRatingsInstance?.usefulness?.encodeAsHTML()}</td>
                
            </tr>
            
            <tr class="prop">
                <td valign="top" class="name"><g:message code="questionRatings.user.label" default="User"/></td>
                
                <td valign="top" class="value"><g:link controller="user" action="show"
                                                       id="${questionRatingsInstance?.user?.id}">${questionRatingsInstance?.user?.encodeAsHTML()}</g:link></td>
                
            </tr>
            
            </tbody>
        </table>

        <div class="buttons">
            <p>
                <g:form>
                    <g:hiddenField name="id" value="${questionRatingsInstance?.id}"/>
                    <span class="button"><g:actionSubmit class="submit small" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}"/></span>
                    <span class="button"><g:actionSubmit class="submit small" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                                                         onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/></span>
                </g:form>
            </p>
        </div>
    </div>

    <div class="bendl"></div>

    <div class="bendr"></div>

</div>
</body>
</html>
