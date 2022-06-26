package com.caojx.learn.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.caojx.learn.demo.entity.HealthRecord;

/**
* 注释 Mapper
*
* @author caojx
* @date 2022-06-26 22:19
*/
@Mapper
public interface HealthRecordMapper {

    /**
     * 根据主键id查询
     *
     * @param recordId
     * @return 记录信息
     */
    HealthRecord selectByPrimaryKey(Long recordId);

    /**
     * 根据主键删除数据
     *
     * @param recordId
     * @return 数量
     */
    int deleteByPrimaryKey(Long recordId);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(HealthRecord record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(HealthRecord record);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(HealthRecord record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(HealthRecord record);
}
