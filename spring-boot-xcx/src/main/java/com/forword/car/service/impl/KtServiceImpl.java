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

	@Override
	public String scbt(String sclx, Integer uuid, String openid) {
		String msg="";
		try {
			String suuid= ktMapper.selectScdtByuuidandsclx(sclx,uuid);
			if(suuid!=null) {
				msg="本题已收藏!";
			}else {
				ktMapper.insertScdt(sclx,uuid,openid);
			}
		} catch (Exception e) {
			msg="网络延迟!";
			e.getMessage();
		}
		
		return null;
	}
}
