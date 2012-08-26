<table>
    <thead>
    <tr>

        <th>Owned_Topics</th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${ownerList}" status="i" var="item">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td><b>${item.name}</b></td>

        </tr>
    </g:each>
    </tbody>
</table>
