package com.niit.CollaborationRestServices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.niit")
public class WebConfig {
    
	@Bean
	public ViewResolver viewResolver() {
		
       // UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		System.out.println("Resolver");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		System.out.println(viewResolver.getRedirectHosts());

		return viewResolver;
	}
    
 
}