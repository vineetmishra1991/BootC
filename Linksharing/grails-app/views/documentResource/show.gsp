
<%@ page import="com.ig.bc.DocumentResource" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'documentresource.label', default: 'Documentresource')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-documentresource" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-documentresource" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list documentresource">
			
				<g:if test="${documentresourceInstance?.summary}">
				<li class="fieldcontain">
					<span id="summary-label" class="property-label"><g:message code="documentresource.summary.label" default="Summary" /></span>
					
						<span class="property-value" aria-labelledby="summary-label"><g:fieldValue bean="${documentresourceInstance}" field="summary"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${documentresourceInstance?.fileName}">
				<li class="fieldcontain">
					<span id="filename-label" class="property-label"><g:message code="documentresource.filename.label" default="Filename" /></span>
					
						<span class="property-value" aria-labelledby="filename-label"><g:fieldValue bean="${documentresourceInstance}" field="fileName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${documentresourceInstance?.contentType}">
				<li class="fieldcontain">
					<span id="contenttype-label" class="property-label"><g:message code="documentresource.contenttype.label" default="Contenttype" /></span>
					
						<span class="property-value" aria-labelledby="contenttype-label"><g:fieldValue bean="${documentresourceInstance}" field="contentType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${documentresourceInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="documentresource.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${documentresourceInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${documentresourceInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="documentresource.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${documentresourceInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${documentresourceInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="documentresource.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${documentresourceInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${documentresourceInstance?.topic}">
				<li class="fieldcontain">
					<span id="topic-label" class="property-label"><g:message code="documentresource.topic.label" default="Topic" /></span>
					
						<span class="property-value" aria-labelledby="topic-label"><g:link controller="topic" action="show" id="${documentresourceInstance?.topic?.id}">${documentresourceInstance?.topic?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${documentresourceInstance?.id}" />
					<g:link class="edit" action="edit" id="${documentresourceInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
