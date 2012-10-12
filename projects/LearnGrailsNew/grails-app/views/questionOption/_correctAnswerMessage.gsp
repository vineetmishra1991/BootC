<%@ page import="com.intelligrape.learngrails.Tag" %>
Correct Answer !!
<br>
<a href="${createLink(controller: 'question', action: 'listTagQuestion')}">Browse another question from "${Tag.get(session.tagID).name}"</a>
<br>
or
<br>
<a href="${createLink(controller: 'user', action: 'home')}">Choose from other tags</a>