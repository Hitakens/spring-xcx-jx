package com.forword.common.echart;

public class Links {
	
	private String source;
	private String target;
	private int weight;
	private String name;
	
	public Links(String source, String target, int weight, String name) {
		super();
		this.source = source;
		this.target = target;
		this.weight = weight;
		this.name = name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
    
}
