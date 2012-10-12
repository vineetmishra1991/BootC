<%@ page import="com.intelligrape.learngrails.*" %>
<table class="table table-bordered table-striped table-hover">
    <thead>
    </thead>
    <tbody>
    <g:each in="${tagsList}" status="i" var="item">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td><b><lg:viewQuestionsTitle tagId="${item.id}"/></b></td>

        </tr>
    </g:each>
    </tbody>
</table>
