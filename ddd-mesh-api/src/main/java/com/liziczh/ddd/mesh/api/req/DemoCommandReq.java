package com.liziczh.ddd.mesh.api.req;

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
public class DemoCommandReq {

    @ApiModelProperty(value = "用户ID")
    @JsonProperty("userId")
    private Long userId;

    @ApiModelProperty(value = "名称")
    @JsonProperty("name")
    private String name;

    @ApiModelProperty(value = "描述")
    @JsonProperty("desc")
    private String desc;

    @ApiModelProperty(value = "状态")
    @JsonProperty("status")
    private Integer status;

}
