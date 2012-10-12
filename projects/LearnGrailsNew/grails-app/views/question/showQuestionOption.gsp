<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.intelligrape.learngrails.*" %>>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>
<g:if test="${error != "No"}">
    <g:formRemote name="checkAnswer" url="[action: 'addRatingToQuestion', controller: 'question']" update="message">
        <table class="table table-bordered table-striped table-hover">
            <thead>
            <tr>
                <th>${question.description} <br></th>

            </tr>
            </thead>
            <tbody>
            <br>
            <g:each in="${answerOptions}" status="i" var="item">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                    <td><b>
                        <g:radio name="answerID" class="answerOption" id="answerOption_${i}" value="${item.id}"/> ${item.description} <br>
                    </b></td>
                </tr>
            </g:each>
            </tbody>
        </table>
        <br>
        <input type="hidden" name="questionId" value="${question.id}" id="questionId">
        <g:select name="usefulnessVal" id="usefulness" from="${com.intelligrape.learngrails.Usefulness?.values()}"
                  keys="${com.intelligrape.learngrails.Usefulness?.values()*.name()}"/>
        <br>
        <br>
        <g:submitToRemote url="[controller: 'question', action: 'addRatingToQuestion']" value="Submit" update="message"/>
        <br>
        <br>
    </g:formRemote>
    <div align="left">
        offset is ${offset}    <br>
        totalCount is ${totalCount}<br>
        <g:if test="${offset != totalCount - 1}">
            <g:link controller="question" action="showQuestionOption" params="[offset: offset ? offset : 0]">
                <input type="button" value="Next" style="background-color: #deb887;">
            </g:link>
        </g:if>
    </div>

    <div align="center">
        <g:if test="${offset > 0}">
            <g:link controller="question" action="showQuestionOption" params="[offset: offset - 2]">
                <input type="button" value="Previous" style="background-color: #deb887;">
            </g:link>
        </g:if>
    </div>
</g:if>
<g:else>
    <b>No more questions choose questions from other <a href="${createLink(controller: 'user', action: 'home')}">Tags</a></b>
</g:else>

<div id="message"></div>
</body>
</html>