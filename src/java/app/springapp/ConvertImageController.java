/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.springapp;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author CodeFletcher
 */


@Controller
@Scope("request")
public class ConvertImageController {
    
    @Autowired
    ImageConverter img_conv;
    
        
    @RequestMapping(value = "/convert", method = RequestMethod.GET)
    public ModelAndView redirect()
            throws ServletException, IOException {
       return new ModelAndView("upload");
    }
    
    
    @RequestMapping(value = "/convert", method = RequestMethod.POST)
    public ModelAndView encryptMessage(@RequestParam("message") String message){
        
       
       ModelAndView display=new ModelAndView("display");
      
       img_conv.setMessage(message);
       img_conv.convertImage();
    
       return display;
    
    
    }
    
//Returns image for view
@RequestMapping(value = "/imageController/{imageId}")
@ResponseBody
public byte[] getImage(@PathVariable int imageId)  {
  
     ByteArrayOutputStream baos=new ByteArrayOutputStream();
     BufferedImage im;
    if(imageId==1271){
        
        im=img_conv.getConvertedImage();
        
    }else{
        
         im=img_conv.getOriginalImage();
    }

    try{
    ImageIO.write(im, "png", baos);
    }
    catch(IOException e){
        
    }
    
    return baos.toByteArray();
    
}

}

    

