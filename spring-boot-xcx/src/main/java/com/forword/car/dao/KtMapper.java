package com.forword.car.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KtMapper {

	List<Map<String, Object>> getKmydata(@Param(value = "starNum")int starNum,
			@Param(value = "endNum") int endNum);

	String selectScdtByuuidandsclx(@Param(value = "sclx")String sclx,
			@Param(value = "uuid") Integer uuid);

	void insertScdt(String sclx, Integer uuid, String openid);


}
