package com.liziczh.ddd.mesh.dao.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liziczh.ddd.mesh.api.condition.DemoCondition;
import com.liziczh.ddd.mesh.api.enums.CommonStatusEnum;
import com.liziczh.ddd.mesh.common.condition.PageCondition;
import com.liziczh.ddd.mesh.common.condition.SortCondition;
import com.liziczh.ddd.mesh.dao.mapper.TDemoMapper;
import com.liziczh.ddd.mesh.dao.po.TDemo;
import com.liziczh.ddd.mesh.domain.entity.DemoEntity;
import com.liziczh.ddd.mesh.domain.repository.DemoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/7/18 0:26
 */
public class DemoRepositoryImpl implements DemoRepository {

    @Autowired
    private TDemoMapper demoMapper;


    @Override
    public List<DemoEntity> selectByCondition(DemoCondition condition) {

        PageCondition pageCondition = condition.getPage();
        List<SortCondition> sortConditionList = condition.getSortList();
        QueryWrapper<TDemo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(TDemo::getName, condition.getName())
                .ge(TDemo::getCreateTime, condition.getStartTime())
                .lt(TDemo::getCreateTime, condition.getEndTime())
                .eq(TDemo::getValid, CommonStatusEnum.VALID.getCode());
        for (SortCondition sortCondition : sortConditionList) {
            queryWrapper.orderByDesc(sortCondition.getColumnName());
        }
        Page<TDemo> demoPage = demoMapper.selectPage(new Page<TDemo>(pageCondition.getPageNo(), pageCondition.getSize()), queryWrapper);
        List<TDemo> records = demoPage.getRecords();

        // toEntity
        List<DemoEntity> entityList = records.parallelStream().map(po -> {
            DemoEntity entity = new DemoEntity();
            BeanUtils.copyProperties(po, entity);
            return entity;
        }).collect(Collectors.toList());

        return entityList;
    }

    @Override
    public DemoEntity get(Long id) {

        TDemo po = demoMapper.selectById(id);

        // toEntity
        DemoEntity entity = DemoEntity.builder().build();
        BeanUtils.copyProperties(po, entity);

        return entity;
    }

    @Override
    public Boolean insert(DemoEntity entity) {

        // toPO
        TDemo po = new TDemo();
        BeanUtils.copyProperties(entity, po);
        po.setCreateTime(new Date());
        int insert = demoMapper.insert(po);

        if (insert >= 0) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public Boolean update(DemoEntity entity) {

        // toPO
        TDemo po = new TDemo();
        BeanUtils.copyProperties(entity, po);
        po.setCreateTime(new Date());
        int update = demoMapper.updateById(po);

        if (update >= 0) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public Boolean deleteById(Long id) {
        int delete = demoMapper.deleteById(id);

        if (delete >= 0) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
