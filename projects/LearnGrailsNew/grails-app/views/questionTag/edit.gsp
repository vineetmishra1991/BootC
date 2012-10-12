

<%@ page import="com.intelligrape.learngrails.QuestionTag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'questionTag.label', default: 'QuestionTag')}"/>
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
        <g:hasErrors bean="${questionTagInstance}">
            <div class="error-msg custom-msg">
            <g:renderErrors bean="${questionTagInstance}"/>
            </div>
        </g:hasErrors>
        <g:form method="post"  >
        <g:hiddenField name="id" value="${questionTagInstance?.id}"/>
        <g:hiddenField name="version" value="${questionTagInstance?.version}"/>
        <table cellpadding="0" cellspacing="0" width="100%">
            <tbody>
            
            <tr class="prop">
                <td valign="top" class="name">
                    <label for="question"><g:message code="questionTag.question.label" default="Question"/></label>
                </td>
                <td valign="top" class="value ${hasErrors(bean: questionTagInstance, field: 'question', 'errors')}">
                    <g:select name="question.id" from="${com.intelligrape.learngrails.Question.list()}" optionKey="id" value="${questionTagInstance?.question?.id}"  />
                </td>
            </tr>
            
            <tr class="prop">
                <td valign="top" class="name">
                    <label for="tag"><g:message code="questionTag.tag.label" default="Tag"/></label>
                </td>
                <td valign="top" class="value ${hasErrors(bean: questionTagInstance, field: 'tag', 'errors')}">
                    <g:select name="tag.id" from="${com.intelligrape.learngrails.Tag.list()}" optionKey="id" value="${questionTagInstance?.tag?.id}"  />
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
