package com.forword.main;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 基础Controller
 * @author forward
 */
@Controller
@RequestMapping("/basController")
public class BasController {
	
	private Logger log = LoggerFactory.getLogger(BasController.class);
	
    public void writeJson(Object obj,HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.print(JSON.toJSONString(obj,SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat));
        }catch(IOException e){
        	log.error("异常",e); e.printStackTrace();
        } finally{
            out.flush();
            out.close();
        }
    }
    
    public String getUserName(){
    	return "11";
    }
}