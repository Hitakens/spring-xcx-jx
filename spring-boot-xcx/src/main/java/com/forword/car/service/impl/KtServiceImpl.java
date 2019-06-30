package com.forword.car.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forword.car.dao.KtMapper;
import com.forword.car.service.KtService;
@Service
public class KtServiceImpl implements KtService{
	@Autowired
    private KtMapper ktMapper;
}
