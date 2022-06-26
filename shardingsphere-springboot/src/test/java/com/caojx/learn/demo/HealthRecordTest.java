package com.caojx.learn.demo;

import com.caojx.learn.demo.service.IHealthRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author caojx created on 2022/6/26 6:24 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HealthRecordTest {

    @Autowired
    private IHealthRecordService healthRecordService;

    @Test
    public void testProcessHealthRecords() throws Exception {
        healthRecordService.processHealthRecords();
    }
}
