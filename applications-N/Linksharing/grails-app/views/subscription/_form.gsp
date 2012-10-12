<%@ page import="com.ig.bc.Subscription" %>



<div class="fieldcontain ${hasErrors(bean: subscriptionInstance, field: 'topic', 'error')} required">
	<label for="topic">
		<g:message code="subscription.topic.label" default="Topic" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="topic" name="topic.id" from="${com.ig.bc.Topic.list()}" optionKey="id" required="" value="${subscriptionInstance?.topic?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: subscriptionInstance, field: 'seriousness', 'error')} required">
	<label for="seriousness">
		<g:message code="subscription.seriousness.label" default="Seriousness" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="seriousness" from="${com.ig.bc.Seriousness?.values()}" keys="${com.ig.bc.Seriousness.values()*.name()}" required="" value="${subscriptionInstance?.seriousness?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: subscriptionInstance, field: 'subscriber', 'error')} required">
	<label for="subscriber">
		<g:message code="subscription.subscriber.label" default="Subscriber" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="subscriber" name="subscriber.id" from="${com.ig.bc.User.list()}" optionKey="id" required="" value="${subscriptionInstance?.subscriber?.id}" class="many-to-one"/>
</div>

