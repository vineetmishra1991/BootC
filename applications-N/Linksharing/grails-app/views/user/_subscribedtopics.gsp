<table>
    <thead>
    <tr>

        <th>Subscribed_Topic_Name</th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${topicList}" status="i" var="item">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td><b>${item.name}</b></td>

        </tr>
    </g:each>

    </tbody>
</table>


