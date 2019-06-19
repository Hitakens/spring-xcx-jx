package com.forword.common;

/**
 * 表信息
 */
public class TableInfo {
	
	private String tableschema;
	
	private String tablename;
	
	private String columnname;
	
	private String datatype;

	public String getTableschema() {
		return tableschema;
	}

	public void setTableschema(String tableschema) {
		this.tableschema = tableschema;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getColumnname() {
		return columnname;
	}

	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	
}
