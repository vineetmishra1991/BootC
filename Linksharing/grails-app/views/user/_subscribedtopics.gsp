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

<table>
    <thead>
    <tr>

        <th colspan="2">Subscribed Topic Name</th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${subscriberList}" status="i" var="item">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td><b>${item.topic.name}</b></td>

            <td>
                <a href="${createLink(controller: 'topic', action: 'toggleLike', id: item.id)}" class="ajax">
                    <g:if test="${item.isLike}">
                        <img class="imageUnLike" height="30" name="Liked" src="${resource(dir: 'images', file: 'like-icon.png')}" alt="true">
                    </g:if>
                    <g:else>
                        Like This
                    </g:else>
                </a>
            </td>

        </tr>

    </g:each>

    </tbody>
</table>


