package com.forword.car.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forword.car.dao.MainMapper;
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
		return getopenidisnull(oppenid);
	}
	


}
