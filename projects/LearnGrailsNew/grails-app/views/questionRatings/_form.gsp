<%@ page import="com.intelligrape.learngrails.QuestionRatings" %>



<div class="fieldcontain ${hasErrors(bean: questionRatingsInstance, field: 'answerOption', 'error')} required">
	<label for="answerOption">
		<g:message code="questionRatings.answerOption.label" default="Answer Option" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="answerOption.id" from="${com.intelligrape.learngrails.AnswerOption.list()}" optionKey="id" value="${questionRatingsInstance?.answerOption?.id}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: questionRatingsInstance, field: 'question', 'error')} required">
	<label for="question">
		<g:message code="questionRatings.question.label" default="Question" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="question.id" from="${com.intelligrape.learngrails.Question.list()}" optionKey="id" value="${questionRatingsInstance?.question?.id}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: questionRatingsInstance, field: 'usefulness', 'error')} required">
	<label for="usefulness">
		<g:message code="questionRatings.usefulness.label" default="Usefulness" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="usefulness" from="${com.intelligrape.learngrails.Usefulness?.values()}" keys="${com.intelligrape.learngrails.Usefulness?.values()*.name()}" value="${questionRatingsInstance?.usefulness?.name()}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: questionRatingsInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="questionRatings.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="user.id" from="${com.intelligrape.learngrails.User.list()}" optionKey="id" value="${questionRatingsInstance?.user?.id}"  />
</div>

