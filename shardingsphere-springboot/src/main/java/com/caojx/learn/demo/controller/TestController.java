package com.caojx.learn.demo.controller;

import com.caojx.learn.demo.entity.HealthRecord;
import com.caojx.learn.demo.service.IHealthRecordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试类
 *
 * @author caojx
 * @date 2022/6/29 12:45
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private IHealthRecordService healthRecordService;

    @RequestMapping("/hintFindAll")
    public List<HealthRecord> hintFindAll() {
        return healthRecordService.findAll();
    }
}
