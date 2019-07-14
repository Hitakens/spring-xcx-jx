package com.forword.car.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.forword.car.entity.ParaEntity;

@Repository
public interface xcMapper {


	String selectScdtByuuidandsclx(ParaEntity pr);

	void insertScdt(ParaEntity pr);

	List<Map<String, Object>> getKmydata(ParaEntity pr);

	String selectbtcwByuuidandsclx(ParaEntity pr);

	void inserttkcw(ParaEntity pr);

	void deleteScdtByuuidandsclx(ParaEntity pr);

	Map<String, Object> selectKmyAndKmsScCount(String openid);

	Map<String, Object> selectKmyAndKmsCtCount(String openid);


	List<Map<String, Object>> kmyMnks();

	List<Map<String, Object>> getKmyDycsdata(ParaEntity pr);

	List<Map<String, Object>> getkmySclist(ParaEntity pa);

	List<Map<String, Object>> getkmyCwlist(ParaEntity pa);
	List<Map<String, Object>> getkmsSclist(ParaEntity pa);

	List<Map<String, Object>> getkmsCwlist(ParaEntity pa);

	int deleteByOPenidSc(ParaEntity pa);

	int deleteByOPenidCw(ParaEntity pa);

	List<Map<String, Object>> getKmsDycsdata(ParaEntity pr);

	List<Map<String, Object>> getKmsdata(ParaEntity pr);

	List<Map<String, Object>> kmsMnks();


}
