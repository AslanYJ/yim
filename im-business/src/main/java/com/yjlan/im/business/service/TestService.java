package com.yjlan.im.business.service;

import com.yjlan.im.business.entity.Test;
import com.yjlan.im.business.mapper.TestMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TestService {

    @Resource
    private TestMapper testMapper;



}
