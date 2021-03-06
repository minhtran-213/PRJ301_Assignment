<%-- 
    Document   : landingPage
    Created on : Mar 3, 2021, 11:24:47 AM
    Author     : ihtng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%
            response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
            response.setHeader("pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            String username = (String) session.getAttribute("userName");
            if (username != null) {
                out.print("Welcome, " + username);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        %>
        <br/>
        <ul>
            <li>
                <a href="ControllerServlet?action=listProduct">List all products</a>
            </li>
            <li>
                <a href="ControllerServlet?action=listProduct">List all products</a>
            </li>
            <li>
                <a href="ControllerServlet?action=logout">Logout</a>
            </li>
        </ul>
    </body>
</html>
