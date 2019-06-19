package com.forword.common;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.Join;
import net.sf.jsqlparser.statement.select.OrderByElement;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectItem;
import net.sf.jsqlparser.statement.update.Update;

public class SqlPaserTools {

	/**
	 * 判断sql语法是否正确
	 * @param sql
	 * @return
	 */
	public static String judge_type(String sql) {  
		@SuppressWarnings("unused")
		Statement statement = null;
	    try {  
	        statement = (Statement) CCJSqlParserUtil.parse(sql);  
	    } catch (JSQLParserException e) {  
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
	        e.printStackTrace(new PrintStream(baos));  
	        String exception = baos.toString();  
	        String regEx = "Encountered(.*)";  
	        Pattern pat = Pattern.compile(regEx);  
	        Matcher mat = pat.matcher(exception);  
	        while (mat.find()) {  
	            exception = mat.group(1);  
	        }  
	        String line = "";  
	        String regEx2 = "line (.*),";  
	        pat = Pattern.compile(regEx2);  
	        mat = pat.matcher(exception);  
	        while (mat.find()) {  
	            line = mat.group(1);  
	        }  
	        int line_num = Integer.valueOf(line).intValue();  
	        int indexofcolumn = exception.indexOf("column");  
	        String errornumber = exception.substring(indexofcolumn + 7,  
	                exception.length() - 1);  
	        int error_num = Integer.valueOf(errornumber).intValue();  
	        System.out.println(error_num);  
	        String ERROR_location = "";  
	        if (error_num != 1) {  
	            String sql_sub = sql.substring(0, error_num - 2); // 发生错误位置前面的字符串  
	            // 错误信息单词往往处于错误位置的前一个地方单词  
	            // 获取错误位置两个前面两个空格之间的单词，并保存  
	            sql_sub = new StringBuilder(sql_sub).reverse().toString();  
	            int indexofspace = sql_sub.indexOf(" ");  
	            String sql_error = sql_sub.substring(0, indexofspace);  
	            sql_error = new StringBuilder(sql_error).reverse().toString();  
	            ERROR_location = "\"" + sql_error + "\"" + " at line "  
	                    + line_num + " at column " + error_num;  
	        } else {  
	            int indexofspace = sql.indexOf(" ");  
	            String sql_error = sql.substring(0, indexofspace);  
	            ERROR_location = "\"" + sql_error + "\"" + " at line "  
	                    + line_num + " at column " + error_num;  
	        }  
	        return ERROR_location; // 错误信息的返回  
	    }  
	    String result = "correct";  
	    return result; // Jsql可以解析，返回correct  
	}
	
	/**
	 * 获取sql列名
	 * @param sql
	 * @return
	 * @throws JSQLParserException
	 */
	public static List<String> test_select_items(String sql)  
	            throws JSQLParserException {  
	        CCJSqlParserManager parserManager = new CCJSqlParserManager();  
	        Select select = (Select) parserManager.parse(new StringReader(sql));  
	        PlainSelect plain = (PlainSelect) select.getSelectBody();  
	        List<SelectItem> selectitems = plain.getSelectItems();  
	        List<String> str_items = new ArrayList<String>();  
	        if (selectitems != null) {  
	            for (int i = 0; i < selectitems.size(); i++) {  
	                str_items.add(selectitems.get(i).toString());  
	            }  
	        }  
	        return str_items;  
	}  
	
	/**
	 * 获取join子句
	 * @param sql
	 * @return
	 * @throws JSQLParserException
	 */
	public static List<String> test_select_join(String sql)  
            throws JSQLParserException {  
        Statement statement = (Statement) CCJSqlParserUtil.parse(sql);  
        Select selectStatement = (Select) statement;  
        PlainSelect plain = (PlainSelect) selectStatement.getSelectBody();  
        List<Join> joinList = plain.getJoins();  
        List<String> tablewithjoin = new ArrayList<String>();  
        if (joinList != null) {  
            for (int i = 0; i < joinList.size(); i++) {  
                tablewithjoin.add(joinList.get(i).toString());  
                //注意 ， leftjoin rightjoin 等等的to string()区别  
            }  
        }  
        return tablewithjoin;  
    }  
	
	/**
	 * 获取where条件
	 * @param sql
	 * @return
	 * @throws JSQLParserException
	 */
	public static String test_select_where(String sql)  
            throws JSQLParserException {  
        CCJSqlParserManager parserManager = new CCJSqlParserManager();  
        Select select = (Select) parserManager.parse(new StringReader(sql));  
        PlainSelect plain = (PlainSelect) select.getSelectBody();  
        Expression where_expression = plain.getWhere();  
        String str = where_expression.toString();  
        return str;  
    }  
	
