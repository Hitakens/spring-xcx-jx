package com.forword.car.service;

import java.util.List;
import java.util.Map;

public interface KtService {

	List<Map<String, Object>> getKmydata(String pa,String tmlx);

	String scbt(String sclx, Integer uuid, String openid);

	String cwlx(String cwlx, Integer uuid, String openid);

	String iftmsc(String cwlx, Integer uuid, String openid);

	Map<String, Object> ctsc(String clx, String openid);

	Map<String,Object> selectOpenidBysessionid(String sid);

}
