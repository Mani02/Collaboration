package com.niit.CollaborationRestServices.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("root called");
         return new Class[]{WebConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
         // TODO Auto-generated method stub
         return null;
    }

    @Override
    protected String[] getServletMappings() {
        
         return new String[]{"/"};
    }

}
