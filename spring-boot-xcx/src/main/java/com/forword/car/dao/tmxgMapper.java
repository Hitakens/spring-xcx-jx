package com.forword.car.dao;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.forword.car.entity.ParaEntity;
import com.forword.car.entity.kmtmEntity;

@Repository
public interface tmxgMapper {

  //小车
	List<Map<String, Object>> selectxckmy(String tm);

	int insertxckmy(kmtmEntity pa);

	List<Map<String, Object>> selectxckms(String p);
	
	int insertxckms(kmtmEntity pa);
	//货车
	List<Map<String, Object>> selecthckmy(String tm);

	int inserthckmy(kmtmEntity pa);

	List<Map<String, Object>> selecthckms(String p);
	
	int inserthckms(kmtmEntity pa);
	//客车
	List<Map<String, Object>> selectkckmy(String tm);

	int insertkckmy(kmtmEntity pa);

	List<Map<String, Object>> selectkckms(String p);
	
	int insertkckms(kmtmEntity pa);

	int updatekmimgxckmy(ParaEntity pa);
	int updatekmimgxckms(ParaEntity pa);
	int updatekmimghckmy(ParaEntity pa);
	int updatekmimghckms(ParaEntity pa);
	int updatekmimgkckmy(ParaEntity pa);
	int updatekmimgkckms(ParaEntity pa);

}
