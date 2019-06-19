package com.forword.main;
/**
 * @ClassName: BasService 
 * @Description: TODO
 * @author: zqj
 * @date: 2019年6月4日 下午5:48:37 
 * @param <T>
 */
public interface BasService<T> {

	public void save(T t) throws Exception;
	
	public void delete(Integer id) throws Exception;
	
	public T get(Integer id)  ;
	
	public void update(T t)  throws Exception;
	
}
