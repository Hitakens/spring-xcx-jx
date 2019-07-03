package com.forword.car.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.forword.car.entity.ParaEntity;

@Repository
public interface KtMapper {


	String selectScdtByuuidandsclx(ParaEntity pr);

	void insertScdt(ParaEntity pr);

	List<Map<String, Object>> getKmydata(ParaEntity pr);

	String selectbtcwByuuidandsclx(ParaEntity pr);

	void inserttkcw(ParaEntity pr);

	void deleteScdtByuuidandsclx(ParaEntity pr);

	Map<String, Object> selectKmyAndKmsScCount(String openid);

	Map<String, Object> selectKmyAndKmsCtCount(String openid);

	Map<String,Object> selectOpenidBysessionid(String sid);


}
