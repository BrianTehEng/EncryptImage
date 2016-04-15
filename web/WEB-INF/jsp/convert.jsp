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
    
    <style>
        
        body{
            
            
             text-align: center;
             background-color: #1a1a1a;
        }
        
        h3{
            
            background-color: graytext;
            font-size:24px;
    
        }
        
        div{
             background-color: graytext;
             font-size:24px;
            
          
        }
        
        input[type="text"]
{
    font-size:24px;
    font-weight: bold;
}
        
    </style>    
    
    <body>
        <h3>Enter A Message to be Encrypted Inside your Image</h3>
        
        <br><br>
         
        
        <form method="POST" action="convert">
         <textarea onkeyup="textCounter(this,'counter');" cols="70" maxlength=${maxLen} autofocus="autofocus" rows="20" id="message" name="message"></textarea>
         <input type="submit" value="Encrypt">
        </form>
         <br><br>
          <br><br>
         <div>
        Characters Remaining:
        <input type="text" 
        accept="" id="counter"
        onkeypress="return isNumberKey(event)" 
        maxlength="5"
        size="4" disabled/>
         </div>
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
