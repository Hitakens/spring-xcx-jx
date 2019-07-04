package com.forword.car.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.forword.car.entity.ParaEntity;


@Repository
public interface MainMapper {

	String getopenidisnull(String openid);


	void updateYhxx(@Param(value = "oppenid") String oppenid, 
			@Param(value = "avatarUrl")String avatarUrl,
			@Param(value = "nickName")String nickName,
			@Param(value = "sesionnid") String sesionnid
			);


	String selectOpen_mybyKey(String str5);


	int insertYhxx(ParaEntity p);


	void deleteOpen_mybyKey(String minKey);


	String selectYhxxyk(String oppenid);


	void insertYhxxyk(ParaEntity p);


	void deleteYhxxyk(String str1);


	String getopenidyk(String openid);


	Map<String,Object> glyLogin(String str1);
	
}