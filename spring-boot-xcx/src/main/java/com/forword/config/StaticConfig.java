package com.forword.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.github.pagehelper.PageHelper;

@Configuration
public class StaticConfig extends WebMvcConfigurerAdapter{

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有/static/** 访问都映射到classpath:/static/ 目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
	@Bean
	public PageHelper pageHelper() {
	    PageHelper pageHelper = new PageHelper();
	    Properties p = new Properties();
	    p.setProperty("offsetAsPageNum", "true");
	    p.setProperty("rowBoundsWithCount", "true");
	    p.setProperty("reasonable", "true");
	    p.setProperty("dialect", "oracle");
	    p.setProperty("supportMethodsArguments", "false");
	     p.setProperty("pageSizeZero", "true");
	    pageHelper.setProperties(p);
	    return pageHelper;
	}
	
}
