<%-- 
    Document   : login
    Created on : Mar 3, 2021, 9:35:53 AM
    Author     : ihtng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="ControllerServlet?action=login" method="POST">
            <% String message = (String) request.getAttribute("loginAlert");
            if (message == null) {
                message = "";
            }
            %>
            <table>
                <tr>
                    <td>Username: </td>
                    <td><input type="text" name="Username" id="Username"></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="Password" id="Password"></td>
                </tr>
                <tr>
                    <td> </td>
                    <td><%= message %></td>
                </tr>
                <tr>
                    <td><button type="submit">Login</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
