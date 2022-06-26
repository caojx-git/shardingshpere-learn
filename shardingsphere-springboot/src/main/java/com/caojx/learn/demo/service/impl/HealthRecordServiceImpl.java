package com.caojx.learn.demo.service.impl;

import com.caojx.learn.demo.entity.HealthRecord;
import com.caojx.learn.demo.entity.HealthTask;
import com.caojx.learn.demo.mapper.HealthRecordMapper;
import com.caojx.learn.demo.mapper.HealthTaskMapper;
import com.caojx.learn.demo.service.IHealthRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author caojx
 * @date 2022-06-26 18:16
 */
@Service
public class HealthRecordServiceImpl implements IHealthRecordService {

    @Resource
    private HealthRecordMapper healthRecordMapper;

    @Resource
    private HealthTaskMapper healthTaskMapper;


    @Override
    public void processHealthRecords() throws SQLException {
        insertHealthRecords();
    }

    private List<Long> insertHealthRecords() throws SQLException {
        List<Long> result = new ArrayList<>(10);

        for (int i = 1; i <= 10; i++) {
            HealthRecord healthRecord = insertHealthRecord(i);
            insertHealthTask(i, healthRecord);
            result.add(healthRecord.getRecordId());
        }
        return result;
    }

    private HealthRecord insertHealthRecord(long i) throws SQLException {
        HealthRecord healthRecord = new HealthRecord();
        healthRecord.setUserId(i);
        healthRecord.setLevelId(i % 5);
        healthRecord.setRemark("Remark" + i);
        healthRecordMapper.insertSelective(healthRecord);
        return healthRecord;
    }

    private void insertHealthTask(long i, HealthRecord healthRecord) throws SQLException {
        HealthTask healthTask = new HealthTask();
        healthTask.setRecordId(healthRecord.getRecordId());
        healthTask.setUserId(i);
        healthTask.setTaskName("TaskName" + i);
        healthTaskMapper.insertSelective(healthTask);
    }

}
