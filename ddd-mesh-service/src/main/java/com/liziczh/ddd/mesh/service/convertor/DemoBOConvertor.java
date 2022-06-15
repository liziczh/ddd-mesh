package com.liziczh.ddd.mesh.service.convertor;

import java.util.List;

import org.mapstruct.Mapper;

import com.liziczh.ddd.mesh.domain.entity.DemoEntity;
import com.liziczh.ddd.mesh.service.bo.DemoBO;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/6/15 7:13 下午
 */
@Mapper(componentModel = "spring")
public interface DemoBOConvertor {

    DemoBO toBO(DemoEntity entity);

    List<DemoBO> toBOList(List<DemoEntity> entityList);

}
