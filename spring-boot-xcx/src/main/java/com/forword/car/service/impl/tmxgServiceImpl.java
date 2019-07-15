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
			PageHelper.startPage(limit, page);
			docs = tmxgMapper.selectZbyMapJg(pa);
			pageInfo = new PageInfo<>(docs);
			Integer total = (int) pageInfo.getTotal();
	        data = Layui.data(total,pageInfo.getList());
		} catch (Exception e) {
			log.info(e);
		}
		return data;
	}
	
}
