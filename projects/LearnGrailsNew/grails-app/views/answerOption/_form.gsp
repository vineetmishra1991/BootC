<%@ page import="com.intelligrape.learngrails.AnswerOption" %>



<div class="fieldcontain ${hasErrors(bean: answerOptionInstance, field: 'justification', 'error')} ">
	<label for="justification">
		<g:message code="answerOption.justification.label" default="Justification" />
		
	</label>
	<g:textField name="justification" value="${answerOptionInstance?.justification}" />
</div>

<div class="fieldcontain ${hasErrors(bean: answerOptionInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="answerOption.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${answerOptionInstance?.description}" />
</div>

<div class="fieldcontain ${hasErrors(bean: answerOptionInstance, field: 'isCorrect', 'error')} ">
	<label for="isCorrect">
		<g:message code="answerOption.isCorrect.label" default="Is Correct" />
		
	</label>
	<g:checkBox name="isCorrect" value="${answerOptionInstance?.isCorrect}" />
</div>

<div class="fieldcontain ${hasErrors(bean: answerOptionInstance, field: 'question', 'error')} required">
	<label for="question">
		<g:message code="answerOption.question.label" default="Question" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="question.id" from="${com.intelligrape.learngrails.Question.list()}" optionKey="id" value="${answerOptionInstance?.question?.id}"  />
</div>

