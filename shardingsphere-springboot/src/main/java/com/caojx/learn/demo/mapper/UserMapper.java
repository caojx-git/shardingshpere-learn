package com.caojx.learn.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.caojx.learn.demo.entity.User;

/**
* 注释 Mapper
*
* @author caojx
* @date 2022-06-26 22:19
*/
@Mapper
public interface UserMapper {

    /**
     * 根据主键id查询
     *
     * @param userId
     * @return 记录信息
     */
    User selectByPrimaryKey(Long userId);

    /**
     * 根据主键删除数据
     *
     * @param userId
     * @return 数量
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(User record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(User record);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(User record);
}
