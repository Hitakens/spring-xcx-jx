package com.forword.common.echart;

import java.util.List;
/**
 * 力向图实体
 * @author mac
 *
 */
public class ForceEntity {

	private List<Nodes> nodes;
	private List<Links> links;

	public List<Nodes> getNodes() {
		return nodes;
	}

	public void setNodes(List<Nodes> nodes) {
		this.nodes = nodes;
	}

	public List<Links> getLinks() {
		return links;
	}

	public void setLinks(List<Links> links) {
		this.links = links;
	}

}
