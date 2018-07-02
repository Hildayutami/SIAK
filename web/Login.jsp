<%-- 
    Document   : Login
    Created on : Jun 27, 2018, 7:51:19 PM
    Author     : hilda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
<!--        <script>
            function validate()
            {
                var username = document.form.username.value;
                var password = document.form.password.value;

                if (username == null || username == "")
                {
                    alert("Username cannot be blank");
                    return false;
                } else if (password == null || password == "")
                {
                    alert("Password cannot be blank");
                    return false;
                }
            }
        </script> -->
    </head>
    <body>
        <div style="text-align:center"><h1>Login</h1> </div>
        <br>
        <form name="form" action='LoginController' name="frmLogin" method="POST"">
            <!-- Do not use table to format fields. As a good practice use CSS -->
            <table align="center">
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login"></input><input
                            type="reset" value="Reset"></input></td>
                </tr>
            </table>
        </form>
    </body>
</html>
