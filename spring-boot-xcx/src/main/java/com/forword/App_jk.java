package com.forword;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * springboot启动类
 * @author forward
 */
@SpringBootApplication
@EnableTransactionManagement// 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@MapperScan("com.forword.*.dao")
public class App_jk extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(App_jk.class, args);
        System.out.println("程序启动完毕！！！");
        System.out.println("http://127.0.0.1:8080");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App_jk.class);
	}

}
