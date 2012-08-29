<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:g="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="main">
    <title></title>
    <g:javascript src="jquery.validate.js"/>
    <script type="text/javascript">
        $(document).ready(function () {
            jQuery("#loginForm").validate({
                rules:{
                    email:{
                        email:true
                    },
                    password:{
                        required:true
                    }
                },
                messages:{
                    email:{
                        required:"Email is required"
                    },
                    password:{
                        required:"password is required"
                    }
                }
            });
        });
    </script>
</head>

<body>
<form name="loginFoem" action="${createLink(controller: 'login', action: 'loginHandler')}" method="post">

    <br>

    ${flash.message} <br>
    %{--<div align="center">      Name:&nbsp;           <input type="text" name="t1"> </div> <br>--}%
    %{--<div align="center">Password:  <input type="password" name="t2"></div> <br>--}%
    <br>
    <table>
        <tr>
            <td align="center">Name:</td>
            <td align="center"><input type="text" name="t1"></td>
        </tr>
        <tr>
            <td align="center">Password:</td>
            <td align="center"><input type="password" name="t2"></td>
        </tr>
    </table>
    <a href="${createLink(controller: 'user', action: 'register')}">Register</a>

    <div align="center">
        <input type="submit" name="s1" value="Submit">
    </div>
</form>

</body>
</html>