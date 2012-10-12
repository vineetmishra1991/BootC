<%@ page import="com.intelligrape.learngrails.User" %>
<table class="table table-bordered table-striped table-hover">
    <thead>
    <tr>

        <th>Name</th>
        <th>No. of ratings</th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${userList}" status="i" var="item">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td><b>${item[0].toString()}</b></td>
            <td><b>${item[1].toString()}</b></td>
        </tr>
    </g:each>
    </tbody>
</table>
