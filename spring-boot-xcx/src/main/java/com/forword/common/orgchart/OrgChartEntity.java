package com.forword.common.orgchart;

import java.util.List;

public class OrgChartEntity {

	private String id;
	private String name;
	private String title;
	private String relationship;
	private Integer uuid;
	private String type;
	private String edit;
	private List<OrgChartEntity> children;

	private String ptitle;//父级值
	
	private String tip;//提示内容
	
	private String ysf;//运算符
	
	public String getYsf() {
		return ysf;
	}

	public void setYsf(String ysf) {
		this.ysf = ysf;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public String getEdit() {
		return edit;
	}

	public void setEdit(String edit) {
		this.edit = edit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getUuid() {
		return uuid;
	}

	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public List<OrgChartEntity> getChildren() {
		return children;
	}

	public void setChildren(List<OrgChartEntity> children) {
		this.children = children;
	}

}
