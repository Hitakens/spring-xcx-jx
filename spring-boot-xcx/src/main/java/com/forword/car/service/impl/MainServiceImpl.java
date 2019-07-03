package com.forword.car.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forword.car.dao.MainMapper;
import com.forword.car.entity.ParaEntity;
import com.forword.car.service.MainService;

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
		mxxxMapper.updateYhxx(oppenid,avatarUrl,nickName,sesionnid);
		return sesionnid;
	}
	@Override
	public String insertkm(ParaEntity pa) {
		String re=null;
		String minKey=mxxxMapper.selectOpen_mybyKey(pa.getStr2());
		if(minKey!=null) {
			int i = mxxxMapper.insertYhxx(pa.getStr1());
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
			p.setStr4(stringTojson);
			mxxxMapper.insertYhxxyk(p);
		}
		return getopenidyk(oppenid);
	}
	
	public String getopenidyk(String openid) {
		// TODO Auto-generated method stub
		return mxxxMapper.getopenidyk(openid);
	}

}
