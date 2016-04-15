<%-- 
    Document   : display.jsp
    Created on : 25-Mar-2016, 7:34:50 PM
    Author     : CodeFletcher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Done!</title>
             
    </head>
    
    <style>
        
        body {
            
            text-align: center;
        }
    </style>
    
    <body>
        <h1>Encryption Complete!</h1>
        <br><br>
        Here is your image!<br><br>
        <img src="${pageContext.servletContext.contextPath}/imageController/1271"/>
        
        
        
    </body>
</html>
