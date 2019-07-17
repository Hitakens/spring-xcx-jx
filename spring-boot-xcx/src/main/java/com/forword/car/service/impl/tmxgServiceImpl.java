package com.forword.car.service.impl;


import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forword.car.service.tmxgService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.forword.car.dao.tmxgMapper;
import com.forword.car.entity.Layui;
import com.forword.car.entity.ParaEntity;
import com.forword.car.entity.kmtmEntity;
@Service
public class tmxgServiceImpl implements tmxgService{
    public Logger log = Logger.getLogger(this.getClass());
   final String REMSGTRUE="修改成功！";
   final String REMSGFALSE="修改失败";
	@Autowired
    private tmxgMapper tmxgMapper;

	@Override
	public Layui selectTMall(ParaEntity pa, Integer limit, Integer page) {
		Layui data =null;
		List<Map<String,Object>> docs=null;
		PageInfo<Map<String,Object>> pageInfo =null;
		try {
			limit = limit == null?50:limit;
			page = page == null?1:page;
			PageHelper.startPage(page,limit);
			String p=pa.getStr2()==null?"":"%"+pa.getStr2()+"%";
			if(pa!=null && (pa.getStr1()=="xckmy" || "xckmy".equals(pa.getStr1()))) {
				docs = tmxgMapper.selectxckmy(p);
			}else if(pa!=null && (pa.getStr1()=="xckms" || "xckms".equals(pa.getStr1()))){
				docs = tmxgMapper.selectxckms(p);
			}else if(pa!=null && (pa.getStr1()=="hckmy" || "hckmy".equals(pa.getStr1()))) {
				docs = tmxgMapper.selecthckmy(p);
			}else if(pa!=null && (pa.getStr1()=="hckms" || "hckms".equals(pa.getStr1()))){
				docs = tmxgMapper.selecthckms(p);
			}else if(pa!=null && (pa.getStr1()=="kckmy" || "kckmy".equals(pa.getStr1()))) {
				docs = tmxgMapper.selectkckmy(p);
			}else if(pa!=null && (pa.getStr1()=="kckms" || "kckms".equals(pa.getStr1()))){
				docs = tmxgMapper.selectkckms(p);
			}
			pageInfo = new PageInfo<>(docs);
			Integer total = (int) pageInfo.getTotal();
	        data = Layui.data(total,pageInfo.getList());
		} catch (Exception e) {
			log.info(e);
		}
		return data;
	}

	@Override
	public String insertKm(kmtmEntity pa) {
		String msg=null;
		try {
			if(pa!=null && (pa.getKmlx()=="xckmy" || "xckmy".equals(pa.getKmlx()))) {
				int i=tmxgMapper.insertxckmy(pa);
				if(i>0) {
					msg=REMSGTRUE;
				}else {
					msg=REMSGFALSE;
				}
			}else if(pa!=null && (pa.getKmlx()=="xckms" || "xckms".equals(pa.getKmlx()))) {
				int i=tmxgMapper.insertxckms(pa);
				if(i>0) {
					msg=REMSGTRUE;
				}else {
					msg=REMSGFALSE;
				}
			}else if(pa!=null && (pa.getKmlx()=="hckmy" || "hckmy".equals(pa.getKmlx()))) {
				int i=tmxgMapper.inserthckmy(pa);
				if(i>0) {
					msg=REMSGTRUE;
				}else {
					msg=REMSGFALSE;
				}
			}else if(pa!=null && (pa.getKmlx()=="hckms" || "hckms".equals(pa.getKmlx()))) {
				int i=tmxgMapper.inserthckms(pa);
				if(i>0) {
					msg=REMSGTRUE;
				}else {
					msg=REMSGFALSE;
				}
			}else if(pa!=null && (pa.getKmlx()=="kckmy" || "kckmy".equals(pa.getKmlx()))) {
				int i=tmxgMapper.insertkckmy(pa);
				if(i>0) {
					msg=REMSGTRUE;
				}else {
					msg=REMSGFALSE;
				}
			}else if(pa!=null && (pa.getKmlx()=="kckms" || "kckms".equals(pa.getKmlx()))) {
				int i=tmxgMapper.insertkckms(pa);
				if(i>0) {
					msg=REMSGTRUE;
				}else {
					msg=REMSGFALSE;
				}
			}
		} catch (Exception e) {
			msg=REMSGFALSE;
			log.info(e);
		}
		return msg;
	}

	@Override
	public String updatekmimg(ParaEntity pa) {
		String msg=REMSGFALSE;
		try {
			if(pa!=null && pa.getStr2()=="xckmy" || "xckmy".equals(pa.getStr2())){
				if(tmxgMapper.updatekmimgxckmy(pa)>0){
					msg=REMSGTRUE;
				}
			}else if(pa!=null && pa.getStr2()=="xckms" || "xckms".equals(pa.getStr2())){
				if(tmxgMapper.updatekmimgxckms(pa)>0){
					msg=REMSGTRUE;
				}
			}else if(pa!=null && pa.getStr2()=="hckmy" || "hckmy".equals(pa.getStr2())){
				if(tmxgMapper.updatekmimghckmy(pa)>0){
					msg=REMSGTRUE;
				}
			}else if(pa!=null && pa.getStr2()=="hckms" || "hckms".equals(pa.getStr2())){
				if(tmxgMapper.updatekmimghckms(pa)>0){
					msg=REMSGTRUE;
				}
			}else if(pa!=null && pa.getStr2()=="kckms" || "kckms".equals(pa.getStr2())){
				if(tmxgMapper.updatekmimgkckms(pa)>0){
					msg=REMSGTRUE;
				}
			}else if(pa!=null && pa.getStr2()=="kckmy" || "kckmy".equals(pa.getStr2())){
				if(tmxgMapper.updatekmimgkckmy(pa)>0){
					msg=REMSGTRUE;
				}
			}
		} catch (Exception e) {
			log.info(e);
		}
		return msg;
	}
	
}
