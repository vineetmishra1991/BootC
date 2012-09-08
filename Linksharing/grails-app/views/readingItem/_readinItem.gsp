<table>
    <thead>
    <tr>

        <g:sortableColumn property="isFavourite" title="${message(code: 'readingItem.isFavourite.label', default: 'Is Favourite')}"/>

        <g:sortableColumn property="isRead" title="${message(code: 'readingItem.isRead.label', default: 'Is Read')}"/>

        <th><g:message code="readingItem.resourceItem.label" default="Resource Item"/></th>

    </tr>
    </thead>

    <tbody>
    <g:each in="${readingItem}" status="i" var="item">
        <tr id="row_${i}" class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td><g:link controller="readingItem" action="show" id="${item.id}">${fieldValue(bean: item, field: "isFavourite")}</g:link></td>
            <td><g:formatBoolean boolean="${item.isRead}"/></td>
            <td><b><a href="${item.resourceItem.url}" target="_blank">${item.resourceItem.url}</a></b></td>
        </tr>
    </g:each>
    </tbody>
</table>

