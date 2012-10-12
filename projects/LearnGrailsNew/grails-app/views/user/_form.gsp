<%@ page import="com.intelligrape.learngrails.User" %>



<table class="table table-bordered">

<tr>

    <td>
        <label for="username">
            <g:message code="user.username.label" default="Username"/>
            <span class="required-indicator">*</span>
        </label>
    </td>
    <td>
        <g:textField name="username" required="" value="${userInstance?.username}"/>
    </td>

</tr>

<tr>

    <td>
        <label for="password">
            <g:message code="user.password.label" default="Password"/>
            <span class="required-indicator">*</span>
        </label>
    </td>
    <td>
        <g:textField name="password" required="" value="${userInstance?.password}"/>
    </td>

</tr>
<tr>

    <td>
        <label for="confirmPassword">
            <g:message code="user.password.label" default="Confirm Password"/>
            <span class="required-indicator">*</span>
        </label>
    </td>
    <td>
        <g:textField name="confirmPassword"/>
    </td>

</tr>

<tr>

    <td>
        <label for="email">
            <g:message code="user.email.label" default="Email"/>

        </label>
    </td>
    <td>
        <g:field type="email" name="email" value="${userInstance?.email}"/>
    </td>

</tr>

%{--<tr>--}%
%{----}%
%{--<td>--}%
%{--<label for="accountExpired">--}%
%{--<g:message code="user.accountExpired.label" default="Account Expired" />--}%
%{----}%
%{--</label>--}%
%{--</td>--}%
%{--<td>--}%
%{--<g:checkBox name="accountExpired" value="${userInstance?.accountExpired}" />--}%
%{--</td>--}%

%{--</tr>--}%

%{--<tr>--}%
%{----}%
%{--<td>--}%
%{--<label for="accountLocked">--}%
%{--<g:message code="user.accountLocked.label" default="Account Locked" />--}%
%{----}%
%{--</label>--}%
%{--</td>--}%
%{--<td>--}%
%{--<g:checkBox name="accountLocked" value="${userInstance?.accountLocked}" />--}%
%{--</td>--}%

%{--</tr>--}%

<tr>

    <td>
        <label for="address">
            <g:message code="user.address.label" default="Address"/>

        </label>
    </td>
    <td>
        <g:textField name="address" value="${userInstance?.address}"/>
    </td>

</tr>

<tr>

    <td>
        <label for="answers">
            <g:message code="user.answers.label" default="Answers"/>

        </label>
    </td>
    <td>

        <ul class="one-to-many">
            <g:each in="${userInstance?.answers ?}" var="a">
                <li><g:link controller="answer" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
            </g:each>
            <li class="add">
                <g:link controller="answer" action="create"
                        params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'answer.label', default: 'Answer')])}</g:link>
            </li>
        </ul>

    </td>

</tr>

<tr>

    <td>
        <label for="dateOfBirth">
            <g:message code="user.dateOfBirth.label" default="Date Of Birth"/>
            <span class="required-indicator">*</span>
        </label>
    </td>
    <td>
        <g:datePicker name="dateOfBirth" precision="day" value="${userInstance?.dateOfBirth}"/>
    </td>

</tr>

%{--<tr>--}%
%{----}%
%{--<td>--}%
%{--<label for="enabled">--}%
%{--<g:message code="user.enabled.label" default="Enabled" />--}%
%{----}%
%{--</label>--}%
%{--</td>--}%
%{--<td>--}%
%{--<g:checkBox name="enabled" value="${userInstance?.enabled}" />--}%
%{--</td>--}%

%{--</tr>--}%

<tr>

    <td>
        <label for="gender">
            <g:message code="user.gender.label" default="Gender"/>
            <span class="required-indicator">*</span>
        </label>
    </td>
    <td>
        <g:select name="gender" from="${com.intelligrape.learngrails.Gender?.values()}" keys="${com.intelligrape.learngrails.Gender.values()*.name()}" required=""
                  value="${userInstance?.gender?.name()}"/>
    </td>

</tr>

%{--<tr>--}%
%{----}%
%{--<td>--}%
%{--<label for="passwordExpired">--}%
%{--<g:message code="user.passwordExpired.label" default="Password Expired" />--}%
%{----}%
%{--</label>--}%
%{--</td>--}%
%{--<td>--}%
%{--<g:checkBox name="passwordExpired" value="${userInstance?.passwordExpired}" />--}%
%{--</td>--}%

%{--</tr>--}%

<tr>

    <td>
        <label for="questions">
            <g:message code="user.questions.label" default="Questions"/>

        </label>
    </td>
    <td>

        <ul class="one-to-many">
            <g:each in="${userInstance?.questions ?}" var="q">
                <li><g:link controller="question" action="show" id="${q.id}">${q?.encodeAsHTML()}</g:link></li>
            </g:each>
            <li class="add">
                <g:link controller="question" action="create"
                        params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'question.label', default: 'Question')])}</g:link>
            </li>
        </ul>

    </td>

</tr>

</table>

