<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
    <script type="text/javascript">
        $(document).ready(function () {
            var $tabs = $('#tabs').tabs();
        });
    </script>
</head>

<body>
<div id=tabs>
    <ul>
        <li><a href="#tab1">Browse Tags</a></li>
        <li><a href="#tab2">Top Teachers</a></li>
    </ul>

    <div id='tab1'>
        <lg:tags/>
    </div>

    <div id='tab2'>
        <lg:topTeachers max="5"/>
    </div>
</div>
</body>
</html>