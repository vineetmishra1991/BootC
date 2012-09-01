<%@ page import="com.ig.bc.LinkResource" %>



<div class="fieldcontain ${hasErrors(bean: linkResourceInstance, field: 'summary', 'error')} ">
	<label for="summary">
		<g:message code="linkResource.summary.label" default="Summary" />
		
	</label>
	<g:textArea name="summary" cols="40" rows="5" maxlength="1024" value="${linkResourceInstance?.summary}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: linkResourceInstance, field: 'url', 'error')} ">
	<label for="url">
		<g:message code="linkResource.url.label" default="Url" />
		
	</label>
	<g:field type="url" name="url" value="${linkResourceInstance?.url}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: linkResourceInstance, field: 'owner', 'error')} required">
	<label for="owner">
		<g:message code="linkResource.owner.label" default="Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="owner" name="owner.id" from="${com.ig.bc.User.list()}" optionKey="id" required="" value="${linkResourceInstance?.owner?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: linkResourceInstance, field: 'readingitems', 'error')} ">
	<label for="readingitems">
		<g:message code="linkResource.readingitems.label" default="Readingitems" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${linkResourceInstance?.readingitems?}" var="r">
    <li><g:link controller="readingItem" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="readingItem" action="create" params="['linkResource.id': linkResourceInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'readingItem.label', default: 'ReadingItem')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: linkResourceInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="linkResource.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${linkResourceInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: linkResourceInstance, field: 'topic', 'error')} required">
	<label for="topic">
		<g:message code="linkResource.topic.label" default="Topic" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="topic" name="topic.id" from="${com.ig.bc.Topic.list()}" optionKey="id" required="" value="${linkResourceInstance?.topic?.id}" class="many-to-one"/>
</div>

