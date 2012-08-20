<%@ page import="com.ig.bc.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="user.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${userInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'address', 'error')} ">
	<label for="address">
		<g:message code="user.address.label" default="Address" />
		
	</label>
	<g:textField name="address" value="${userInstance?.address}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'firstname', 'error')} ">
	<label for="firstname">
		<g:message code="user.firstname.label" default="Firstname" />
		
	</label>
	<g:textField name="firstname" value="${userInstance?.firstname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'lastname', 'error')} ">
	<label for="lastname">
		<g:message code="user.lastname.label" default="Lastname" />
		
	</label>
	<g:textField name="lastname" value="${userInstance?.lastname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'male', 'error')} ">
	<label for="male">
		<g:message code="user.male.label" default="Male" />
		
	</label>
	<g:checkBox name="male" value="${userInstance?.male}" />
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} ">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		
	</label>
	<g:textField name="password" value="${userInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'readingitems', 'error')} ">
	<label for="readingitems">
		<g:message code="user.readingitems.label" default="Readingitems" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.readingitems?}" var="r">
    <li><g:link controller="readingitem" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="readingitem" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'readingitem.label', default: 'Readingitem')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'subscriptions', 'error')} ">
	<label for="subscriptions">
		<g:message code="user.subscriptions.label" default="Subscriptions" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.subscriptions?}" var="s">
    <li><g:link controller="subscription" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="subscription" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'subscription.label', default: 'Subscription')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'topics', 'error')} ">
	<label for="topics">
		<g:message code="user.topics.label" default="Topics" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.topics?}" var="t">
    <li><g:link controller="topic" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="topic" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'topic.label', default: 'Topic')])}</g:link>
</li>
</ul>

</div>

