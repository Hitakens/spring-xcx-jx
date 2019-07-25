package com.forword.car.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 提供公共功能的前端
 * @ClassName: DownBrowserController 
 * @Description: TODO
 * @author: zqj
 * @date: 2017年11月23日 下午7:35:09
 */
@Controller
@RequestMapping(value = "/xz")
public class DownBrowserController {

	public Logger log = Logger.getLogger(DownBrowserController.class);
	
	/**
	 * 下载文件大小低于1.4G的文件
	 * @Title: download 
	 * @Description: TODO
	 * @param fwqlj
	 * @return
	 * @throws IOException
	 * @return: ResponseEntity<byte[]>
	 */
    @RequestMapping("/downbrowser1")    
    public ResponseEntity<byte[]> download(String fwqlj) throws IOException {
    	 //GggnService gggnService = RouteConsumerFactory.getConsumerInstance(GggnService.class);
         //String path = gggnService.getFwqlj(fwqlj);
		 HttpHeaders headers=null;
		 File file=null;
		if(fwqlj!=null){
			 file=new File("D:\\demo\\tzf.xlsx");  
			 headers= new HttpHeaders();    
		     String fileName=new String(file.getName().getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
		     headers.setContentDispositionFormData("attachment", fileName);   
		     headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
		}
       
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                                          headers, HttpStatus.CREATED);
    }  
    /**
     * 处理文件类型比较大的下载超过1.4G
     * @Title: download1 
     * @Description: TODO
     * @param request
     * @param response
     * @param fwqlj
     * @throws IOException
     * @return: void
     */
    @RequestMapping("/downbrowser")    
    public void download1(HttpServletRequest request,
            HttpServletResponse response,String fwqlj) throws IOException {
    	 //GggnService gggnService = RouteConsumerFactory.getConsumerInstance(GggnService.class);
         //String path1 = gggnService.getFwqlj(fwqlj);
       //获取网站部署路径(通过ServletContext对象)，用于确定下载文件位置，从而实现下载  
         //String path = request.getServletContext().getRealPath("/"); 
         //D:\demo\tzf.xlsx

    	if(fwqlj!=null){
    		File file = new File(fwqlj);  
            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型  
            response.setContentType("multipart/form-data");  
            //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)
            String file_name = URLEncoder.encode(file.getName(),"UTF-8");
            response.setHeader("Content-Disposition", "attachment;fileName="+file_name);
            ServletOutputStream out=null;  
            //通过文件路径获得File对象(假如此路径中有一个download的文件) 
         try {  
             FileInputStream inputStream = new FileInputStream(file);  
   
             //3.通过response获取ServletOutputStream对象(out)  
             out = response.getOutputStream();  
   
             int b = 0;  
             byte[] buffer = new byte[1024];  
             b = inputStream.read(buffer); 
             while (b != -1){    
                 //4.写到输出流(out)中  
                 out.write(buffer,0,b);  
                 b = inputStream.read(buffer);
             }
             if(inputStream!=null){
                 inputStream.close();
             }
         } catch (IOException e) {
             e.printStackTrace();  
         }finally {
			if(out!=null){
				out.close();  
	            out.flush(); 
			}
		} 
    	}
    }

}