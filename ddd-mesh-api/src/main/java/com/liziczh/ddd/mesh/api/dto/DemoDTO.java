package com.liziczh.ddd.mesh.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DemoDTO implements Serializable {
    private static final long serialVersionUID = -3640216333547585805L;
    @ApiModelProperty(value = "姓名")
    @JsonProperty("name")
    private String name;
}
