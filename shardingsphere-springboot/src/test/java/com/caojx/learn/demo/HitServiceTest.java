package com.caojx.learn.demo;

import com.caojx.learn.demo.service.IHealthRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author caojx created on 2022/6/27 9:59 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HitServiceTest {


    @Resource
    private IHealthRecordService healthRecordService;

    @Test
    public void testHintFindAll(){
        healthRecordService.findAll();
    }
}