	/**
	 * 获取group by子句
	 * @param sql
	 * @return
	 * @throws JSQLParserException
	 */
    public static List<String> test_select_groupby(String sql)  
            throws JSQLParserException {  
        CCJSqlParserManager parserManager = new CCJSqlParserManager();  
        Select select = (Select) parserManager.parse(new StringReader(sql));  
        PlainSelect plain = (PlainSelect) select.getSelectBody();  
        List<Expression> GroupByColumnReferences = plain  
                .getGroupByColumnReferences();  
        List<String> str_groupby = new ArrayList<String>();  
        if (GroupByColumnReferences != null) {  
            for (int i = 0; i < GroupByColumnReferences.size(); i++) {  
                str_groupby.add(GroupByColumnReferences.get(i).toString());  
            }  
        }  
        return str_groupby;  
    }  
    
    /**
	 * 获取order by子句
	 * @param sql
	 * @return
	 * @throws JSQLParserException
	 */
    public static List<String> test_select_orderby(String sql)  
            throws JSQLParserException {  
        CCJSqlParserManager parserManager = new CCJSqlParserManager();  
        Select select = (Select) parserManager.parse(new StringReader(sql));  
        PlainSelect plain = (PlainSelect) select.getSelectBody();  
        List<OrderByElement> OrderByElements = plain.getOrderByElements();  
        List<String> str_orderby = new ArrayList<String>();  
        if (OrderByElements != null) {  
            for (int i = 0; i < OrderByElements.size(); i++) {  
                str_orderby.add(OrderByElements.get(i).toString());  
            }  
        }  
        return str_orderby;  
    } 
    
 // ****insert table  
    public static String test_insert_table(String sql)  
            throws JSQLParserException {  
        Statement statement = CCJSqlParserUtil.parse(sql);  
        Insert insertStatement = (Insert) statement;  
        String string_tablename = insertStatement.getTable().getName();  
        return string_tablename;  
    }  
  
    // ********* insert table column  
    public static List<String> test_insert_column(String sql)  
            throws JSQLParserException {  
        Statement statement = CCJSqlParserUtil.parse(sql);  
        Insert insertStatement = (Insert) statement;  
        List<Column> table_column = insertStatement.getColumns();  
        List<String> str_column = new ArrayList<String>();  
        for (int i = 0; i < table_column.size(); i++) {  
            str_column.add(table_column.get(i).toString());  
        }  
        return str_column;  
    }  
  
    // ********* Insert values ExpressionList  
    public static List<String> test_insert_values(String sql)  
            throws JSQLParserException {  
        Statement statement = CCJSqlParserUtil.parse(sql);  
        Insert insertStatement = (Insert) statement;  
        List<Expression> insert_values_expression = ((ExpressionList) insertStatement  
                .getItemsList()).getExpressions();  
        List<String> str_values = new ArrayList<String>();  
        for (int i = 0; i < insert_values_expression.size(); i++) {  
            str_values.add(insert_values_expression.get(i).toString());  
        }  
        return str_values;  
    }  
  
    // *********update table name  
    public static List<String> test_update_table(String sql)  
            throws JSQLParserException {  
        Statement statement = CCJSqlParserUtil.parse(sql);  
        Update updateStatement = (Update) statement;  
        List<Table> update_table = updateStatement.getTables();  
        List<String> str_table = new ArrayList<String>();  
        if (update_table != null) {  
            for (int i = 0; i < update_table.size(); i++) {  
                str_table.add(update_table.get(i).toString());  
            }  
        }  
        return str_table;  
  
    }  
  
    // *********update column  
    public static List<String> test_update_column(String sql)  
            throws JSQLParserException {  
        Statement statement = CCJSqlParserUtil.parse(sql);  
        Update updateStatement = (Update) statement;  
        List<Column> update_column = updateStatement.getColumns();  
        List<String> str_column = new ArrayList<String>();  
        if (update_column != null) {  
            for (int i = 0; i < update_column.size(); i++) {  
                str_column.add(update_column.get(i).toString());  
            }  
        }  
        return str_column;  
  
    }  
  
    // *********update values  
    public static List<String> test_update_values(String sql)  
            throws JSQLParserException {  
        Statement statement = CCJSqlParserUtil.parse(sql);  
        Update updateStatement = (Update) statement;  
        List<Expression> update_values = updateStatement.getExpressions();  
        List<String> str_values = new ArrayList<String>();  
        if (update_values != null) {  
            for (int i = 0; i < update_values.size(); i++) {  
                str_values.add(update_values.get(i).toString());  
            }  
        }  
        return str_values;  
  
    }  
  
    // *******update where  
    public static String test_update_where(String sql)  
            throws JSQLParserException {  
        Statement statement = CCJSqlParserUtil.parse(sql);  
        Update updateStatement = (Update) statement;  
        Expression where_expression = updateStatement.getWhere();  
        String str = where_expression.toString();  
        return str;  
    }  
    
