

<%@ page import="com.intelligrape.learngrails.QuestionRatings" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'questionRatings.label', default: 'QuestionRatings')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>
<div class="block">
    <div class="block_head">
        <div class="bheadl"></div>

        <div class="bheadr"></div>

        <h2><g:message code="default.create.label" args="[entityName]"/></h2>
    </div>

    <div class="block_content">
         <g:hasErrors bean="${questionRatingsInstance}">
            <div class="error-msg custom-msg">
            <g:renderErrors bean="${questionRatingsInstance}"/>
            </div>
        </g:hasErrors>
        <g:form action="save"  >
                    <table cellpadding="0" cellspacing="0" width="100%">
                        <tbody>
        
            <tr class="prop">
       <td valign="top" class="name">
           <label for="answerOption"><g:message code="questionRatings.answerOption.label" default="Answer Option" /></label>
    </td>
        <td valign="top" class="value ${hasErrors(bean: questionRatingsInstance, field: 'answerOption', 'errors')}">
            <g:select name="answerOption.id" from="${com.intelligrape.learngrails.AnswerOption.list()}" optionKey="id" value="${questionRatingsInstance?.answerOption?.id}"  />
        </td>
    </tr>
        
            <tr class="prop">
       <td valign="top" class="name">
           <label for="question"><g:message code="questionRatings.question.label" default="Question" /></label>
    </td>
        <td valign="top" class="value ${hasErrors(bean: questionRatingsInstance, field: 'question', 'errors')}">
            <g:select name="question.id" from="${com.intelligrape.learngrails.Question.list()}" optionKey="id" value="${questionRatingsInstance?.question?.id}"  />
        </td>
    </tr>
        
            <tr class="prop">
       <td valign="top" class="name">
           <label for="usefulness"><g:message code="questionRatings.usefulness.label" default="Usefulness" /></label>
    </td>
        <td valign="top" class="value ${hasErrors(bean: questionRatingsInstance, field: 'usefulness', 'errors')}">
            <g:select name="usefulness" from="${com.intelligrape.learngrails.Usefulness?.values()}" keys="${com.intelligrape.learngrails.Usefulness?.values()*.name()}" value="${questionRatingsInstance?.usefulness?.name()}"  />
        </td>
    </tr>
        
            <tr class="prop">
       <td valign="top" class="name">
           <label for="user"><g:message code="questionRatings.user.label" default="User" /></label>
    </td>
        <td valign="top" class="value ${hasErrors(bean: questionRatingsInstance, field: 'user', 'errors')}">
            <g:select name="user.id" from="${com.intelligrape.learngrails.User.list()}" optionKey="id" value="${questionRatingsInstance?.user?.id}"  />
        </td>
    </tr>
        
    </tbody>
    </table>
        <div class="buttons">
            <span class="button"><g:submitButton name="create" class="submit small" value="${message(code: 'default.button.create.label', default: 'Create')}"/></span>
        </div>
        </g:form>
    </div>

    <div class="bendl"></div>

    <div class="bendr"></div>
</div>
</body>
</html>
