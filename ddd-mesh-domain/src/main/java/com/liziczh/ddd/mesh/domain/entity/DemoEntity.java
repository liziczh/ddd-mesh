package com.liziczh.ddd.mesh.domain.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DemoEntity {

    private Integer id;

    private String demoId;

    private String userId;

    private String name;

    private String status;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    private String version;

    private String deleted;

}
