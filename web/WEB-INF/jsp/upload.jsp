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
<body>
 
    <h2>Encrypt image with a message:</h2>
    <form method="POST" action="uploadFile" enctype="multipart/form-data">
        File to upload: <input type="file" name="file"><br /> 
       <input type="submit" value="Encrypt"> Press here to upload and convert the image!
    </form>
    <br><br>
    
    <h2>Decrypt image to get hidden message:</h2>
     
    <form method="POST" action="deCrypt" enctype="multipart/form-data">
        File to upload: <input type="file" name="file"><br /> 
       <input type="submit" value="Decrypt"> Press here to upload and decrypt the image!
    </form>
     
</body>
</html>
