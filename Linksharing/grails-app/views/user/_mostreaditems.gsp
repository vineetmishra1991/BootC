<%@ page import="com.ig.bc.Topic" %>
<table>
    <thead>
    <tr>

        <th>Reading Item</th>
        <th>No. Of Times Read</th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${readingItemsList}" status="i" var="item">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td><b><a href="${item[0].toString()}" target="_blank">${item[0].toString()}</a></b></td>
            <td><b>${item[1].toString()}</b></td>

        </tr>
    </g:each>
    </tbody>
</table>
