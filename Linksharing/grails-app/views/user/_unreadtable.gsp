<script type="text/javascript">

    function markItemRead(id, newId) {
        var url = "${createLink(controller: 'readingItem', action: 'markRead')}";
        $.ajax({
            type:"GET",
            url:url,
            dataType:"JSON",
            data:{'item':$("#" + newId).val()}
        }).done(function (data) {
                    if (data) {
                        $("#" + id).hide();
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
        <tr id="row_${i}" class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td><b><a href="${item.resourceItem.url}" target="_blank">${item.resourceItem.url}</a></b></td>
            <td><b>${item.isFavourite ? 'Yes' : 'No'}</b></td>
            <td><g:hiddenField name="url" id="item_${i}" value="${item.id}"/><a onclick="markItemRead('row_${i}', 'item_${i}')">Mark Read</a></td>
        </tr>
    </g:each>
    </tbody>
</table>