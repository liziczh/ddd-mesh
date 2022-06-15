package com.liziczh.ddd.mesh.application.convertor;

import java.util.List;

import org.mapstruct.Mapper;

import com.liziczh.ddd.mesh.api.dto.DemoDTO;
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
public interface DemoDTOConvertor {

    DemoDTO toDTO(DemoEntity entity);

    List<DemoDTO> toDTOList(List<DemoEntity> entityList);

}
