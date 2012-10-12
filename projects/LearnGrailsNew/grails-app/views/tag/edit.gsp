

<%@ page import="com.intelligrape.learngrails.Tag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'tag.label', default: 'Tag')}"/>
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
        <g:hasErrors bean="${tagInstance}">
            <div class="error-msg custom-msg">
            <g:renderErrors bean="${tagInstance}"/>
            </div>
        </g:hasErrors>
        <g:form method="post"  >
        <g:hiddenField name="id" value="${tagInstance?.id}"/>
        <g:hiddenField name="version" value="${tagInstance?.version}"/>
        <table cellpadding="0" cellspacing="0" width="100%">
            <tbody>
            
            <tr class="prop">
                <td valign="top" class="name">
                    <label for="name"><g:message code="tag.name.label" default="Name"/></label>
                </td>
                <td valign="top" class="value ${hasErrors(bean: tagInstance, field: 'name', 'errors')}">
                    <g:textField name="name" value="${tagInstance?.name}" />
                </td>
            </tr>
            
            <tr class="prop">
                <td valign="top" class="name">
                    <label for="questionTags"><g:message code="tag.questionTags.label" default="Question Tags"/></label>
                </td>
                <td valign="top" class="value ${hasErrors(bean: tagInstance, field: 'questionTags', 'errors')}">
                    
<ul>
<g:each in="${tagInstance?.questionTags?}" var="q">
    <li><g:link controller="questionTag" action="show" id="${q.id}">${q?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="questionTag" action="create" params="['tag.id': tagInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'questionTag.label', default: 'QuestionTag')])}</g:link>

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
