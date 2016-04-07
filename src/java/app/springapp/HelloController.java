package app.springapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CodeFletcher
 */
import org.springframework.stereotype.Controller;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMapping;

//This class controls the home page url of this application
@Controller
public class HelloController  {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping("/hello")
    public ModelAndView hello()
            throws ServletException, IOException {

        logger.info("Returning hello view");

        return new ModelAndView("hello");
    }

}