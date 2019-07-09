package com.forword.car.service;

import java.util.Map;

import com.forword.car.entity.ParaEntity;

public interface MainService {

	String getopenidisnull(String openid);

	String updateYhxx(String oppenid, String avatarUrl, String nickName,String sesionnid);

	String insertkm(ParaEntity pa);

	String insertYhxxyk(String oppenid, String avatarUrl, String nickName, String stringTojson);

	String glyLogin(ParaEntity pa);

	String randomKm(int n);

	String submitinsert(ParaEntity pa);

	Map<String, Object> selectOpenidBysessionid(String sid);


}
