<%@ page import="com.intelligrape.learngrails.*" %>

<head>
    <meta name="layout" content="main"/>
</head>
<table class="table table-bordered table-striped table-hover">
    <thead>
    <tr>

        <th>Questions Brief Description</th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${questionList}" status="i" var="item">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td><b><lg:viewQuestion questionId="${item.id}"/></b></td>
        </tr>
    </g:each>
    </tbody>
</table>