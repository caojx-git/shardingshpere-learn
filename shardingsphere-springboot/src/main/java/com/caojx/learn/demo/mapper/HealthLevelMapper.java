package com.caojx.learn.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.caojx.learn.demo.entity.HealthLevel;

/**
* 注释 Mapper
*
* @author caojx
* @date 2022-06-26 22:19
*/
@Mapper
public interface HealthLevelMapper {

    /**
     * 根据主键id查询
     *
     * @param levelId
     * @return 记录信息
     */
    HealthLevel selectByPrimaryKey(Long levelId);

    /**
     * 根据主键删除数据
     *
     * @param levelId
     * @return 数量
     */
    int deleteByPrimaryKey(Long levelId);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(HealthLevel record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(HealthLevel record);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(HealthLevel record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(HealthLevel record);
}
