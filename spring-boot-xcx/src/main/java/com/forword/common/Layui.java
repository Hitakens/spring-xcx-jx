package com.forword.common;

import java.util.HashMap;
import java.util.List;

public class Layui extends HashMap<String, Object>{

	private static final long serialVersionUID = 2797560131809040119L;

	public static Layui data(Integer count,List<?> data){
        Layui r = new Layui();
        r.put("code", 0);
        r.put("msg", "");
        r.put("count", count);
        r.put("data", data);
        return r;
    }
}
