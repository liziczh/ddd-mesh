package com.liziczh.ddd.mesh.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * DemoDTO
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/1/16 12:11 上午
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DemoOptDTO {

    @ApiModelProperty(value = "实体Id")
    @JsonProperty("demoId")
    private Long demoId;

}
