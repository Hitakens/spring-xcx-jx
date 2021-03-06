package com.forword.car.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forword.car.dao.xcMapper;
import com.forword.car.entity.ParaEntity;
import com.forword.car.service.xcService;
@Service
public class xcServiceImpl implements xcService{
	@Autowired
    private xcMapper ktMapper;
	@Override
	public List<Map<String, Object>> getKmydata(String pa,String tmlx) {
		List<Map<String, Object>> listData=null;
		ParaEntity pr=new ParaEntity();
		if(pa=="1" || "1".equals(pa)){
			pr.setInt1(0);
			pr.setInt2(100);
			pr.setStr1(tmlx);
			listData = ktMapper.getKmydata(pr);
			for(int i=0;i<listData.size();i++){
				listData.get(i).put("id", i);
			}
		}else if(pa=="2" || "2".equals(pa)){
			pr.setInt1(100);
			pr.setInt2(100);
			pr.setStr1(tmlx);
			listData = ktMapper.getKmydata(pr);
			for(int i=0;i<listData.size();i++){
				listData.get(i).put("id", i);
			}
		}
		else if (pa == "3" || "3".equals(pa)) {
			pr.setInt1(200);
			pr.setInt2(100);
			pr.setStr1(tmlx);
			listData = ktMapper.getKmydata(pr);
			for (int i = 0; i < listData.size(); i++) {
				listData.get(i).put("id", i);
			}
		}else if (pa == "4" || "4".equals(pa)) {
			pr.setInt1(300);
			pr.setInt2(100);
			pr.setStr1(tmlx);
			listData = ktMapper.getKmydata(pr);
			for (int i = 0; i < listData.size(); i++) {
				listData.get(i).put("id", i);
			}
		}else if (pa == "5" || "5".equals(pa)) {
			pr.setInt1(400);
			pr.setInt2(100);
			pr.setStr1(tmlx);
			listData = ktMapper.getKmydata(pr);
			for (int i = 0; i < listData.size(); i++) {
				listData.get(i).put("id", i);
			}
		}else if (pa == "6" || "6".equals(pa)) {
			pr.setInt1(500);
			pr.setInt2(100);
			pr.setStr1(tmlx);
			listData = ktMapper.getKmydata(pr);
			for (int i = 0; i < listData.size(); i++) {
				listData.get(i).put("id", i);
			}
		}
		return listData;
	}

	@Override
	public String scbt(String sclx, Integer uuid, String openid) {
		String msg="";
		ParaEntity pr=null;
		try {
			pr=new ParaEntity();
			pr.setInt1(uuid);
			pr.setStr2(sclx);
			pr.setStr1(openid);
			String suuid= ktMapper.selectScdtByuuidandsclx(pr);
			if(suuid!=null) {
				ktMapper.deleteScdtByuuidandsclx(pr);
				msg="取消成功!";
			}else {
				pr=new ParaEntity();
				pr.setStr2(sclx);
				pr.setInt1(uuid);
				pr.setStr1(openid);
				ktMapper.insertScdt(pr);
				msg="收藏成功!";
			}
		} catch (Exception e) {
			msg="网络延迟!";
			e.getMessage();
		}
		
		return msg;
	}

	@Override
	public String cwlx(String cwlx, Integer uuid, String openid) {
		String msg="";
		ParaEntity pr=null;
		try {
			pr=new ParaEntity();
			pr.setInt1(uuid);
			pr.setStr1(openid);
			pr.setStr2(cwlx);
			String suuid= ktMapper.selectbtcwByuuidandsclx(pr);
			if(suuid!=null) {
				msg="1";
			}else {
				pr=new ParaEntity();
				pr.setStr2(cwlx);
				pr.setInt1(uuid);
				pr.setStr1(openid);
				ktMapper.inserttkcw(pr);
				msg="2";
			}
		} catch (Exception e) {
			msg="3";
			e.getMessage();
		}
		
		return msg;
	}

	@Override
	public String iftmsc(String cwlx, Integer uuid,  String openid) {
		String str="";
		ParaEntity pr=new ParaEntity();
       pr.setInt1(uuid);
       pr.setStr2(cwlx);
       pr.setStr1(openid);
		String s = ktMapper.selectScdtByuuidandsclx(pr);
		if(s!=null){
			str="1";	
		}else{
			str="0";
		}
		return str;
	}

