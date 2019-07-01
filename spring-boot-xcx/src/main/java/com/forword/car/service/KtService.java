package com.forword.car.service;

import java.util.List;
import java.util.Map;

public interface KtService {

	List<Map<String, Object>> getKmydata(String pa);

	String scbt(String sclx, Integer uuid, String openid);

}
