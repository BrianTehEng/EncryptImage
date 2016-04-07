/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.springapp;

/**
 *
 * @author CodeFletcher
 */
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
 
/**
 * Handles requests for the application file upload requests
 */
@Controller
@Scope("request")
public class FileUploadController {
 
    
   @Autowired
   ImageConverter img_conv;
    
   //returns the maximum character length that can be encrypted within image
    public int getMaxMessageLength(){
              
       return img_conv.getMaxEncryptionSize();
               
    }
    
    //Converts input MultipartFile into an image, if not returns a null image
    public BufferedImage convert(MultipartFile file)
{    
    BufferedImage im=null;
    File convFile = new File(file.getOriginalFilename());
    
    try{
    convFile.createNewFile(); 
    FileOutputStream fos = new FileOutputStream(convFile); 
    fos.write(file.getBytes());
    fos.close(); 
    im=ImageIO.read(convFile);
    }
    catch(IOException e){
        
    }
    
    return im;
    
}
    
    
    /**
     * Upload single file using Spring Controller
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView uploadFileHandler(@RequestParam("file") MultipartFile file) 
    {
         if (!file.isEmpty()) {
            try {
                          
                img_conv.setOriginalImage(convert(file));
                
                               
            ModelAndView convert=new ModelAndView("convert");
            
            int n=getMaxMessageLength();
            String _n=Integer.toString(n);
            convert.addObject("maxLen", _n);
            convert.addObject("img_conv", img_conv);
                return convert;
                   
            } catch (Exception e) {
                return new ModelAndView("error");                
            }
        } else {
                return new ModelAndView("error");
        }
    }
    
    //Maps url to upload view if get request
    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
    public ModelAndView hello()
            throws ServletException, IOException {

        return new ModelAndView("upload");
    }
    
    //maps url to decryption handler
    @RequestMapping(value = "/deCrypt", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView deCryptFileHandler(@RequestParam("file") MultipartFile file) 
    {
       
       file.getContentType();
        
        if (!file.isEmpty()) {
            try {
               
            img_conv.setOriginalImage(convert(file));
            ModelAndView deCrypt=new ModelAndView("deCrypt");
            String mess=img_conv.deCryptMessage(false);
            deCrypt.addObject("message",mess);
            
            return deCrypt;
           
                   
            } catch (Exception e) {
                return new ModelAndView("error");
            }
        } else {
                return new ModelAndView("error");
        }
    }
    
    
    
    
    
    
}