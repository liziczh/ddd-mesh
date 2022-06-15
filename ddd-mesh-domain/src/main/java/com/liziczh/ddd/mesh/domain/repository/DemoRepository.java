package com.liziczh.ddd.mesh.domain.repository;

import java.util.List;

import com.liziczh.ddd.mesh.api.req.DemoQueryReq;
import com.liziczh.ddd.mesh.domain.entity.DemoEntity;

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
    List<DemoEntity> selectByCondition(DemoQueryReq condition);

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
    void insert(DemoEntity entity);

    /**
     * 更新
     *
     * @author chenzhehao
     * @date 2021/7/18 0:36
     */
    void update(DemoEntity entity);

    /**
     * ID删除
     *
     * @author chenzhehao
     * @date 2021/7/18 0:37
     */
    void deleteById(Long id);

}
