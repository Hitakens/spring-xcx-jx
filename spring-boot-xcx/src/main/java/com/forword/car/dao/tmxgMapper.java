package com.forword.car.dao;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.forword.car.entity.kmtmEntity;

@Repository
public interface tmxgMapper {


	List<Map<String, Object>> selectTMall(String tm);

	int insertKm(kmtmEntity pa);

}
