package com.forword.car.service;

import java.util.List;
import java.util.Map;

import com.forword.car.entity.ParaEntity;

public interface xcService {

	List<Map<String, Object>> getKmydata(String pa,String tmlx);

	String scbt(String sclx, Integer uuid, String openid);

	String cwlx(String cwlx, Integer uuid, String openid);

	String iftmsc(String cwlx, Integer uuid, String openid);

	Map<String, Object> ctsc(String clx, String openid);


	List<Map<String, Object>> kmMnks(String kmj);

	List<Map<String, Object>> carkmdycs(String tmlx, String ymcs);

	List<Map<String, Object>> showcwsc(String lx, String openid,String kmlx);

	String deletebt(ParaEntity pa);

}
