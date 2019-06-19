package com.forword.common;

import java.util.List;

public class EchartsTreeUtils {
	
	private String name;
	
	private String value;
	
	private String category;
	
	private List<EchartsTreeUtils> children;
	
	private TreeitemStyle itemStyle;

	public TreeitemStyle getItemStyle() {
		return itemStyle;
	}

	public void setItemStyle(TreeitemStyle itemStyle) {
		this.itemStyle = itemStyle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<EchartsTreeUtils> getChildren() {
		return children;
	}

	public void setChildren(List<EchartsTreeUtils> children) {
		this.children = children;
	}
	
	
}
