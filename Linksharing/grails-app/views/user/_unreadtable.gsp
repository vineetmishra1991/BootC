<script type="text/javascript">

    function markItemRead() {
        var url = "${createLink(controller: 'readingItem', action: 'markRead')}";
        $.ajax({
            type:"GET",
            url:url,
            dataType:"JSON",
            data:{'item':$("#item").val()}
        }).done(function (data) {
                    if (data) {
                        $("#row").hide()
                    }
                });
    }
</script>

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
        <tr id="row" class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td><b><a href="${item.resourceItem.url}" target="_blank">${item.resourceItem.url}</a></b></td>
            <td><b>${item.isFavourite ? 'Yes' : 'No'}</b></td>
            <td><g:hiddenField name="url" id="item" value="${item.id}"/><a href="" onclick="markItemRead()">Mark Read</a></td>
        </tr>
    </g:each>
    </tbody>
</table>