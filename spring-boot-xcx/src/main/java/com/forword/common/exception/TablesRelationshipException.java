package com.forword.common.exception;

/**
 * 表间关系配置异常
 *
 */
public class TablesRelationshipException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TablesRelationshipException() {
	}

	public TablesRelationshipException(String message) {
		
		super(message);
	}


}
