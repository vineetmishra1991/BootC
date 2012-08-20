<%@ page import="com.ig.bc.Resource" %>



<div class="fieldcontain ${hasErrors(bean: resourceInstance, field: 'summary', 'error')} ">
	<label for="summary">
		<g:message code="resource.summary.label" default="Summary" />
		
	</label>
	<g:textArea name="summary" cols="40" rows="5" maxlength="1024" value="${resourceInstance?.summary}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: resourceInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="resource.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${resourceInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: resourceInstance, field: 'topic', 'error')} required">
	<label for="topic">
		<g:message code="resource.topic.label" default="Topic" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="topic" name="topic.id" from="${com.ig.bc.Topic.list()}" optionKey="id" required="" value="${resourceInstance?.topic?.id}" class="many-to-one"/>
</div>

