package com.douzone.mysite.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//@WebListener - 자동 등록
public class ContextLoaderListener implements ServletContextListener {

    public ContextLoaderListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent servletContextEvent)  { 
         // TODO Auto-generated method stub
       String contextConfigLocation = servletContextEvent.getServletContext().getInitParameter("ContextConfigLocation");
       
       System.out.println("Container Starts..." + contextConfigLocation);
    }
   
}