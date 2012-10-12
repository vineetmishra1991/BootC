
<%@ page import="com.ig.bc.Topic" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'topic.label', default: 'Topic')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-topic" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-topic" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'topic.name.label', default: 'Name')}" />
					
						<th><g:message code="topic.owner.label" default="Owner" /></th>
					
						<g:sortableColumn property="visibility" title="${message(code: 'topic.visibility.label', default: 'Visibility')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${topicInstanceList}" status="i" var="topicInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${topicInstance.id}">${fieldValue(bean: topicInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: topicInstance, field: "owner")}</td>
					
						<td>${fieldValue(bean: topicInstance, field: "visibility")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${topicInstanceTotal}" />
			</div>
		</div>
         <br>
    <div>
        <g:form controller="topic" action="commandObjectBinding" method="POST">
        Email1: <input type="text" name="email1"> <br> <br>
        Email2: <input type="text" name="email2"> <br> <br>
        Email3: <input type="text" name="email3"> <br> <br>
        <textarea maxlength="1000">
        </textarea>   <br>
        <br><input type="submit" value="Invite">
        </g:form>
    </div>
	</body>
</html>
