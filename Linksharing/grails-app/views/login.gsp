<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:g="http://www.w3.org/1999/html">
<head>
    <title></title>
    <meta name="layout" content="main">
    <g:javascript src="jquery.validate.js"/>
    <script type="text/javascript">
        $(document).ready(function () {
            jQuery("#loginForm").validate({
                rules:{
                    name:{
                        required:true
                    },
                    password:{
                        required:true
                    }
                },
                messages:{
                    name:{
                        required:"Enter Name"
                    },
                    password:{
                        required:"Password is Required!"
                    }
                }
            });
        });
    </script>
</head>

<body>
<form id="loginForm" action="${createLink(controller: 'login',action: 'loginHandler')}" method="post">

    <br>

    ${flash.message} <br>
    %{--<div align="center">      Name:&nbsp;           <input type="text" name="t1"> </div> <br>--}%
    %{--<div align="center">Password:  <input type="password" name="t2"></div> <br>--}%
    <br>
    <table>
        <tr>
            <td align="center">Name:</td>
            <td align="center"><input type="text" name="name"></td>
        </tr>
        <tr>
            <td align="center">Password:</td>
            <td align="center"><input type="password" name="password"></td>
        </tr>
    </table>
    <a href="${createLink(controller: 'user',action: 'register')}">Register</a>

    <div align="center">
        <input type="submit" name="s1" value="Submit">
    </div>
</form>

</body>
</html>