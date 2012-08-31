<div>
    <g:form controller="documentResource" action="save" enctype="multipart/form-data" method="POST">
        Title: <input type="text" name="title"> <br> <br>
        Summary: <textarea maxlength="1000" name="summary">
    </textarea>   <br> <br><br>
        Select Topic to Which you Want to Add Document:
        <g:select id="topic" name="id" from="${com.ig.bc.Topic.list()}" optionKey="id" required="" optionValue="name" value="${id}"/>
        <br><br>
        <input type="file" name="myFile"/>   <br><br>
        <br><input type="submit" value="AddDocument"> <br><br>
    </g:form>
</div>