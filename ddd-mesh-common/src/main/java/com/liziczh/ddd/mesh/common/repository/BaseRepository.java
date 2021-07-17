package com.liziczh.ddd.mesh.common.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseRepository<E, PK, C> {
    /**
     * 条件查询
     *
     * @param condition 条件
     * @return 数据集合
     */
    List<E> selectByCondition(C condition);

    /**
     * 查询全部
     *
     * @return 实体
     */
    List<E> getAll();

    /**
     * 查询 By ID
     *
     * @param pk 主键
     * @return 实体
     */
    E get(PK pk);

    /**
     * 新增
     *
     * @param entity 实体
     * @return id
     */
    int insert(E entity);

    /**
     * 更新
     *
     * @param entity 实体
     * @return id
     */
    int update(E entity);

    /**
     * 删除
     *
     * @param pk 主键
     * @return
     */
    int delete(PK pk);
}
