<%@ page import="com.intelligrape.learngrails.User; com.intelligrape.learngrails.Question" %>

<table class="table table-bordered">
    <tr>
        <td>
            <label for="title">
                <g:message code="question.title.label" default="Title"/>
            </label>
        </td>
        <td>
            <g:textField name="title" value="${questionInstance?.title}"/>
        </td>
    </tr>
    <tr>
        <td>
            <label for="description">
                <g:message code="question.description.label" default="Description"/>
            </label>
        </td>
        <td>
            <ckeditor:config filebrowserImageUploadUrl="false"/>
            <ckeditor:editor name="description" height="200px" width="70%" toolbar="Basic">${initialValue}</ckeditor:editor>
        </td>
    </tr>

    <tr class="prop">
        <td valign="top" class="name">
            <label for="tag"><g:message code="questionTag.tag.label" default="Tag"/></label>
        </td>
        <td valign="top" class="value ${hasErrors(bean: questionTagInstance, field: 'tag', 'errors')}">
            <g:textField name="tag" id="tags" value="${questionInstance?.tag}"/>
        </td>
    </tr>
    <tr>
        <td>
            <label for="description">
                list of options
            </label>
        </td>
        <td id="description"  >
            <i class="icon-plus-sign" id="plusIcon" ></i>
            <g:textField name="questionOptions[0].description"/>
            <g:checkBox name="questionOptions[0].isCorrect" class="correctOption" id="${questionOptionInstance.id}" />
            <i class="icon-minus-sign" id="minusIcon"></i>
        </td>
        <td style="display: none;" class="justification">
            Justification <g:textField name="justification" value="${questionOptionInstance?.justification}"/>
        </td>
    </tr>
</table>

<div id="option" style="display: none;">
    <div class="addMore" id="optionId">
        <g:textField name="questionOptions.description" value="${questionOptionInstance?.description}"/>
        <g:checkBox name="questionOptions.isCorrect" value="${questionOptionInstance?.isCorrect}" onchange="showJustification(this)" />
        <i class="icon-minus-sign" id="minusIcon" onclick="removeOption(this);"></i>
    </div>
</div>
<script type="text/javascript">
    function removeOption(object) {
        $(object).parents('div:first').html("");
    }
    function showJustification(element) {
        if ($(element).is(":checked")) {
            $('.justification').show()
        }
        else {
            $('.justification').hide()
        }
    }
    var tagsURL = "${createLink(controller: 'tag',action: 'tagListForAutoCompletion')}";
    $(function () {
        $("#tags").autocomplete({
            source:tagsURL,
            minLength:2,
            select:function (event, ui) {
            }
        });
    })
</script>