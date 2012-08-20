
<%@ page import="com.ig.bc.Linkresource" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'linkresource.label', default: 'Linkresource')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-linkresource" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-linkresource" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="summary" title="${message(code: 'linkresource.summary.label', default: 'Summary')}" />
					
						<g:sortableColumn property="url" title="${message(code: 'linkresource.url.label', default: 'Url')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'linkresource.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'linkresource.lastUpdated.label', default: 'Last Updated')}" />
					
						<g:sortableColumn property="title" title="${message(code: 'linkresource.title.label', default: 'Title')}" />
					
						<th><g:message code="linkresource.topic.label" default="Topic" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${linkresourceInstanceList}" status="i" var="linkresourceInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${linkresourceInstance.id}">${fieldValue(bean: linkresourceInstance, field: "summary")}</g:link></td>
					
						<td>${fieldValue(bean: linkresourceInstance, field: "url")}</td>
					
						<td><g:formatDate date="${linkresourceInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${linkresourceInstance.lastUpdated}" /></td>
					
						<td>${fieldValue(bean: linkresourceInstance, field: "title")}</td>
					
						<td>${fieldValue(bean: linkresourceInstance, field: "topic")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${linkresourceInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
