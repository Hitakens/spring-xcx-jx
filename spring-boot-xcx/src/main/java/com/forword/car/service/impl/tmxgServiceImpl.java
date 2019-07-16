package com.forword.car.service.impl;


import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forword.car.service.tmxgService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.forword.car.dao.tmxgMapper;
import com.forword.car.entity.Layui;
import com.forword.car.entity.ParaEntity;
import com.forword.car.entity.kmtmEntity;
@Service
public class tmxgServiceImpl implements tmxgService{
    public Logger log = Logger.getLogger(this.getClass());

	@Autowired
    private tmxgMapper tmxgMapper;

	@Override
	public Layui selectTMall(ParaEntity pa, Integer limit, Integer page) {
		Layui data =null;
		List<Map<String,Object>> docs=null;
		PageInfo<Map<String,Object>> pageInfo =null;
		try {
			limit = limit == null?50:limit;
			page = page == null?1:page;
			PageHelper.startPage(page,limit);
			
			if(pa!=null && (pa.getStr1()=="xckmy" || "xckmy".equals(pa.getStr1()))) {
				String p=pa.getStr2()==null?"":"%"+pa.getStr2()+"%";
				docs = tmxgMapper.selectTMall(p);
			}
			
			pageInfo = new PageInfo<>(docs);
			Integer total = (int) pageInfo.getTotal();
	        data = Layui.data(total,pageInfo.getList());
		} catch (Exception e) {
			log.info(e);
		}
		return data;
	}

	@Override
	public String insertKm(kmtmEntity pa) {
		String msg=null;
		try {
			if(pa!=null && (pa.getKmlx()=="xckmy" || "xckmy".equals(pa.getKmlx()))) {
				int i=tmxgMapper.insertKm(pa);
				if(i>0) {
					msg="修改成功！";
				}else {
					msg="修改失败";
				}
			}
		} catch (Exception e) {
			msg="修改失败";
			log.info(e);
		}
		return msg;
	}
	
}
