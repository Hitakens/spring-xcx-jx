package com.forword.car.service;

import com.forword.car.entity.Layui;
import com.forword.car.entity.ParaEntity;
import com.forword.car.entity.kmtmEntity;
import com.forword.car.entity.userEntity;

public interface tmxgService {

	Layui selectTMall(ParaEntity pa, Integer limit, Integer page);

	String insertKm(kmtmEntity pa);

	String updatekmimg(ParaEntity pa);
	
	Layui selectUserByusername(ParaEntity pa, Integer limit, Integer page);
	
	Layui selectUserqdByusername(ParaEntity pa, Integer limit, Integer page);
	
	String updateGlyzt(userEntity pa);
	
	String insertUser(userEntity pa);
	
	String deleteByUserName(String pa);
	String updateYhxxbyopenid(String opneid,String yxbz);
	
	Layui selectUserKm(ParaEntity pa, Integer limit, Integer page);
	
	String deleteOpenByKm(String min_key);



}
