<table>
    <thead>
    <tr>

        <th>Title</th>
        <th>Resource</th>

    </tr>
    </thead>
    <tbody>

    <g:each in="${unreadItemsList}" status="i" var="item">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td><b>${item.key}</b></td>
            <td><b>${item.value.each {println it.resourceItem.url}}</b></td>

        </tr>
    </g:each>
    </tbody>
</table>