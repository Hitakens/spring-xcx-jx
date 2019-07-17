package com.forword.car.service;

import com.forword.car.entity.Layui;
import com.forword.car.entity.ParaEntity;
import com.forword.car.entity.kmtmEntity;

public interface tmxgService {

	Layui selectTMall(ParaEntity pa, Integer limit, Integer page);

	String insertKm(kmtmEntity pa);

	String updatekmimg(ParaEntity pa);


}
