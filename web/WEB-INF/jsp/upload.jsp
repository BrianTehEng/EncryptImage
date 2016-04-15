<%-- 
    Document   : upload.jsp
    Created on : 25-Mar-2016, 1:51:18 PM
    Author     : CodeFletcher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Encrypt Message into Image</title>
</head>

<style>
body {
    background-color: linen;
    -webkit-column-count: 2; /* Chrome, Safari, Opera */
    -moz-column-count: 2; /* Firefox */
    column-count: 2;
    
    -webkit-column-gap: 30px; /* Chrome, Safari, Opera */
    -moz-column-gap: 30px; /* Firefox */
    column-gap: 30px;
    
    -webkit-column-rule-style: solid; /* Chrome, Safari, Opera */
    -moz-column-rule-style: solid; /* Firefox */
    column-rule-style: solid;
    
    text-align: center;
}

div{
    font-size: 25px;
    background-color: graytext;
}

</style>

<body>
     
    <div>Encrypt Image:</div>
     <br><br>
    <form method="POST" action="uploadFile" enctype="multipart/form-data">
    <input type="file" name="file"> 
   
       <input type="submit" value="Encrypt"> 
    </form>
          
    <div>Decrypt Image:</div>
     <br><br>
     <form method="POST" action="deCrypt" enctype="multipart/form-data">
     <input type="file" name="file"> 
       <input type="submit" value="Decrypt"> 
    </form>
    
</body>
</html>
