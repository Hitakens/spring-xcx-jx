package com.forword.car.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.forword.car.entity.Layui;
import com.forword.car.entity.ParaEntity;
import com.forword.car.entity.kmtmEntity;
import com.forword.car.entity.userEntity;
import com.forword.car.service.tmxgService;
import com.forword.common.UUIDGenerator;
import com.forword.main.BasController;

@Controller
@RequestMapping("tm")
public class tmxgController extends BasController {
	public Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private tmxgService tmxgService;

	@RequestMapping("/selectTMall")
	@ResponseBody
	public Layui selectTMall(ParaEntity pa, Integer limit, Integer page) {
		Layui selecttm=null;
		try {
			selecttm=tmxgService.selectTMall(pa,limit,page);
		} catch (Exception e) {
			log.error("查询题目错误", e.fillInStackTrace());
		}
		return selecttm;
	}
	//insertKm
	@RequestMapping("/insertKm")
	@ResponseBody
	public String insertKm(kmtmEntity pa) {
		String selecttm=null;
		try {
			selecttm=tmxgService.insertKm(pa);
		} catch (Exception e) {
			log.error("修改错误", e.fillInStackTrace());
		}
		return selecttm;
	}
	/**
	 * 提交报销
	 * 
	 * @param request
	 * @param bxen
	 * @return
	 */
	@PostMapping("uploadtp")
	@ResponseBody
	public JSONObject  multiUpload(HttpServletRequest request,ParaEntity pa) {
		String msg = "";
		JSONObject resObj = new JSONObject();
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		// D:/develop/file   "/home/apache-tomcat-8.5.40/webapps/develop/"+pa.getStr2()+"/";

		if (files != null && files.size() > 0) {
			String filePath = null;
			if(pa!=null){
				filePath= "/home/apache-tomcat-8.5.40/webapps/develop/"+pa.getStr2()+"/";
			}
			File f = new File(filePath);
			if (!f.exists()) {
				f.mkdirs();
			}
			for (int i = 0; i < files.size(); i++) {
				MultipartFile file = files.get(i);
				if (file.isEmpty()) {
					continue;
				}
				String fileName = file.getOriginalFilename();
				// 获取文件后缀
				String uuidName = UUIDGenerator.getImgUUID() + fileName;
				File dest = new File(filePath + uuidName);
				try {
					file.transferTo(dest);
					pa.setStr3("https://www.jaiy.online/develop/"+pa.getStr2()+"/" + uuidName);
					msg=tmxgService.updatekmimg(pa);
					
					log.info("第" + (i + 1) + "个文件上传成功" + filePath + uuidName);

				} catch (IOException e) {
					log.error("上传第" + (i++) + "个文件失败", e);
				}
			}
		} else {
			pa.setStr3("无");
			msg=tmxgService.updatekmimg(pa);
		}
		resObj.put("msg", msg);
		return resObj;
	}
	/**
	 * 查询用户信息
	 * @param str
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping("/selectUser")
	@ResponseBody
	public Layui selectUser(ParaEntity pa,Integer limit, Integer page) {
		Layui selecttm=null;
		try {
			selecttm= tmxgService.selectUserByusername(pa,limit,page);
		} catch (Exception e) {
			log.error("查询用户信息出错", e.fillInStackTrace());
		}
		return selecttm;
	}
	/**
	 * 查询前端用户信息
	 * @param str
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping("/selectqdUser")
	@ResponseBody
	public Layui selectqdUser(ParaEntity pa,Integer limit, Integer page) {
		Layui selecttm=null;
		try {
			selecttm= tmxgService.selectUserqdByusername(pa,limit,page);
		} catch (Exception e) {
			log.error("查询用户信息出错", e.fillInStackTrace());
		}
		return selecttm;
	}
	/**
	 * 更改后台用户的信息
	 * @param pa
	 * @return
	 */
	@RequestMapping("/updateGlyzt")
	@ResponseBody
	public String updateGlyzt(userEntity pa) {
		String selecttm=null;
		try {
			selecttm=tmxgService.updateGlyzt(pa);
		} catch (Exception e) {
			log.error("修改错误", e.fillInStackTrace());
		}
		return selecttm;
	}
	/**
	 * 增加后台用户
	 * @param pa
	 * @return
	 */
	@RequestMapping("/insertUser")
	@ResponseBody
	public String insertUser(userEntity pa) {
		String selecttm=null;
		try {
			selecttm=tmxgService.insertUser(pa);
		} catch (Exception e) {
			log.error("修改错误", e.fillInStackTrace());
		}
		return selecttm;
	}

	/**
	 * 删除后台用户信息
	 * @param pa
	 * @return
	 */
	@RequestMapping("/deleteByUserName")
	@ResponseBody
	public String deleteByUserName(String username) {
		String selecttm=null;
		try {
			selecttm=tmxgService.deleteByUserName(username);
		} catch (Exception e) {
			log.error("修改错误", e.fillInStackTrace());
		}
		return selecttm;
	}
	//updateYhxxbyopenid
	
	/**
	 * 更改用户信息的状态
	 * @param pa
	 * @return
	 */
	@RequestMapping("/updateYhxxbyopenid")
	@ResponseBody
	public String updateYhxxbyopenid(String openid,String yxbz) {
		String selecttm=null;
		try {
			selecttm=tmxgService.updateYhxxbyopenid(openid,yxbz);
		} catch (Exception e) {
			log.error("修改错误", e.fillInStackTrace());
		}
		return selecttm;
	}
	/**
	 * 查询前端用户信息
	 * @param str
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping("/selectUserKm")
	@ResponseBody
	public Layui selectUserKm(ParaEntity pa,Integer limit, Integer page) {
		Layui selecttm=null;
		try {
			selecttm= tmxgService.selectUserKm(pa,limit,page);
		} catch (Exception e) {
			log.error("查询用户信息出错", e.fillInStackTrace());
		}
		return selecttm;
	}
	
	/**
	 * 删除后台用户信息
	 * @param pa
	 * @return
	 */
	@RequestMapping("/deleteOpenByKm")
	@ResponseBody
	public String deleteOpenByKm(String min_key) {
		String selecttm=null;
		try {
			selecttm=tmxgService.deleteOpenByKm(min_key);
		} catch (Exception e) {
			log.error("修改错误", e.fillInStackTrace());
		}
		return selecttm;
	}
}
