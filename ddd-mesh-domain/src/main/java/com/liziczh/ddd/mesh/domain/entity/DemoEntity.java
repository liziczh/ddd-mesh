package com.liziczh.ddd.mesh.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/7/18 0:18
 */
@Slf4j
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DemoEntity {

    private String name;

}
