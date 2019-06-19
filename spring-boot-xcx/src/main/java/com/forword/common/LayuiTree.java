package com.forword.common;

import java.util.List;

public class LayuiTree {
	
	private Object id;
	
	private Object pid;
	
	private Object name;
	
	private String allName;
	
	private Object allId;
	
	private List<LayuiTree> children; 
	
	private boolean spread;
	
	private boolean isLeaf = true;
	
	public String getAllName() {
		return allName;
	}

	public void setAllName(String allName) {
		this.allName = allName;
	}

	public Object getAllId() {
		return allId;
	}

	public void setAllId(Object allId) {
		this.allId = allId;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Object getPid() {
		return pid;
	}

	public void setPid(Object pid) {
		this.pid = pid;
	}

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	public Object getName() {
		return name;
	}

	public void setName(Object name) {
		this.name = name;
	}

	public List<LayuiTree> getChildren() {
		return children;
	}

	public void setChildren(List<LayuiTree> children) {
		this.children = children;
	}

	public boolean isSpread() {
		return spread;
	}

	public void setSpread(boolean spread) {
		this.spread = spread;
	}
	
	
}
