<%@ page import="com.ig.bc.DocumentResource" %>



<div class="fieldcontain ${hasErrors(bean: documentresourceInstance, field: 'summary', 'error')} ">
	<label for="summary">
		<g:message code="documentresource.summary.label" default="Summary" />
		
	</label>
	<g:textArea name="summary" cols="40" rows="5" maxlength="1024" value="${documentresourceInstance?.summary}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: documentresourceInstance, field: 'fileName', 'error')} required">
	<label for="filename">
		<g:message code="documentresource.filename.label" default="Filename" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="filename" required="" value="${documentresourceInstance?.fileName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: documentresourceInstance, field: 'contentType', 'error')} required">
	<label for="contenttype">
		<g:message code="documentresource.contenttype.label" default="Contenttype" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="contenttype" required="" value="${documentresourceInstance?.contentType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: documentresourceInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="documentresource.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${documentresourceInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: documentresourceInstance, field: 'topic', 'error')} required">
	<label for="topic">
		<g:message code="documentresource.topic.label" default="Topic" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="topic" name="topic.id" from="${com.ig.bc.Topic.list()}" optionKey="id" required="" value="${documentresourceInstance?.topic?.id}"
              class="many-to-one"/>
</div>

