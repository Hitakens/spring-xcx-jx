package com.forword.car.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forword.car.dao.KtMapper;
import com.forword.car.service.KtService;
@Service
public class KtServiceImpl implements KtService{
	@Autowired
    private KtMapper ktMapper;

	@Override
	public List<Map<String, Object>> getKmydata(String pa) {
		List<Map<String, Object>> listData=null;
		if(pa=="1" || "1".equals(pa)){
			listData = ktMapper.getKmydata(201,300);
			for(int i=0;i<listData.size();i++){
				listData.get(i).put("id", i);
			}
		}
		return listData;
	}
}
