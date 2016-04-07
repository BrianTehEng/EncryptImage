<%-- 
    Document   : hello
    Created on : 24-Mar-2016, 4:51:46 PM
    Author     : swagbito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head><title>Image Encryptor/Decryptor!</title></head>
  <body>
    <h1>Welcome to the Image Encryptor/Decryptor!</h1>
    <p>Some details about this application:<br><br>
    1) Rejects images larger then 5MB
    <br><br>
    2)PNG works best. JPG works but the output will be PNG.
    <br><br>(usually the PNG will become much larger then the input JPG)
    
    </p>
    
    <a href='${pageContext.servletContext.contextPath}/uploadFile'>Click here to Decrypt/Encrypt Images</a>
    
    
    
  </body>
</html>
