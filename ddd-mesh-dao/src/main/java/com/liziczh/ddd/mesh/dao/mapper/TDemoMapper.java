package com.liziczh.ddd.mesh.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liziczh.ddd.mesh.dao.po.DemoPO;

/**
 * DemoMapper
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/1/16 12:11 上午
 */
@Repository
@Mapper
public interface TDemoMapper extends BaseMapper<DemoPO> {
}
