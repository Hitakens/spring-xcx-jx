package com.forword.car.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
	


}
