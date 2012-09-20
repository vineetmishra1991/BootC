<%@ page import="com.ig.bc.*" %>



<div class="fieldcontain ${hasErrors(bean: topicInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="topic.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${topicInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: topicInstance, field: 'owner', 'error')} required">

    <g:hiddenField id="owner" name="owner.id" value="${com.ig.bc.User.findByEmail(session.userEmail).id}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: topicInstance, field: 'resources', 'error')} ">
    <label for="resources">
        <g:message code="topic.resources.label" default="Resources"/>

    </label>

    <ul class="one-to-many">
        <g:each in="${topicInstance?.resources ?}" var="r">
            <li><g:link controller="resource" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
        </g:each>
        <li class="add">
            <g:link controller="resource" action="create"
                    params="['topic.id': topicInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'resource.label', default: 'Resource')])}</g:link>
        </li>
    </ul>

</div>

<div class="fieldcontain ${hasErrors(bean: topicInstance, field: 'subscriptions', 'error')} ">
    <label for="subscriptions">
        <g:message code="topic.subscriptions.label" default="Subscriptions"/>

    </label>

    <ul class="one-to-many">
        <g:each in="${topicInstance?.subscriptions ?}" var="s">
            <li><g:link controller="subscription" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
        </g:each>
        <li class="add">
            <g:link controller="subscription" action="create"
                    params="['topic.id': topicInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'subscription.label', default: 'Subscription')])}</g:link>
        </li>
    </ul>

</div>

<div class="fieldcontain ${hasErrors(bean: topicInstance, field: 'visibility', 'error')} required">
    <label for="visibility">
        <g:message code="topic.visibility.label" default="Visibility"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select name="visibility" from="${com.ig.bc.Visibility?.values()}" keys="${com.ig.bc.Visibility.values()*.name()}" required=""
              value="${topicInstance?.visibility?.name()}"/>
</div>

