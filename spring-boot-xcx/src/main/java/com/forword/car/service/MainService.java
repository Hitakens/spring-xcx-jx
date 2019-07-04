package com.forword.car.service;

import com.forword.car.entity.ParaEntity;

public interface MainService {

	String getopenidisnull(String openid);

	String updateYhxx(String oppenid, String avatarUrl, String nickName,String sesionnid);

	String insertkm(ParaEntity pa);

	String insertYhxxyk(String oppenid, String avatarUrl, String nickName, String stringTojson);

	String glyLogin(ParaEntity pa);

	String randomKm(int n);


}
