package com.liziczh.ddd.mesh.dao.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liziczh.ddd.mesh.api.condition.PageCondition;
import com.liziczh.ddd.mesh.api.condition.SortCondition;
import com.liziczh.ddd.mesh.api.req.DemoQueryReq;
import com.liziczh.ddd.mesh.common.enums.DeletedEnum;
import com.liziczh.ddd.mesh.dao.convertor.DemoPOConvertor;
import com.liziczh.ddd.mesh.dao.mapper.TDemoMapper;
import com.liziczh.ddd.mesh.dao.po.DemoPO;
import com.liziczh.ddd.mesh.domain.entity.DemoEntity;
import com.liziczh.ddd.mesh.domain.repository.DemoRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Demo资源层实现
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/7/18 0:26
 */
@Slf4j
@Repository
public class DemoRepositoryImpl implements DemoRepository {

    @Autowired
    private TDemoMapper demoMapper;

    @Autowired
    private DemoPOConvertor demoPOConvertor;

    @Override
    public List<DemoEntity> selectByCondition(DemoQueryReq condition) {

        // select
        PageCondition pageCondition = condition.getPage();
        List<SortCondition> sortConditionList = condition.getSortList();
        QueryWrapper<DemoPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(DemoPO::getName, condition.getName())
                .ge(DemoPO::getCreateTime, condition.getStartTime())
                .lt(DemoPO::getCreateTime, condition.getEndTime())
                .eq(DemoPO::getDeleted, DeletedEnum.NORMAL.getCode());
        for (SortCondition sortCondition : sortConditionList) {
            queryWrapper.orderByDesc(sortCondition.getColumnName());
        }
        Page<DemoPO> demoPage = demoMapper.selectPage(new Page<>(pageCondition.getPageNo(), pageCondition.getSize()),
                queryWrapper);
        List<DemoPO> poList = demoPage.getRecords();

        // toEntity
        List<DemoEntity> entityList = demoPOConvertor.toEntityList(poList);

        return entityList;
    }

    @Override
    public DemoEntity get(Long id) {

        // select
        DemoPO po = demoMapper.selectById(id);

        // toEntity
        DemoEntity entity = demoPOConvertor.toEntity(po);

        return entity;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(DemoEntity entity) {

        // toPO
        DemoPO po = demoPOConvertor.toPO(entity);

        // insert
        int insert = demoMapper.insert(po);
        if (insert != 1) {
            throw new RuntimeException("DemoRepositoryImpl.insert, error");
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(DemoEntity entity) {

        // toPO
        DemoPO po = demoPOConvertor.toPO(entity);

        int update = demoMapper.updateById(po);
        if (update != 1) {
            throw new RuntimeException("DemoRepositoryImpl.update, error");
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {

        // delete
        int delete = demoMapper.deleteById(id);

        if (delete != 1) {
            throw new RuntimeException("DemoRepositoryImpl.deleteById, error");
        }

    }
}
