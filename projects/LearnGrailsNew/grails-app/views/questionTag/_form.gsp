<%@ page import="com.intelligrape.learngrails.QuestionTag" %>



<div class="fieldcontain ${hasErrors(bean: questionTagInstance, field: 'question', 'error')} required">
	<label for="question">
		<g:message code="questionTag.question.label" default="Question" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="question.id" from="${com.intelligrape.learngrails.Question.list()}" optionKey="id" value="${questionTagInstance?.question?.id}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: questionTagInstance, field: 'tag', 'error')} required">
	<label for="tag">
		<g:message code="questionTag.tag.label" default="Tag" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="tag.id" from="${com.intelligrape.learngrails.Tag.list()}" optionKey="id" value="${questionTagInstance?.tag?.id}"  />
</div>

