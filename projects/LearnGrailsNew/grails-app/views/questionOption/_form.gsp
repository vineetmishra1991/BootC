<%@ page import="com.intelligrape.learngrails.QuestionOption" %>



<table class="table table-bordered">

    <tr>

        <td>
            <label for="justification">
                <g:message code="questionOption.justification.label" default="Justification"/>

            </label>
        </td>
        <td>
            <g:textField name="justification" value="${questionOptionInstance?.justification}"/>
        </td>

    </tr>

    <tr>

        <td>
            <label for="description">
                <g:message code="questionOption.description.label" default="Description"/>
            </label>
        </td>

        <td>
            <div id ="descriptionTextBoxGroup"></div>
            <div id="descriptionTextBoxDiv1">
            <g:textField name="description" value="${questionOptionInstance?.description}"/>
            <i class="icon-plus-sign" id="plusIcon"></i>
            <i class="icon-minus-sign" id="minusIcon"></i>
            </div>
        </td>

    </tr>


    <tr>

        <td>
            <label for="isCorrect">
                <g:message code="questionOption.isCorrect.label" default="Is Correct"/>
            </label>
        </td>
        <td>
            <g:checkBox name="isCorrect" value="${questionOptionInstance?.isCorrect}"/>
        </td>

    </tr>

    <tr>

        <td>
            <label for="question">
                <g:message code="questionOption.question.label" default="Question"/>
                <span class="required-indicator">*</span>
            </label>
        </td>
        <td>
            <g:select id="question" name="question.id" from="${com.intelligrape.learngrails.Question.list()}" optionKey="id" required=""
                      value="${questionOptionInstance?.question?.id}" class="many-to-one"/>
        </td>

    </tr>

</table>


