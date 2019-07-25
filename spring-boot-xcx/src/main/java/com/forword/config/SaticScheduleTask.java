package com.forword.config;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.forword.common.ParamConfig;
import com.forword.common.baiduyy.BaiduYyhc;
@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask implements InitializingBean {


	@SuppressWarnings("null")
	@Scheduled(cron = "0 0 1 1 * ?")
	// 或直接指定时间间隔，例如：5秒
	// @Scheduled(fixedRate=5000)
	private void configureTasks() {
		String authtok = BaiduYyhc.getAuthtok(ParamConfig.APIKEY, ParamConfig.SERCETKEY);
		if(authtok==null){
			authtok=ParamConfig.TOK;
		}
		ParamConfig.TOK=authtok;
		System.out.println("生成新的token成功"+ParamConfig.TOK);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.configureTasks();
	}

}
