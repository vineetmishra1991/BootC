
<%@ page import="com.ig.bc.Readingitem" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'readingitem.label', default: 'Readingitem')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-readingitem" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-readingitem" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list readingitem">
			
				<g:if test="${readingitemInstance?.isfavorite}">
				<li class="fieldcontain">
					<span id="isfavorite-label" class="property-label"><g:message code="readingitem.isfavorite.label" default="Isfavorite" /></span>
					
						<span class="property-value" aria-labelledby="isfavorite-label"><g:formatBoolean boolean="${readingitemInstance?.isfavorite}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${readingitemInstance?.isread}">
				<li class="fieldcontain">
					<span id="isread-label" class="property-label"><g:message code="readingitem.isread.label" default="Isread" /></span>
					
						<span class="property-value" aria-labelledby="isread-label"><g:formatBoolean boolean="${readingitemInstance?.isread}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${readingitemInstance?.resource}">
				<li class="fieldcontain">
					<span id="resource-label" class="property-label"><g:message code="readingitem.resource.label" default="Resource" /></span>
					
						<span class="property-value" aria-labelledby="resource-label"><g:link controller="resource" action="show" id="${readingitemInstance?.resource?.id}">${readingitemInstance?.resource?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${readingitemInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="readingitem.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${readingitemInstance?.user?.id}">${readingitemInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${readingitemInstance?.id}" />
					<g:link class="edit" action="edit" id="${readingitemInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
