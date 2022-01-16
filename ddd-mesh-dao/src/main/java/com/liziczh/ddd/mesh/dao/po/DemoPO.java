package com.liziczh.ddd.mesh.dao.po;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * Demo持久化对象
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/1/16 12:11 上午
 */
@Data
@TableName(value = "t_demo")
public class DemoPO {

    /**
     * 自增ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 实例ID
     */
    @TableField(value = "DEMO_ID")
    private String demoId;

    /**
     * 用户ID
     */
    @TableField(value = "USER_ID")
    private String userId;

    /**
     * 名称
     */
    @TableField(value = "NAME")
    private String name;

    /**
     * 状态
     */
    @TableField(value = "STATUS")
    private String status;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME")
    private Date createTime;

    /**
     * 创建人
     */
    @TableField(value = "CREATE_USER")
    private String createUser;

    /**
     * 更新时间
     */
    @TableField(value = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 更新人
     */
    @TableField(value = "UPDATE_USER")
    private String updateUser;

    /**
     * 乐观锁
     */
    @TableField(value = "VERSION")
    private Integer version;

    /**
     * 逻辑删除：0-正常，1-删除
     */
    @TableField(value = "DELETED")
    private Integer deleted;

}
