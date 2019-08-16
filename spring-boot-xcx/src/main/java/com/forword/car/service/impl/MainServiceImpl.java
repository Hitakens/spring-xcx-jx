package com.forword.car.service.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forword.car.dao.MainMapper;
import com.forword.car.entity.ParaEntity;
import com.forword.car.service.MainService;
import com.forword.common.StringUtil;
import com.forword.common.UUIDGenerator;

@Service
public class MainServiceImpl implements MainService {
    @Autowired
    private MainMapper mxxxMapper;
    public Logger log = Logger.getLogger(MainServiceImpl.class);
	@Override
	public String getopenidisnull(String openid) {
		// TODO Auto-generated method stub
		return mxxxMapper.getopenidisnull(openid);
	}
	@Override
	public String updateYhxx(String oppenid, String avatarUrl,
			String nickName,String sesionnid) {
		mxxxMapper.updateYhxx(oppenid,avatarUrl,nickName,StringUtil.replaceSpecStr(sesionnid));
		return StringUtil.replaceSpecStr(sesionnid);
	}
	@Override
	public String insertkm(ParaEntity pa) {
		String re=null;
		String minKey=mxxxMapper.selectOpen_mybyKey(pa.getStr2());
		if(minKey!=null) {
			pa.setStr2(minKey);
			int i = mxxxMapper.insertYhxx(pa);
			if(i>0) {
				mxxxMapper.deleteOpen_mybyKey(minKey);
				mxxxMapper.deleteYhxxyk(pa.getStr1());
				re="200";
			}
		}else {
			re="201";
		}
		return re;
	}
	@Override
	public String insertYhxxyk(String oppenid, String avatarUrl, String nickName, String stringTojson) {
		String sseion=mxxxMapper.selectYhxxyk(oppenid);
		if(sseion==null) {
			ParaEntity p=new ParaEntity();
			p.setStr1(oppenid);
			p.setStr2(avatarUrl);
			p.setStr3(nickName);
			p.setStr4(StringUtil.replaceSpecStr(stringTojson));
			mxxxMapper.insertYhxxyk(p);
		}
		return getopenidyk(oppenid);
	}
	
	public String getopenidyk(String openid) {
		// TODO Auto-generated method stub
		return mxxxMapper.getopenidyk(openid);
	}
	@Override
	public String glyLogin(ParaEntity pa) {
		String res="";
		try {
			Map<String,Object> ma=mxxxMapper.glyLogin(pa.getStr1());
          if(ma!=null && ma.get("userpass").equals(pa.getStr2())&& 
        		  "N".equals(ma.get("glybz"))){
        	  res="200";
          }else if(ma!=null && ma.get("userpass").equals(pa.getStr2())&& 
        		  "Y".equals(ma.get("glybz"))){
        	  res="201";
          }else{
        	  res="202";  
          }
		} catch (Exception e) {
			res="202";
			System.out.println(e.getLocalizedMessage());
		}
		return res;
	}
	@Override
	public String randomKm(int n) {
		String uuid_car = UUIDGenerator.getUUID_car();
		return uuid_car;
	}
	@Override
	public String submitinsert(ParaEntity pa) {
		String s="";
		try {
			if(pa!=null && pa.getStr1()==null){
				s="登陆状态异常！请重新登陆";
			}else{
				int i=mxxxMapper.insertOpen_key(pa);
				if(i>0){
					s="200";
				}else{
					s="201";
				}
			}
			
		} catch (Exception e) {
			s="该卡密已经存在，请重新尝试！";
			log.error(e.getMessage());
		}
		
		return s;
	}
	@Override
	public Map<String, Object> selectOpenidBysessionid(String sid) {
		// TODO Auto-generated method stub
		return mxxxMapper.selectOpenidBysessionid(sid);
	}

}
