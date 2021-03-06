<%-- 
    Document   : ListProducts
    Created on : Mar 5, 2021, 11:02:11 AM
    Author     : Admin
--%>

<%@page import="DTOS.Phone"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            section{    
            }
            .img {
            text-align: center;
            border: solid 1px black;
            padding: 5px;
            margin: 5px;
            height: 250px;
            width: 200px;
            float: left;
            }
            div{
                display: inline-block;
            }
        </style>
    </head>
    <body>
        <section>
            <%  ArrayList<Phone> lst = new ArrayList<>();
                lst = (ArrayList<Phone>) request.getAttribute("Phones");
                for(Phone p : lst){%>`
                <div class="img">
                    <%= p.getPhoneName() %> <br><img 
                        src="images/<%= p.getImageURL() %>" width="120"> <br>
                    <%= p.getPrice() %>Đ <br>
                    <a href="ControllerServlet?action=delete">delete</a> |
                    <a href="ControllerServlet?action=update">update</a>
                </div>    
            <%}%>
        </section>
        <footer> <a href=ControllerServlet?action=add">Add new items</a> </footer>
    </body>
</html>
