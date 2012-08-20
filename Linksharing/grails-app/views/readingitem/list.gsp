
<%@ page import="com.ig.bc.Readingitem" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'readingitem.label', default: 'Readingitem')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-readingitem" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-readingitem" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="isfavorite" title="${message(code: 'readingitem.isfavorite.label', default: 'Isfavorite')}" />
					
						<g:sortableColumn property="isread" title="${message(code: 'readingitem.isread.label', default: 'Isread')}" />
					
						<th><g:message code="readingitem.resource.label" default="Resource" /></th>
					
						<th><g:message code="readingitem.user.label" default="User" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${readingitemInstanceList}" status="i" var="readingitemInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${readingitemInstance.id}">${fieldValue(bean: readingitemInstance, field: "isfavorite")}</g:link></td>
					
						<td><g:formatBoolean boolean="${readingitemInstance.isread}" /></td>
					
						<td>${fieldValue(bean: readingitemInstance, field: "resource")}</td>
					
						<td>${fieldValue(bean: readingitemInstance, field: "user")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${readingitemInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
