<%-- 
    Document   : newjsp
    Created on : 3-Apr-2016, 11:50:28 AM
    Author     : CodeFletcher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Message</title>
    </head>
    
    <style>
        body{
            text-align: center;
        }    
    </style>
    
    <body>
        <h1>Message:</h1>
        <textarea cols="70" rows="20">${message}</textarea>
    </body>
</html>
