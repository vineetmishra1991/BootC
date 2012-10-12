<%@ page import="plugindemo.Person" %>



<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'designation', 'error')} ">
	<label for="designation">
		<g:message code="person.designation.label" default="Designation" />
		
	</label>
	<g:textField name="designation" value="${personInstance?.designation}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="person.email.label" default="Email" />
		
	</label>
	<g:textField name="email" value="${personInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="person.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${personInstance?.name}"/>
</div>

