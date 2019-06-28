package com.forword.car.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MainMapper {

	String getopenidisnull(String openid);


	void updateYhxx(@Param(value = "oppenid") String oppenid, 
			@Param(value = "avatarUrl")String avatarUrl,@Param(value = "sesionnid") String sesionnid,
			@Param(value = "nickName")String nickName);
	
}