	@Override
	public Map<String, Object> ctsc(String clx, String openid) {
		 Map<String, Object> ctsc=null;
		 try {
			if(clx=="xc" || "xc".equals(clx)) {
				ctsc=new HashMap<>();
				Map<String, Object> KmCcount = ktMapper.selectKmyAndKmsScCount(openid);
				ctsc.put("kmysc",KmCcount.get("kmysc"));
				ctsc.put("kmssc",KmCcount.get("kmssc"));
				Map<String, Object> CtCount = ktMapper.selectKmyAndKmsCtCount(openid);
				ctsc.put("kmyct",CtCount.get("kmyct"));
				ctsc.put("kmsct",CtCount.get("kmsct"));
				KmCcount=null;
				CtCount=null;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return ctsc;
	}

	
	@Override
	public List<Map<String, Object>> kmMnks(String kmj) {
		List<Map<String, Object>> datas=null;
		if(kmj=="xckmy" || "xckmy".equals(kmj)){
			datas=ktMapper.kmyMnks();
		}else if(kmj=="xckms" || "xckms".equals(kmj)) {
			datas=ktMapper.kmsMnks();
		}
		return datas;
	}

	@Override
	public List<Map<String, Object>> carkmdycs(String tmlx, String pa) {
		List<Map<String, Object>> listData=null;
		ParaEntity pr=new ParaEntity();
		if(pa=="1" || "1".equals(pa)){
			pr.setInt1(0);
			pr.setInt2(100);
			pr.setStr1(tmlx);
			listData = ktMapper.getKmyDycsdata(pr);
			for(int i=0;i<listData.size();i++){
				listData.get(i).put("id", i);
			}
		}else if(pa=="2" || "2".equals(pa)){
			pr.setInt1(100);
			pr.setInt2(100);
			pr.setStr1(tmlx);
			listData = ktMapper.getKmyDycsdata(pr);
			for(int i=0;i<listData.size();i++){
				listData.get(i).put("id", i);
			}
		}
		else if (pa == "3" || "3".equals(pa)) {
			pr.setInt1(200);
			pr.setInt2(100);
			pr.setStr1(tmlx);
			listData = ktMapper.getKmyDycsdata(pr);
			for (int i = 0; i < listData.size(); i++) {
				listData.get(i).put("id", i);
			}
		}else if (pa == "4" || "4".equals(pa)) {
			pr.setInt1(300);
			pr.setInt2(100);
			pr.setStr1(tmlx);
			listData = ktMapper.getKmyDycsdata(pr);
			for (int i = 0; i < listData.size(); i++) {
				listData.get(i).put("id", i);
			}
		}else if (pa == "5" || "5".equals(pa)) {
			pr.setInt1(400);
			pr.setInt2(100);
			pr.setStr1(tmlx);
			listData = ktMapper.getKmyDycsdata(pr);
			for (int i = 0; i < listData.size(); i++) {
				listData.get(i).put("id", i);
			}
		}else if (pa == "6" || "6".equals(pa)) {
			pr.setInt1(500);
			pr.setInt2(100);
			pr.setStr1(tmlx);
			listData = ktMapper.getKmyDycsdata(pr);
			for (int i = 0; i < listData.size(); i++) {
				listData.get(i).put("id", i);
			}
		}
		return listData;
	}

	@Override
	public List<Map<String, Object>> showcwsckmy(String lx, String openid,String kmlx) {
		List<Map<String, Object>> listData=null;
		ParaEntity pa=null;
	  if(lx=="sc" || "sc".equals(lx)){
		  pa=new ParaEntity();
		  pa.setStr1(openid);
		  pa.setStr2(kmlx);
		  listData=ktMapper.getkmySclist(pa);
	  }else if(lx=="cw" || "cw".equals(lx)){
		  pa=new ParaEntity();
		  pa.setStr1(openid);
		  pa.setStr2(kmlx);
		  listData=ktMapper.getkmyCwlist(pa);
	  }
		return listData;
	}

	@Override
	public String deletebt(ParaEntity pa) {
		String res="201";
		try {
			if(pa.getStr2()=="cw" || "cw".equals(pa.getStr2())){
				int i =ktMapper.deleteByOPenidCw(pa);
				if(i>0){
					res="200";
				}
			}else if(pa.getStr2()=="sc" || "sc".equals(pa.getStr2())){
				int i =ktMapper.deleteByOPenidSc(pa);
				if(i>0){
					res="200";
				}
			}
		} catch (Exception e) {
			res="201";
			e.getMessage();
		}
		return res;
	}

	@Override
	public List<Map<String, Object>> carkmsdycs(String pa) {
		List<Map<String, Object>> listData=null;
		ParaEntity pr=new ParaEntity();
		if(pa=="1" || "1".equals(pa)){
			pr.setInt1(0);
			pr.setInt2(100);
			listData = ktMapper.getKmsDycsdata(pr);
			for(int i=0;i<listData.size();i++){
				listData.get(i).put("id", i);
			}
		}else if(pa=="2" || "2".equals(pa)){
			pr.setInt1(100);
			pr.setInt2(100);
			listData = ktMapper.getKmsDycsdata(pr);
			for(int i=0;i<listData.size();i++){
				listData.get(i).put("id", i);
			}
		}
		else if (pa == "3" || "3".equals(pa)) {
			pr.setInt1(200);
			pr.setInt2(100);
			listData = ktMapper.getKmsDycsdata(pr);
			for (int i = 0; i < listData.size(); i++) {
				listData.get(i).put("id", i);
			}
		}else if (pa == "4" || "4".equals(pa)) {
			pr.setInt1(300);
			pr.setInt2(100);
			listData = ktMapper.getKmsDycsdata(pr);
			for (int i = 0; i < listData.size(); i++) {
				listData.get(i).put("id", i);
			}
		}else if (pa == "5" || "5".equals(pa)) {
			pr.setInt1(400);
			pr.setInt2(100);
			listData = ktMapper.getKmsDycsdata(pr);
			for (int i = 0; i < listData.size(); i++) {
				listData.get(i).put("id", i);
			}
		}else if (pa == "6" || "6".equals(pa)) {
			pr.setInt1(500);
			pr.setInt2(100);
			listData = ktMapper.getKmsDycsdata(pr);
			for (int i = 0; i < listData.size(); i++) {
				listData.get(i).put("id", i);
			}
		}
		return listData;
	}

	@Override
	public List<Map<String, Object>> getKmsdata(String pa) {
		List<Map<String, Object>> listData=null;
		ParaEntity pr=new ParaEntity();
		if(pa=="1" || "1".equals(pa)){
			pr.setInt1(0);
			pr.setInt2(100);
			listData = ktMapper.getKmsdata(pr);
			for(int i=0;i<listData.size();i++){
				listData.get(i).put("id", i);
			}
		}else if(pa=="2" || "2".equals(pa)){
			pr.setInt1(100);
			pr.setInt2(100);
			listData = ktMapper.getKmsdata(pr);
			for(int i=0;i<listData.size();i++){
				listData.get(i).put("id", i);
			}
		}
		else if (pa == "3" || "3".equals(pa)) {
			pr.setInt1(200);
			pr.setInt2(100);
			listData = ktMapper.getKmsdata(pr);
			for (int i = 0; i < listData.size(); i++) {
				listData.get(i).put("id", i);
			}
		}else if (pa == "4" || "4".equals(pa)) {
			pr.setInt1(300);
			pr.setInt2(100);
			listData = ktMapper.getKmsdata(pr);
			for (int i = 0; i < listData.size(); i++) {
				listData.get(i).put("id", i);
			}
		}else if (pa == "5" || "5".equals(pa)) {
			pr.setInt1(400);
			pr.setInt2(100);
			listData = ktMapper.getKmsdata(pr);
			for (int i = 0; i < listData.size(); i++) {
				listData.get(i).put("id", i);
			}
		}else if (pa == "6" || "6".equals(pa)) {
			pr.setInt1(500);
			pr.setInt2(100);
			listData = ktMapper.getKmsdata(pr);
			for (int i = 0; i < listData.size(); i++) {
				listData.get(i).put("id", i);
			}
		}
		return listData;
	}

	@Override
	public List<Map<String, Object>> showcwsckms(String lx, String openid, String kmlx) {
		List<Map<String, Object>> listData=null;
		ParaEntity pa=null;
	  if(lx=="sc" || "sc".equals(lx)){
		  pa=new ParaEntity();
		  pa.setStr1(openid);
		  pa.setStr2(kmlx);
		  listData=ktMapper.getkmySclist(pa);
	  }else if(lx=="cw" || "cw".equals(lx)){
		  pa=new ParaEntity();
		  pa.setStr1(openid);
		  pa.setStr2(kmlx);
		  listData=ktMapper.getkmsCwlist(pa);
	  }
		return listData;
	}
	
}
