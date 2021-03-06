<%-- 
    Document   : register
    Created on : Mar 3, 2021, 10:07:46 AM
    Author     : ihtng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <% String usernameAlert = (String) request.getAttribute("usernameAlert");
        String passwordAlert = (String) request.getAttribute("passAlert");
        String repeatPassAlert = (String) request.getAttribute("repeatPassAlert");
        
        if (usernameAlert == null) {
            usernameAlert = "";
        }
        if (passwordAlert == null) {
            passwordAlert = "";
        }
        if (repeatPassAlert == null) {
            repeatPassAlert = "";
        }
        %>
        <form action="ControllerServlet?action=register" method="POST">
            <table>
                <tr>
                    <td>Username: </td>
                    <td><input type="text" name="username" id=""></td>
                </tr>
                <tr>
                    <td> </td>
                    <td> <%= usernameAlert%> </td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="password" id=""></td>
                </tr>
                <tr>
                    <td> </td>
                    <td> <%= passwordAlert%> </td>
                </tr>
                <tr>
                    <td>Repeat password: </td>
                    <td><input type="password" name ="repeatPass"</td>
                </tr>
                <tr>
                    <td></td>
                    <td> <%= repeatPassAlert%> </td>
                </tr>
                <tr>
                    <td>Already have an account?</td>
                    <td><a href="Login.jsp">Login now</a></td>
                </tr>
                <tr>
                    <td><button type="submit">Register</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
