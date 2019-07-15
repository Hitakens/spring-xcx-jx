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
			limit = limit == null?1:limit;
			page = page == null?10:page;
			PageHelper.startPage(limit, page);
			
			if(pa!=null && (pa.getStr1()=="xckmy" || "xckmy".equals(pa.getStr1()))) {
				docs = tmxgMapper.selectTMall(pa.getStr1());
			}
			
			pageInfo = new PageInfo<>(docs);
			Integer total = (int) pageInfo.getTotal();
	        data = Layui.data(total,pageInfo.getList());
		} catch (Exception e) {
			log.info(e);
		}
		return data;
	}
	
}
