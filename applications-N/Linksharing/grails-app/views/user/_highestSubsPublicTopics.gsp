<%@ page import="com.ig.bc.Topic" %>
<table>
    <thead>
    <tr>

        <th>HighestSubscribedPublic_Topics</th>
        <th>No. Of subscriptions</th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${subscriberList}" status="i" var="item">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td><b>${item[0].toString()}</b></td>
            <td><b>${item[1].toString()}</b></td>

        </tr>
    </g:each>
    </tbody>
</table>
