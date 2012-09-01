
<%@ page import="com.ig.bc.ReadingItem" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'readingItem.label', default: 'ReadingItem')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-readingItem" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-readingItem" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list readingItem">
			
				<g:if test="${readingItemInstance?.isFavourite}">
				<li class="fieldcontain">
					<span id="isFavourite-label" class="property-label"><g:message code="readingItem.isFavourite.label" default="Is Favourite" /></span>
					
						<span class="property-value" aria-labelledby="isFavourite-label"><g:formatBoolean boolean="${readingItemInstance?.isFavourite}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${readingItemInstance?.isRead}">
				<li class="fieldcontain">
					<span id="isRead-label" class="property-label"><g:message code="readingItem.isRead.label" default="Is Read" /></span>
					
						<span class="property-value" aria-labelledby="isRead-label"><g:formatBoolean boolean="${readingItemInstance?.isRead}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${readingItemInstance?.resourceItem}">
				<li class="fieldcontain">
					<span id="resourceItem-label" class="property-label"><g:message code="readingItem.resourceItem.label" default="Resource Item" /></span>
					
						<span class="property-value" aria-labelledby="resourceItem-label"><g:link controller="resource" action="show" id="${readingItemInstance?.resourceItem?.id}">${readingItemInstance?.resourceItem?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${readingItemInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="readingItem.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${readingItemInstance?.user?.id}">${readingItemInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${readingItemInstance?.id}" />
					<g:link class="edit" action="edit" id="${readingItemInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
