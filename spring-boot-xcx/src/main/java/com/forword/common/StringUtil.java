package com.forword.common;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 处理计算公式以及SQL拼装等特殊公式
 * @author foresee
 *
 */
public class StringUtil implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
     * 处理中文乱码
     * @param strSource
     * @return
     * @throws UnsupportedEncodingException
     */
	public static String messycode(String strSource) throws UnsupportedEncodingException {
		if(strSource != null && !"".equals(strSource)){
		    String strSomeEncoding = "UTF-8";   //例如UTF-8  
		    strSomeEncoding = System.getProperty("file.encoding"); 
		    if(isMessyCode(strSource)){
			    String strTarget = new String(strSource.getBytes("ISO-8859-1"),strSomeEncoding);;
			    return strTarget;
		    }else{
			    return strSource;
		    }
		}else{
			return null;
		}
	}
	
	private static boolean isChinese(char c) {  
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);  
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A  
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION  
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION  
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {  
            return true;  
        }  
        return false;  
    }  
    
	/**
     * 判断是不是乱码
     * @param strSource
     * @return
     * @throws UnsupportedEncodingException
     */
    public static boolean isMessyCode(String strName) {  
        Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");  
        Matcher m = p.matcher(strName);  
        String after = m.replaceAll("");  
        String temp = after.replaceAll("\\p{P}", "");  
        char[] ch = temp.trim().toCharArray();  
        float chLength = 0 ;  
        float count = 0;  
        for (int i = 0; i < ch.length; i++) {  
            char c = ch[i];  
            if (!Character.isLetterOrDigit(c)) {  
                if (!isChinese(c)) {  
                    count = count + 1;  
                }  
                chLength++;   
            }  
        }  
        float result = count / chLength ;  
        if (result > 0.4) {  
            return true;  
        } else {  
            return false;  
        }  
    }  
      
	/** 
	 * 正则替换所有特殊字符 
	 * @param orgStr 
	 * @return 
	 */  
	public static String replaceSpecStr(String orgStr){  
	    if (null!=orgStr&&!"".equals(orgStr.trim())) {  
	        String regEx="[\\s~·`!！@#￥$%^……&*（()）\\-——\\-_=+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";  
	        Pattern p = Pattern.compile(regEx);  
	        Matcher m = p.matcher(orgStr);  
	        return m.replaceAll("");  
	    }  
	    return null;  
	} 
	
	public static String listToString(Set<String> set){
		if(set != null){
			String s = null;
			Iterator<String> it = set.iterator();  
			while (it.hasNext()) {  
			  s = ( s == null ? it.next() : s + "," + it.next());
			}  
			return s;
		}else{
			return null;
		}
	}
	
	public static List<String> listToString(String key, List<Map<String, Object>> list){
		if(list != null){
			List<String> s = new ArrayList<String>();
			for(int i =0; i < list.size(); i++){
				Map<String, Object> map = list.get(i);
				Set<Map.Entry<String,Object>> set = map.entrySet(); 
				Iterator<Entry<String, Object>> it = set.iterator();  
				while (it.hasNext()) { 
					Map.Entry<String, Object> entry = it.next(); 
					if(entry.getKey().equals(key)){
						s.add((String) entry.getValue());
					}
				}
			}
			return s;
		}else{
			return null;
		}
	}
}