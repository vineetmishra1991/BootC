<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 28/8/12
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
    <script type="text/javascript">
        $(document).ready(function () {
            var url = $("#url").val();
            $('#date').datepicker();

            jQuery("#registration").validate({
                rules:{
                    name:{
                        required:true
                    },
                    email:{
                        required:true,
                        remote:url
                    },
                    password:{
                        required:true
                    },
                    confirmPassword:{
                        required:true,
                        equalTo:"#password"
                    }
                },
                messages:{
                    name:{
                        required:"Required name"
                    },
                    email:{
                        remote:"Email Already Exists !"
                    },
                    confirmPassword:{

                        equalTo:"Password and ConfirmPassword donot match"
                    }
                }
            });
        });

        function check() {
            emailCheckViaAJAX();  //for ajax call this function in checkMail button
        }

        function emailCheckViaAJAX() {
            var url = $("#url").val();
            $.ajax({
                type:"GET",
                url:url,
                dataType:"html",
                data:{email:$("#email").val()}
            }).done(function (data) {
                        if (data == "true") {
                            $("#message").html("Email is Not Available !")
                        }
                        else {
                            $("#message").html("Email is available !")
                        }
                    });
        }

    </script>

</head>

<body>
<%@ page import="com.ig.bc.User" %>


<g:form name="registration" controller="user" action="saveUser">
    <div id="urlGet">
        <g:hiddenField name="url" id="url" value="${createLink(controller: 'user', action: 'checkEmailAvailability')}"/>
    </div> <br>
    Email:<g:field type="email" name="email" class="email" id="email" value=""/>

    <div id="message" style="background-color: silver;"></div><br>
    Address:<g:textField name="address" value=""/><br><br>
    FirstName:<g:textField name="firstname" value=""/><br><br>
    LastName:<g:textField name="lastname" value=""/><br><br>
    Sex(Male):<g:checkBox name="male" value=""/><br><br>
    Date of Birth:<g:field type="text" name="dateOfBirth" id="date"/><br><br>
    Password:<g:textField name="password" id="password" value=""/><br><br>
    ConfirmPassword: <g:textField name="confirmPassword" id="confirmPassword" value=""/><br><br>

    <input type="submit" value="Register">
</g:form>
</body>
</html>