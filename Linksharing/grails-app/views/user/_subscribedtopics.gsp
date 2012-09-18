<script type="text/javascript">

    function doUnLike(newId) {
        alert(newId);
        var url = "${createLink(controller: 'topic', action: 'makeUnLike')}";
        $.ajax({
            type:"GET",
            url:url,
            dataType:"JSON",
            data:{'item':newId}
        }).done(function (data) {
                    if (data) {
                        alert(data);
                        $("#putButton_" + data).html('');
                        $("#putButton_" + data).html('<input class="buttonLike" type="button" name="unLiked" id="unLiked_' + data + '" value="Like This">');
                        bindButtonAndImage()
                    }
                });
    }

    function bindButtonAndImage() {
        jQuery('.buttonLike').on('click', function () {
            doLike(jQuery(this).attr("id"));
        });

        jQuery('.imageUnLike').on('click', function () {
            doUnLike(jQuery(this).attr("id"));
        });
    }

    $(document).ready(function () {
        bindButtonAndImage();
    });

    function doLike(newId) {
        alert(newId);

        var url = "${createLink(controller: 'topic', action: 'makeLike')}";
        $.ajax({
            type:"GET",
            url:url,
            dataType:"JSON",
            data:{'item':newId}
        }).done(function (data) {
                    if (data) {
                        alert(data);
                        $("#putImage_" + data).html('');
                        $("#putImage_" + data).html('<img class="imageUnLike" id="image_' + data + '" name="Liked" src="${resource(dir: 'images',file: 'like-icon.png')}" alt="true">');
                        bindButtonAndImage()
                    }
                });
    }

</script>

<table>
    <thead>
    <tr>

        <th>Subscribed_Topic_Name</th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${subscriberList}" status="i" var="item">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td><b>${item.topic.name}</b></td>

            <td>
                <g:if test="${item.isLike}">
                    <g:hiddenField name="item_id" id="item_${i}" value="${item.id}"/>
                    <div id="putButton_${item.id}">
                        <img class="imageUnLike" id="image_${item.id}" name="Liked" src="${resource(dir: 'images', file: 'like-icon.png')}" alt="true">
                    </div>
                </g:if>
                <g:else>
                    <div id="putImage_${item.id}">
                        <input type="button" name="unLiked" class="buttonLike" id="unLiked_${item.id}" value="Like This">
                    </div>
                </g:else>
            </td>

        </tr>

    </g:each>

    </tbody>
</table>


