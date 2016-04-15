<%-- 
    Document   : hello
    Created on : 24-Mar-2016, 4:51:46 PM
    Author     : CodeFletcher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head><title>Image Encryptor/Decryptor!</title></head>
  
  <style>
      
      body{
          text-align: center;
      }
  </style>
  
  <body>
    <h1>Welcome to the Image Encryptor/Decryptor!</h1>
    <br>
    <p>Some details about this app:<br><br>
    1) Rejects images larger then 5MB
    <br><br>
    2)PNG works best. JPG also works but output will be a large PNG file.
    </p>
    <br>
    <h2> <a href='${pageContext.servletContext.contextPath}/uploadFile'>Click here to Decrypt/Encrypt Images</a> </h2>
    
    
    
  </body>
</html>
