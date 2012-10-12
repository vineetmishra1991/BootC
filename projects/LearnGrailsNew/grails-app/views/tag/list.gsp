
<%@ page import="com.intelligrape.learngrails.Tag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'tag.label', default: 'Tag')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>

<div class="block">
    <div class="block_head">
        <div class="bheadl"></div>

        <div class="bheadr"></div>

        <h2><g:message code="default.list.label" args="[entityName]"/></h2>

        <ul>
            <li><g:link class="create" action="create">Add Tag</g:link></li>
        </ul>
    </div>

    <div class="block_content">
        <table cellpadding="0" cellspacing="0" width="100%">
            <thead>
            <tr>
                
                <g:sortableColumn property="name" title="${message(code: 'tag.name.label', default: 'Name')}"/>
                
            </tr>
            </thead>
            <tbody>
            <g:each in="${tagInstanceList}" status="i" var="tagInstance">
                <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                    
                    <td><g:link action="show" id="${tagInstance.id}">${fieldValue(bean: tagInstance, field: "name")}</g:link></td>
                    
                </tr>
            </g:each>
            </tbody>
        </table>

        <div class="pagination right">
            <g:paginate total="${tagInstanceTotal}"/>
        </div>
    </div>

    <div class="bendl"></div>

    <div class="bendr"></div>

</div>
</body>
</html>
