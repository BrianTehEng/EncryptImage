/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.web.servlet.ModelAndView;


import app.springapp.HelloController;

/**
 *
 * @author swagbito
 */
public class HelloControllerTest {
    
    public HelloControllerTest() {
    }
    
   

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void Hello() throws Exception {
        
        HelloController controller = new HelloController();
        ModelAndView modelAndView = controller.hello();
        assertEquals("hello.jsp", modelAndView.getViewName());
        
    }
}
