package com.syg.manage.dao.manage;

import com.syg.manage.model.manage.Player;

public interface PlayerMapper {
    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @ibatorgenerated 2015-12-16 18:38:43
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2015-12-16 18:38:43
     */
    int insert(Player record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2015-12-16 18:38:43
     */
    int insertSelective(Player record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2015-12-16 18:38:43
     */
    Player selectByPrimaryKey(Integer uid);

    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2015-12-16 18:38:43
     */
    int updateByPrimaryKeySelective(Player record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2015-12-16 18:38:43
     */
    int updateByPrimaryKey(Player record);
}