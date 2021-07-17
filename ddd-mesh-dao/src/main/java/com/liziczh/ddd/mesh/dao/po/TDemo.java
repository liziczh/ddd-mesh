package com.liziczh.ddd.mesh.dao.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "t_demo")
public class TDemo implements Serializable {
	private static final long serialVersionUID = -3399850105386695874L;

	@TableId(value = "ID", type = IdType.AUTO)
	private Integer id;

	@TableField(value = "NAME")
	private String name;

	@TableField(value = "CREATE_TIME")
	private Date createTime;

	@TableField(value = "CREATE_USER")
	private String createUser;

	@TableField(value = "UPDATE_TIME")
	private Date updateTime;

	@TableField(value = "UPDATE_USER")
	private String updateUser;

	@TableField(value = "PERMIT_ROLE")
	private String permitRole;

	@TableField(value = "VALID")
	private String valid;
}
