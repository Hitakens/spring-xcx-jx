package com.forword.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class Reault implements Serializable {

	private static final long serialVersionUID = 1L;
	private int total = 0;
	private int rows = 10;
	private int page = 1;
	private List<Map<String, Object>> list;
	
	public int getTotal() {
	
		return total;
	}
	
	public void setTotal(int total) {
	
		this.total = total;
	}
	
	public int getRows() {
	
		return rows;
	}
	
	public void setRows(int rows) {
	
		this.rows = rows;
	}
	
	public int getPage() {
	
		return page;
	}
	
	public void setPage(int page) {
	
		this.page = page;
	}
	
	public List<Map<String, Object>> getList() {
	
		return list;
	}
	
	public void setList(List<Map<String, Object>> list) {
	
		this.list = list;
	}
	
	
}