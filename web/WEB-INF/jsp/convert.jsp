<%-- 
    Document   : convert
    Created on : 1-Apr-2016, 5:57:28 PM
    Author     : CodeFletcher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter Message to Encrypt</title>
    </head>
    <body>
        <h1>Enter a message to encrypt within the image you have uploaded</h1>
        
        
        
        <form method="POST" action="convert">
         <textarea onkeyup="textCounter(this,'counter');" cols="50" maxlength=${maxLen} autofocus="autofocus" rows="10" id="message" name="message"></textarea>
         <input type="submit" value="Encrypt">
        </form>
         <br><br>
        
        Characters Remaining:
        <input type="text" 
        accept="" id="counter"
        onkeypress="return isNumberKey(event)" 
        maxlength="5"
        size="4" disabled/>
       
        <script>
        function textCounter(field,field2)
        {
         var countfield = document.getElementById(field2);
         var maxlimit=${maxLen};
         if ( field.value.length > maxlimit ) {
          field.value = field.value.substring( 0, maxlimit );
          return false;
         } else {
          countfield.value = maxlimit - field.value.length;
         }
        }
        </script>
        
        
        
    </body>
</html>
