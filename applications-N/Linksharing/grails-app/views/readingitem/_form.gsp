<%@ page import="com.ig.bc.Readingitem" %>



<div class="fieldcontain ${hasErrors(bean: readingitemInstance, field: 'isfavorite', 'error')} ">
	<label for="isfavorite">
		<g:message code="readingitem.isfavorite.label" default="Isfavorite" />
		
	</label>
	<g:checkBox name="isfavorite" value="${readingitemInstance?.isfavorite}" />
</div>

<div class="fieldcontain ${hasErrors(bean: readingitemInstance, field: 'isread', 'error')} ">
	<label for="isread">
		<g:message code="readingitem.isread.label" default="Isread" />
		
	</label>
	<g:checkBox name="isread" value="${readingitemInstance?.isread}" />
</div>

<div class="fieldcontain ${hasErrors(bean: readingitemInstance, field: 'resource', 'error')} required">
	<label for="resource">
		<g:message code="readingitem.resource.label" default="Resource" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="resource" name="resource.id" from="${com.ig.bc.Resource.list()}" optionKey="id" required="" value="${readingitemInstance?.resource?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: readingitemInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="readingitem.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${com.ig.bc.User.list()}" optionKey="id" required="" value="${readingitemInstance?.user?.id}" class="many-to-one"/>
</div>

