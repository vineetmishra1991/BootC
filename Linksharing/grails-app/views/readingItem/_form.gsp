<%@ page import="com.ig.bc.ReadingItem" %>



<div class="fieldcontain ${hasErrors(bean: readingItemInstance, field: 'isFavourite', 'error')} ">
	<label for="isFavourite">
		<g:message code="readingItem.isFavourite.label" default="Is Favourite" />
		
	</label>
	<g:checkBox name="isFavourite" value="${readingItemInstance?.isFavourite}" />
</div>

<div class="fieldcontain ${hasErrors(bean: readingItemInstance, field: 'isRead', 'error')} ">
	<label for="isRead">
		<g:message code="readingItem.isRead.label" default="Is Read" />
		
	</label>
	<g:checkBox name="isRead" value="${readingItemInstance?.isRead}" />
</div>

<div class="fieldcontain ${hasErrors(bean: readingItemInstance, field: 'resourceItem', 'error')} required">
	<label for="resourceItem">
		<g:message code="readingItem.resourceItem.label" default="Resource Item" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="resourceItem" name="resourceItem.id" from="${com.ig.bc.Resource.list()}" optionKey="id" required="" value="${readingItemInstance?.resourceItem?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: readingItemInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="readingItem.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${com.ig.bc.User.list()}" optionKey="id" required="" value="${readingItemInstance?.user?.id}" class="many-to-one"/>
</div>

