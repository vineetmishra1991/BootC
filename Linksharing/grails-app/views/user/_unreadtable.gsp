<table>
    <thead>
    <tr>

        <th>Title</th>
        <th>is Favourite</th>
        <th>Mark as Read</th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${list}" status="i" var="item">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td><b><a href="${item.resource.url}" target="_blank">${item.resource.url}</a></b></td>
            <td><b>${item.isfavorite ? 'Yes' : 'No'}</b></td>
            <td><ls:markAsRead itemId="${item.id}"/></td>

        </tr>
    </g:each>
    </tbody>
</table>