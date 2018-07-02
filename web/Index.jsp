<%-- 
    Document   : Index.jsp
    Created on : Jun 26, 2018, 5:06:22 AM
    Author     : hilda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIAK</title>
    </head>
    <body>
        <jsp:forward page="/MahasiswaController?action=listmahasiswa" />
    </body>
<!--    <body>
    <center><h2>Home Page</h2></center>
    Welcome <%=request.getAttribute("username")%>  Refer to the video to understand how this works 
    <div style="text-align: right"><a href="LogoutController">Logout</a></div>
</body>-->
</html>
