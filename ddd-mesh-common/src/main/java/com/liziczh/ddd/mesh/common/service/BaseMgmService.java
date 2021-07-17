package com.liziczh.ddd.mesh.common.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/7/17 21:52
 */
@Service
public interface BaseMgmService<T, PK, C> {
    /**
     * 条件查询
     *
     * @param condition 条件
     * @return 数据
     */
    List<T> selectByCondition(C condition);

    /**
     * 查询全部数据
     *
     * @return 数据集合
     */
    List<T> getAll();

    /**
     * 查询数据ByID
     *
     * @param id 主键
     * @return 实体
     */
    T get(PK id);

    /**
     * 新增数据
     *
     * @param entity 实体
     */
    void addItem(T entity);

    /**
     * 更新数据
     *
     * @param entity 实体
     */
    void updateItem(T entity);

    /**
     * 删除数据ByID
     *
     * @param id 主键
     */
    void delete(PK id);
}
