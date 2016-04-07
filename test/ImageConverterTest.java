/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import app.springapp.ImageConverter;

/**
 *
 * @author CodeFletcher
 */
public class ImageConverterTest {
    
    public ImageConverterTest() {
    }
    
    ImageConverter img_conv=new ImageConverter();
    
    @Test
    public void testLoadImage(){
       
    
    img_conv.loadImage("/home/swagbito/NetBeansProjects/springapp/test/finaltest.png");
    
    BufferedImage im=img_conv.getOriginalImage();
    boolean load;
    if(im!=null){
         load=true;
    }else{
        load=false;
    }
    
    assertEquals(load,true);
       
    }
    
    @Test
    public void testGetFileNameFromPath(){
        
        String s="/home/swagbito/NetBeansProjects/springapp/test/finaltest.png";
        
        String name=img_conv.getFileNameFromPath(s);
        
        assertEquals(name,"finaltest.png");
        
    }
    
    @Test
    public void testGetMaxEncryptionSize(){
        
        testLoadImage();
        
              
        assertEquals(img_conv.getMaxEncryptionSize(),1999);
    }
    
    @Test
    public void testGetXY(){
        
        testLoadImage();
        int x=0,y=0,n=45;
        
        int x2=img_conv.getX(x, y, n);
        int y2=img_conv.getY(x, y, n);
        assertEquals(x2,44);
        assertEquals(y2,0);
        
        //test boundary image width is 300;
        x=295; y=104; n=45;
        x2=img_conv.getX(x, y, n);
        y2=img_conv.getY(x, y, n);
        
        assertEquals(x2,39);
        assertEquals(y2,105);
        
    }
    
    @Test
    public void testGetBlockValue(){
        
        testLoadImage();
        int x=0,y=0,n=45;
        
        int block=img_conv.getBlockValue(x, y, n, false);
              
        assertEquals(block,72);
                
    }
    
     @Test 
    public void testAdjustBlockValue(){
        
        testLoadImage();
        int x=0,y=0,n=45;
              
        img_conv.copyOriginalImage();
        img_conv.adjustBlockValue(100, n, x, y);
        
        int block=img_conv.getBlockValue(x, y, n, true);
        assertEquals(block,100);
        
    }
    
    @Test
    public void testDeCrypt(){
        
        testLoadImage();
        img_conv.deCryptMessage(false);
        
        assertEquals(img_conv.getMessage(),"Hello I'm a plant. Thats pretty much it. I'm also green... I like the sunshine too. Well thats enough about me.");
        
    }
    
    @Test
    public void testEncrypt(){
        
      img_conv.loadImage("/home/swagbito/NetBeansProjects/springapp/test/finaltest_encrypt.png");
      img_conv.setMessage("Hello are you working?");
      img_conv.convertImage();
      
      assertEquals(img_conv.deCryptMessage(true),"Hello are you working?");
        
    }
    
}
