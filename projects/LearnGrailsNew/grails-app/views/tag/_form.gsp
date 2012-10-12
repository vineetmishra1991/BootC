<%@ page import="com.intelligrape.learngrails.Tag" %>



<div class="fieldcontain ${hasErrors(bean: tagInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="tag.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${tagInstance?.name}" />
</div>

<div class="fieldcontain ${hasErrors(bean: tagInstance, field: 'questionTags', 'error')} ">
	<label for="questionTags">
		<g:message code="tag.questionTags.label" default="Question Tags" />
		
	</label>
	
<ul>
<g:each in="${tagInstance?.questionTags?}" var="q">
    <li><g:link controller="questionTag" action="show" id="${q.id}">${q?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="questionTag" action="create" params="['tag.id': tagInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'questionTag.label', default: 'QuestionTag')])}</g:link>

</div>

