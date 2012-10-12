

<%@ page import="com.intelligrape.learngrails.AnswerOption" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'answerOption.label', default: 'AnswerOption')}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>
<div class="block">
    <div class="block_head">
        <div class="bheadl"></div>

        <div class="bheadr"></div>

        <h2><g:message code="default.create.label" args="[entityName]"/></h2>
    </div>

    <div class="block_content">
        <g:hasErrors bean="${answerOptionInstance}">
            <div class="error-msg custom-msg">
            <g:renderErrors bean="${answerOptionInstance}"/>
            </div>
        </g:hasErrors>
        <g:form method="post"  >
        <g:hiddenField name="id" value="${answerOptionInstance?.id}"/>
        <g:hiddenField name="version" value="${answerOptionInstance?.version}"/>
        <table cellpadding="0" cellspacing="0" width="100%">
            <tbody>
            
            <tr class="prop">
                <td valign="top" class="name">
                    <label for="justification"><g:message code="answerOption.justification.label" default="Justification"/></label>
                </td>
                <td valign="top" class="value ${hasErrors(bean: answerOptionInstance, field: 'justification', 'errors')}">
                    <g:textField name="justification" value="${answerOptionInstance?.justification}" />
                </td>
            </tr>
            
            <tr class="prop">
                <td valign="top" class="name">
                    <label for="description"><g:message code="answerOption.description.label" default="Description"/></label>
                </td>
                <td valign="top" class="value ${hasErrors(bean: answerOptionInstance, field: 'description', 'errors')}">
                    <g:textField name="description" value="${answerOptionInstance?.description}" />
                </td>
            </tr>
            
            <tr class="prop">
                <td valign="top" class="name">
                    <label for="isCorrect"><g:message code="answerOption.isCorrect.label" default="Is Correct"/></label>
                </td>
                <td valign="top" class="value ${hasErrors(bean: answerOptionInstance, field: 'isCorrect', 'errors')}">
                    <g:checkBox name="isCorrect" value="${answerOptionInstance?.isCorrect}" />
                </td>
            </tr>
            
            <tr class="prop">
                <td valign="top" class="name">
                    <label for="question"><g:message code="answerOption.question.label" default="Question"/></label>
                </td>
                <td valign="top" class="value ${hasErrors(bean: answerOptionInstance, field: 'question', 'errors')}">
                    <g:select name="question.id" from="${com.intelligrape.learngrails.Question.list()}" optionKey="id" value="${answerOptionInstance?.question?.id}"  />
                </td>
            </tr>
            
            </tbody>
        </table>

        <div class="buttons">
            <span class="button"><g:actionSubmit class="submit small" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}"/></span>
            <span class="button"><g:actionSubmit class="submit small" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                                                 onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/></span>
        </div>

        <div class="bendl"></div>

        <div class="bendr"></div>
        </g:form>
    </div>
</div>
</div>
</body>
</html>
