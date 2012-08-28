<%@ page import="com.ig.bc.LinkResource" %>



<div class="fieldcontain ${hasErrors(bean: linkresourceInstance, field: 'summary', 'error')} ">
	<label for="summary">
		<g:message code="linkresource.summary.label" default="Summary" />
		
	</label>
	<g:textArea name="summary" cols="40" rows="5" maxlength="1024" value="${linkresourceInstance?.summary}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: linkresourceInstance, field: 'url', 'error')} ">
	<label for="url">
		<g:message code="linkresource.url.label" default="Url" />
		
	</label>
	<g:field type="url" name="url" value="${linkresourceInstance?.url}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: linkresourceInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="linkresource.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${linkresourceInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: linkresourceInstance, field: 'topic', 'error')} required">
	<label for="topic">
		<g:message code="linkresource.topic.label" default="Topic" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="topic" name="topic.id" from="${com.ig.bc.Topic.list()}" optionKey="id" required="" value="${linkresourceInstance?.topic?.id}" class="many-to-one"/>
</div>

