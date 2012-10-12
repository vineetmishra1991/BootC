<%@ page import="com.intelligrape.learngrails.Question" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>

</head>


<body>
<g:hasErrors bean="${questionInstance}">
    <div class="alert alert-error">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <ul class="unstyled">
            <g:eachError bean="${questionInstance}" var="error">
                <li><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </div>
</g:hasErrors>
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#"><g:message code="default.create.label" args="[entityName]"/></a>
        <ul class="nav pull-right">
            <li><g:link class="list" action="list"><i class="icon-list"></i>&nbsp;<g:message code="default.list.label" args="[entityName]"/></g:link></li>
        </ul>
    </div>
</div>

<g:form class="form-horizontal" action="save">
    <g:if test="${questionInstance?.id}">
        <g:hiddenField name="id" value="${questionInstance?.id}"/>
        <g:hiddenField name="version" value="${questionInstance?.version}"/>
    </g:if>
    <g:render template="form"/>

    <div class="control-group">
        <g:if test="${questionInstance?.id}">
            <g:actionSubmit class="btn btn-info" action="save" value="${message(code: 'default.button.update.label', default: 'Update')}"/>
            <g:actionSubmit class="btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" formnovalidate=""
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </g:if><g:else>
            <g:submitButton name="create" class="btn btn-info" value="${message(code: 'default.button.create.label', default: 'Create')}"/>
        </g:else>
    </div>
</g:form>



<script type="text/javascript">
    var rowCount=1;

    function replaceAll(txt, replace, with_this) {
        return txt.replace(new RegExp(replace, 'g'),with_this);
    }

    $(document).ready(function () {
        $('.correctOption').bind("click", function () {
            if ($(this).is(':checked')) {
                $('.justification').show()
            }
            else{
                $('.justification').hide()
            }
        });

        $('#plusIcon').bind("click", function () {
            var questionRow = $('#option').html();
            questionRow = replaceAll(questionRow,'questionOptions', 'questionOptions['+rowCount+']') ;
            var newDiv = $("td#description").append(questionRow);
            rowCount++;
        });


    })

</script>

</body>
</html>
