package com.forword.common;

import java.util.List;

public class Ztree {
	
	private Object id;
	
	private Object pId;
	
	private String name;
	
	private Boolean open;
	
	private List<Ztree> children;
	
    public String iconOpen = "/static/js/ztree/img/tree_open.png";
    
    public String iconClose = "/static/js/ztree/img/tree_close.png";
    
    public String icon = "/static/js/ztree/img/tree_file.png";
	
	public Object getpId() {
		return pId;
	}

	public void setpId(Object pId) {
		this.pId = pId;
	}

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public List<Ztree> getChildren() {
		return children;
	}

	public void setChildren(List<Ztree> children) {
		this.children = children;
	}

	public String getIconOpen() {
		return iconOpen;
	}

	public void setIconOpen(String iconOpen) {
		this.iconOpen = iconOpen;
	}

	public String getIconClose() {
		return iconClose;
	}

	public void setIconClose(String iconClose) {
		this.iconClose = iconClose;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
