package com.liziczh.ddd.mesh.domain.repository;

import com.liziczh.ddd.mesh.api.condition.DemoCondition;
import com.liziczh.ddd.mesh.domain.entity.DemoEntity;

import java.util.List;

/**
 * 资源层接口
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/7/18 0:20
 */
public interface DemoRepository {

    /**
     * 条件查询
     *
     * @author chenzhehao
     * @date 2021/7/18 0:38
     */
    List<DemoEntity> selectByCondition(DemoCondition condition);

    /**
     * ID查询
     *
     * @author chenzhehao
     * @date 2021/7/18 0:38
     */
    DemoEntity get(Long id);

    /**
     * 新增
     *
     * @author chenzhehao
     * @date 2021/7/18 0:35
     */
    Boolean insert(DemoEntity entity);

    /**
     * 更新
     *
     * @author chenzhehao
     * @date 2021/7/18 0:36
     */
    Boolean update(DemoEntity entity);

    /**
     * ID删除
     *
     * @author chenzhehao
     * @date 2021/7/18 0:37
     */
    Boolean deleteById(Long id);

}
