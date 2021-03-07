<%-- 
    Document   : addform
    Created on : Mar 7, 2021, 10:47:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add phone form</h1>
        <form action="ControllerServlet?action=listProduct" method="POST" name="addform" enctype="multipart/form_data">
            <table>
                <tr>
                    <td>Phone ID:</td>
                    <td><input type="text" name="id"></td>
                </tr>
                <tr>
                    <td>Phone Name:</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><input type="text" name="desc"></td>
                </tr>
                <tr>
                    <td>Brand ID:</td>
                    <td><input type="text" name="bid"></td>
                </tr>
                <tr>
                    <td>Image:</td>
                    <td><input type="file" name="image"></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="number" name="price"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
