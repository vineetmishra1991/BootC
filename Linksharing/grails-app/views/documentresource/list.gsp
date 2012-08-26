<%@ page import="com.ig.bc.Documentresource" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'documentresource.label', default: 'Documentresource')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-documentresource" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<br><br>

${flash.message}<br><br>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-documentresource" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="summary" title="${message(code: 'documentresource.summary.label', default: 'Summary')}"/>

            <g:sortableColumn property="filename" title="${message(code: 'documentresource.filename.label', default: 'Filename')}"/>

            <g:sortableColumn property="contenttype" title="${message(code: 'documentresource.contenttype.label', default: 'Contenttype')}"/>

            <g:sortableColumn property="dateCreated" title="${message(code: 'documentresource.dateCreated.label', default: 'Date Created')}"/>

            <g:sortableColumn property="lastUpdated" title="${message(code: 'documentresource.lastUpdated.label', default: 'Last Updated')}"/>

            <g:sortableColumn property="title" title="${message(code: 'documentresource.title.label', default: 'Title')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${documentresourceInstanceList}" status="i" var="documentresourceInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show" id="${documentresourceInstance.id}">${fieldValue(bean: documentresourceInstance, field: "summary")}</g:link></td>

                <td>${fieldValue(bean: documentresourceInstance, field: "filename")}</td>

                <td>${fieldValue(bean: documentresourceInstance, field: "contenttype")}</td>

                <td><g:formatDate date="${documentresourceInstance.dateCreated}"/></td>

                <td><g:formatDate date="${documentresourceInstance.lastUpdated}"/></td>

                <td>${fieldValue(bean: documentresourceInstance, field: "title")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${documentresourceInstanceTotal}"/>
    </div>
</div>
<br><br>

<div>
    <g:form controller="documentresource" action="commandObjectBinding" enctype="multipart/form-data" method="POST">
        Title: <input type="text" name="title"> <br> <br>
        Summary: <textarea maxlength="1000" name="summary">
    </textarea>   <br> <br><br>
        Select Topic to Which you Want to Add Document:
        <g:select id="topic" name="id" from="${com.ig.bc.Topic.list()}" optionKey="id" required="" optionValue="name"/>
        <br><br>
        <input type="file" name="myFile"/>   <br><br>
        <br><input type="submit" value="AddDocument"> <br><br>
    </g:form>
</div>

</body>
</html>
