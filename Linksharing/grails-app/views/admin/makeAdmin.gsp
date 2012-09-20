<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 19/09/12
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
    <script type="text/javascript">

        $(document).ready(function () {
            $('.ajax').click(function () {
                var $anchor = $(this);
                var url = $anchor.attr('href');
                $.post(url, function (response) {
                    $anchor.html(response);
                });
                return false
            })
        })

    </script>
</head>

<body>
<table>
    <thead>
    <th colspan="2">
        UserName
    </th>

    </thead>
    <tbody>
    <g:each in="${userInstanceList}" status="i" var="item">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td>
                ${fieldValue(bean: item, field: "firstname")}
            </td>

            <td>
                <a href="${createLink(controller: 'admin', action: 'toggleAdmin', id: item.id)}" class="ajax">
                    <g:if test="${item.admin}">
                        Admin
                    </g:if>
                    <g:else>
                        Make Admin
                    </g:else>
                </a>
            </td>

        </tr>
    </g:each>
    </tbody>
</table>
</body>
</html>