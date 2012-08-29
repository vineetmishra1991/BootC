<table>
    <thead>
    <tr>

        <g:sortableColumn property="isfavorite" title="${message(code: 'readingitem.isFavourite.label', default: 'Isfavorite')}" />

        <g:sortableColumn property="isread" title="${message(code: 'readingitem.isRead.label', default: 'Isread')}" />

        <th><g:message code="readingitem.resource.label" default="Resource" /></th>

        <th><g:message code="readingitem.user.label" default="User" /></th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${readingitemInstanceList}" status="i" var="readingitemInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td><g:link action="show" id="${readingitemInstance.id}">${fieldValue(bean: readingitemInstance, field: "isFavourite")}</g:link></td>

            <td><g:formatBoolean boolean="${readingitemInstance.isRead}" /></td>

            <td>${fieldValue(bean: readingitemInstance, field: "resourceItem")}</td>

            <td>${fieldValue(bean: readingitemInstance, field: "user")}</td>

        </tr>
    </g:each>
    </tbody>
</table>