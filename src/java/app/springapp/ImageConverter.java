/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.springapp;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;
/**
 *
 * @author swagbito
 */
@Component
@Scope("session")
public class ImageConverter  implements java.io.Serializable {
    
    private
    String file_name=null,message=null;
    BufferedImage org_image,new_image;
    
    byte[] org_pixels, new_pixels;
    
    
    
    public void setFileName(String fileName){
        
        file_name=fileName;
    }
    
    public String getFileName(){
        
        return file_name;
    }
    
    
    public String getFileNameFromPath(String path){
        
        Pattern pattern = Pattern.compile("[^/]*$");
        Matcher matcher = pattern.matcher(path);
        if (matcher.find())
        {
         return matcher.group(0);
        }
        
      return "couldnotread";
    }
    
    
    
       
    public String getMessage(){
        
        return message;
    }
    
    public void setMessage(String messageForEncryption){
        message=messageForEncryption;
    }
    
    
    public BufferedImage getOriginalImage(){
        
        return org_image;
        
    }
    
    public void setOriginalImage(BufferedImage im){
        
        org_image=im;
    }
    
     public BufferedImage getConvertedImage(){
        
        return new_image;
    }
    
     
    public void loadImage(String filepath){
        
        try{
        
        org_image=ImageIO.read(new File(filepath));
        }
        catch(IOException e){
            
            System.out.println("Could not read image!");
        }
    }
    
     
    public void saveImage(String filepath){
        
        try{
        ImageIO.write(new_image, "png", new File(filepath+"C"));
        }
        catch(IOException e){
            
            System.out.println("Could not write image!");
        }
        
    }
    
    //Returns the maximum number of characters available for encyprtion
    public int getMaxEncryptionSize(){
        
        int n;
        
        n=org_image.getHeight()*org_image.getWidth()/45;
        
        return n-1;
    }
    
    
    
    public void convertImage(){
            
        new_image=deepCopy(org_image);
        
        char[] bytes=message.toCharArray();
        int j=0,k=0,dummy_j=0,dummy_k=0;
        
        
        
        for(int i=0;i<bytes.length;i++){
            
            adjustBlockValue(bytes[i],45,dummy_j,dummy_k);
           
            
            j=getX(dummy_j,dummy_k,46);
            k=getY(dummy_j,dummy_k,46);
            dummy_j=j;
            dummy_k=k;
            
            
        }
        
        //Encode Last Block with Zero
        adjustBlockValue(0,45,j,k);
            
          
    }
    
    public String deCryptMessage(boolean flag){
       
        BufferedImage im;
        
        if(flag){
            im=new_image;
        }else{
            im=org_image;
        }
        
       int x=0,y=0;
       int i=getBlockValue(x,y,45,flag); 
       
       StringBuilder m=new StringBuilder();
       
       int dummy_x,dummy_y;
       
       while(i!=0){
           m.append((char)i);
           
           dummy_x=x;
           dummy_y=y;
           x=getX(dummy_x,dummy_y,46);
           y=getY(dummy_x,dummy_y,46);
           i=getBlockValue(x,y,45,flag);
           
       }
       
       
       return m.toString();
        
    }
    
    
    
    public int getX(int x, int y,int n){
        
         return (x+n-1)%org_image.getWidth();
    }
    
     public int getY(int x, int y,int n){
        
         if(x+n-1<org_image.getWidth()){
             return y;
         }
         else{
             return y+1;
         }
    }
    
    
    public void adjustBlockValue(int desired_value,int pixel_number,int x,int y){
        
       
     
       
       int current_value=getBlockValue(x,y,pixel_number,false);
       
       int bits=desired_value-current_value;
       
         int i=x;
         int j=y;
     while(bits >0){
         
         int rgb=org_image.getRGB(i, j);
         
         int alpha=(rgb >>24)& 0xFF;
         int red= (rgb >>16) & 0xFF; 
         int green=(rgb >> 8)& 0xFF; 
         int blue=rgb & 0xFF;
         
         if(red%2 <1 && red<255 ){
             red++;
             bits--;
         }
         
         if(green%2 <1 && green<255 && bits>0){
             green++;
             bits--;
         }
         if(blue%2 <1 && blue<255 && bits>0){
             blue++;
             bits--;
         }
       
         int rgb2=alpha;
         
             rgb2=(rgb2 <<8)+red;
             rgb2=(rgb2 <<8)+green;
             rgb2=(rgb2 <<8)+blue;
             
             new_image.setRGB(i, j, rgb2);
             
             if(i+1<org_image.getWidth()){
             i=i+1;
             }
             else{
                 i=0;
                 j++;
             }
                        
     }
     
      while(bits <0){
         
         int rgb=org_image.getRGB(i, j);
         
         int alpha= (rgb >>24) & 0xFF;
         int red= (rgb >>16) & 0xFF; 
         int green=(rgb >> 8)& 0xFF; 
         int blue=rgb & 0xFF;
         
         if(red%2 >0 && red>2){
             red--;
             bits++;
         }
         
         if(green%2 >0 && green>2 && bits<0){
             green--;
             bits++;
         }
         if(blue%2 >0 && blue>2 && bits<0){
             blue--;
             bits++;
         }
       
         int rgb2=alpha;
         
             rgb2=(rgb2 <<8)+red;
             rgb2=(rgb2 <<8)+green;
             rgb2=(rgb2 <<8)+blue;
             new_image.setRGB(i, j, rgb2);
             
             if(i+1<org_image.getWidth()){
             i=i+1;
             }
             else{
                 i=0;
                 j++;
             }
                        
     }
       
        
    }
    
    
    
    
    BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
}
    
     
      
    //Between two pixels
    public int getBlockValue(int x1,int y1,int n,boolean flag){
            
        BufferedImage im;
        if(flag){
            im=new_image;
            
        }
        else{
            im=org_image;
        }
        
        int x2=getX(x1,y1,n);
        int y2=getY(x1,y1,n);
        
        int sum=0;    
        int i=x1,j=y1;
        
        while(i!=x2 || j!=y2){
                
                int rgb=im.getRGB(i, j);
                Color c=new Color(rgb);
                sum+=c.getRed()%2;
                sum+=c.getBlue()%2;
                sum+=c.getGreen()%2;
                
                if(i+1<org_image.getWidth()){
                   i=i+1; 
                    
                }else{
                    j++;
                    i=0;
                }
                
        }
        
         int rgb=im.getRGB(x2, y2);
                Color c=new Color(rgb);
                sum+=c.getRed()%2;
                sum+=c.getBlue()%2;
                sum+=c.getGreen()%2;
                   
        return sum;
        
    }
    
}
