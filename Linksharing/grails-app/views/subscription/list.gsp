
<%@ page import="com.ig.bc.Subscription" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'subscription.label', default: 'Subscription')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-subscription" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-subscription" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="subscription.topic.label" default="Topic" /></th>
					
						<g:sortableColumn property="isLike" title="${message(code: 'subscription.isLike.label', default: 'Is Like')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'subscription.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'subscription.lastUpdated.label', default: 'Last Updated')}" />
					
						<g:sortableColumn property="seriousness" title="${message(code: 'subscription.seriousness.label', default: 'Seriousness')}" />
					
						<th><g:message code="subscription.subscriber.label" default="Subscriber" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${subscriptionInstanceList}" status="i" var="subscriptionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${subscriptionInstance.id}">${fieldValue(bean: subscriptionInstance, field: "topic")}</g:link></td>
					
						<td><g:formatBoolean boolean="${subscriptionInstance.isLike}" /></td>
					
						<td><g:formatDate date="${subscriptionInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${subscriptionInstance.lastUpdated}" /></td>
					
						<td>${fieldValue(bean: subscriptionInstance, field: "seriousness")}</td>
					
						<td>${fieldValue(bean: subscriptionInstance, field: "subscriber")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${subscriptionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
