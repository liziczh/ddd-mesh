package com.liziczh.ddd.mesh.dao.convertor;

import java.util.List;

import org.mapstruct.Mapper;

import com.liziczh.ddd.mesh.dao.po.DemoPO;
import com.liziczh.ddd.mesh.domain.entity.DemoEntity;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/6/15 7:13 下午
 */
@Mapper(componentModel = "spring")
public interface DemoPOConvertor {

    DemoEntity toEntity(DemoPO po);

    List<DemoEntity> toEntityList(List<DemoPO> poList);

    DemoPO toPO(DemoEntity entity);

}
