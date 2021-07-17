package com.liziczh.ddd.mesh.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liziczh.ddd.mesh.dao.po.TDemo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TDemoMapper extends BaseMapper<TDemo> {
}
