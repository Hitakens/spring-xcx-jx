package com.forword.car.dao;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface tmxgMapper {


	List<Map<String, Object>> selectTMall(String tm);

}
