<%@ page import="com.ig.bc.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'age', 'error')} ">
	<label for="age">
		<g:message code="user.age.label" default="Age" />
		
	</label>
	<g:textField name="age" value="${userInstance?.age}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="user.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${userInstance?.name}"/>
</div>

