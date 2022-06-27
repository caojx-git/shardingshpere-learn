package com.caojx.learn.demo.service;


import com.caojx.learn.demo.entity.HealthRecord;

import java.sql.SQLException;
import java.util.List;

/**
 * @author caojx
 * @date 2022-06-26 18:16
 */
public interface IHealthRecordService {

    void processHealthRecords() throws SQLException;


    List<HealthRecord> findAll();
}
