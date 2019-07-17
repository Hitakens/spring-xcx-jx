package com.forword.common;

import java.time.Instant;
import java.util.Random;
import java.util.UUID;

/**
 * uuid生成器
 * @author mac
 *
 */
public class UUIDGenerator {

	public UUIDGenerator() {  
    }  
	
    public static String getUUID1() {  
        return UUID.randomUUID().toString();  
    }
    
    public static String getUUID2() {  
        UUID uuid = UUID.randomUUID();  
        String str = uuid.toString();  
        str = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);  
        return str;  
    }
    
    public static String[] getUUID(int number,int type) {  
        if (number < 1) {  
            return null;  
        }  
        String[] ss = new String[number];  
        for (int i = 0; i < number; i++) { 
        	if(type==1){
        		ss[i] = getUUID2();  
        	}else{
        		ss[i] = getUUID1();  
        	}
        }  
        return ss;  
    }  
  
  public static String getUUID_zhzb(){
	  UUID randomUUID = UUID.randomUUID();
		long millis = System.currentTimeMillis();
		return "ZH_"+randomUUID.toString().substring(0, 5)+millis;
  }
  public static String getUUID_car(){
	  UUID randomUUID = UUID.randomUUID();
		long millis = System.currentTimeMillis();
		return "Km_"+randomUUID.toString().substring(0, 5)+millis;
  }
  public static String getImgUUID(){
  	Random r=new Random();
  	Instant now = Instant.now();
  	String asInt = "_"+r.ints(0, (999999999 + 1)).limit(1).findAny().getAsInt();
  	String u=now.toString()+asInt;
		return u.replace(":", "-");
  }
}
