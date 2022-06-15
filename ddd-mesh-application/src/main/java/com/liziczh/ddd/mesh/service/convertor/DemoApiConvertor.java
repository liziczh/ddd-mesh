package com.liziczh.ddd.mesh.service.convertor;

import java.util.List;

import org.mapstruct.Mapper;

import com.liziczh.ddd.mesh.api.dto.DemoDTO;
import com.liziczh.ddd.mesh.api.dto.DemoOptDTO;
import com.liziczh.ddd.mesh.service.bo.DemoBO;
import com.liziczh.ddd.mesh.service.bo.DemoOptBO;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/6/15 7:13 下午
 */
@Mapper(componentModel = "spring")
public interface DemoApiConvertor {

    DemoDTO toDTO(DemoBO bo);

    DemoOptDTO toDTO(DemoOptBO bo);

    List<DemoDTO> toDTOList(List<DemoBO> boList);

}
