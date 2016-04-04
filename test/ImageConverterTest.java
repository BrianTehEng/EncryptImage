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
 * @author swagbito
 */
public class ImageConverterTest {
    
    public ImageConverterTest() {
    }
    
    
    @Test
    public void testLoadImage(){
       
    ImageConverter img_conv=new ImageConverter();
  
    //img_conv.setFilePath("/home/swagbito/Documents/imageDIR/lena1.png");
    img_conv.loadImage("/home/swagbito/Documents/imageDIR/lena1.png");
    img_conv.setMessage("HelloWorldDDD");
    img_conv.convertImage();
    img_conv.getFileName();
   
   //System.out.println(img_conv.deCryptMessage(true));
    
   System.out.println(img_conv.getBlockValue(400, 0, 45, true));
   img_conv.adjustBlockValue(30, 45, 400, 0);
   System.out.println(img_conv.getBlockValue(400, 0, 45, true));
  
    //BufferedImage x=img_conv.getOriginalImage();
    //System.out.println(x.getWidth());
    
     JLabel picLabel = new JLabel(new ImageIcon(img_conv.getOriginalImage()));
     JPanel panel =new JPanel();
     JFrame frame=new JFrame();
     picLabel.setBounds(0,0,600,500);
     panel.add(picLabel);
     
     
     frame.add(panel);
     frame.setBounds(0, 0, 600, 600);
     frame.setVisible((true));
    }
    
}