    @SuppressWarnings("unused")
    public static void test_select(String sql) throws JSQLParserException {  
        // *********select body items内容  
       
		List<String> str_items = SqlPaserTools.test_select_items(sql);  
  
        // **********select table  
      /*  List<String> tableList = SqlPaserTools.test_select_table(sql);  */
  
        // **********select table with join  
        List<String> tablewithjoin = SqlPaserTools.test_select_join(sql);  
          
        // // *******select where  
        String str = SqlPaserTools.test_select_where(sql);  
  
        // // ******select group by  
        List<String> str_groupby = SqlPaserTools.test_select_groupby(sql);  
  
        // //**************select order by  
        List<String> str_orderby = SqlPaserTools.test_select_orderby(sql);  
  
    }  
  
  
//    public static void select_fromtxt() throws Exception {  
//        @SuppressWarnings("resource")  
//        BufferedReader reader = new BufferedReader(  
//                new FileReader(  
//                        "D:\\java：eclipse\\workspace for javaSE\\JSql-test\\src\\test\\select_simple.txt"));  
//  
//        List<String> statement_list = new ArrayList<String>();  
//        while (true) { // 输出所有语句  
//            String line = reader.readLine();  
//            if (line == null) {  
//                break;  
//            } else  
//                statement_list.add(line);  
//        }  
//        for (int i = 0; i < 1; i++) {  
//        	SqlTest.test_select(statement_list.get(i));  
//        }  
//    }  
//  
//    public static void insert_fromtxt() throws Exception {  
//        @SuppressWarnings("resource")  
//        BufferedReader reader = new BufferedReader(  
//                new FileReader("文件位置"));  
//  
//        List<String> statement_list = new ArrayList<String>();  
//        while (true) { // 输出所有语句  
//            String line = reader.readLine();  
//            if (line == null) {  
//                break;  
//            } else  
//                statement_list.add(line);  
//        }  
//        for (int i = 0; i < 1; i++) {  
//        	SqlTest.test_insert(statement_list.get(i));  
//        }  
//    }  
    
    /*public static void main(String[] args) throws JSQLParserException {
    	String sql ="SELECT HX_SB.SB_SBB.SBUUID, HX_SB.SB_SBB.DJXH, HX_SB.SB_SBB.NSRSBH, HX_SB.SB_SBB.NSRMC, "
    			+ "HX_DJ.DJ_NSRXX.HY_DM, HX_DJ.SB_SBB.ZGSWSKFJ_DM, HX_SB.SB_SBB.SKSSQQ, HX_SB.SB_SBB.SKSSQZ, "
    			+ "HX_SB.SB_SDS_JMCZ_14ND_YBQYSRMXB.ZYYWSR AS ZYYWSR, HX_SB.SB_SDS_JMCZ_14ND_YBQYSRMXB.YYSR AS YYSR "
    			+ "FROM HX_SB.SB_SDS_JMCZ_14ND_YBQYSRMXB "
    			+ "LEFT JOIN HX_SB.SB_SDS_JMCZ_14ND_QYSDSNDNSSBZB ON SB_SDS_JMCZ_14ND_YBQYSRMXB.SBUUID = SB_SDS_JMCZ_14ND_QYSDSNDNSSBZB.SBUUID "
    			+ "LEFT JOIN HX_SB.SB_SBB ON SB_SDS_JMCZ_14ND_QYSDSNDNSSBZB.SBUUID = SB_SBB.SBUUID "
    			+ "LEFT JOIN HX_DJ.DJ_NSRXX on SB_SBB.DJXH = DJ_NSRXX.DJXH "
    			+ "WHERE 1 = 1 "
    			+ "AND SB_SBB.zfbz_1 != 'Y' "
    			+ "AND (SB_SBB.GZLX_DM_1 = '1' "
    			+ "OR SB_SBB.GZLX_DM_1 = '5')";
    	System.out.println(judge_type(sql));
    	
		String sql = "select a,b from A LEFT JOIN B ON A.ID= B.ID LEFT JOIN C ON B.ID=C.ID where 1=1 group by a order by b";
		System.out.println("sql语句如下："+sql);
		/**
		 * 获取列字段
		 
		List<String> rList1 = SqlPaserTools.test_select_items(sql);
		for (String string : rList1) {
			System.out.println("获取列字段:"+string);
		}
		*//**
		 * 获取连接条件
		 *//*
		List<String> rList2 = SqlPaserTools.test_select_join(sql);
		for (String string : rList2) {
			System.out.println("获取连接条件:"+string);
		}
		*//**
		 * 获取where条件
		 *//*
		String rList3 =  SqlPaserTools.test_select_where(sql);
		System.out.println("获取where条件:"+rList3);		
		*//**
		 * 获取group by子句
		 *//*
		List<String> rList4 = SqlPaserTools.test_select_groupby(sql);
		for (String string : rList4) {
			System.out.println("获取group by子句:"+string);
		}
		
		*//**
		 * 获取order by子句
		 *//*
		List<String> rList5 = SqlPaserTools.test_select_orderby(sql);
		for (String string : rList5) {
			System.out.println(" 获取order by子句:"+string);
		}
	}*/
}
