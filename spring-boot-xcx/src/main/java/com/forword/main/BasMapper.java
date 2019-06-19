package com.forword.main;

/**
 * @ClassName: BasMapper 
 * @Description: 通用查询
 * @author: zqj
 * @date: 2019年6月4日 下午5:49:11 
 * @param <T>
 */
public interface BasMapper<T> {
	
    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer ssjgdm);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
	
}
