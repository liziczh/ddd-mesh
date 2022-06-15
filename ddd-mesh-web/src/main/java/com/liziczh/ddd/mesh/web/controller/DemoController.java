package com.liziczh.ddd.mesh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liziczh.ddd.mesh.api.common.response.BaseResponse;
import com.liziczh.ddd.mesh.api.dto.DemoDTO;
import com.liziczh.ddd.mesh.api.dto.DemoOptDTO;
import com.liziczh.ddd.mesh.api.req.DemoCommandReq;
import com.liziczh.ddd.mesh.api.req.DemoQueryReq;
import com.liziczh.ddd.mesh.api.service.DemoApiService;
import com.liziczh.ddd.mesh.common.response.ResponseBuilder;
import com.liziczh.ddd.mesh.redis.service.DemoRedisService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 示例Controller
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/1/16 12:50 下午
 */
@Api(value = "示例接口", tags = "示例接口")
@RestController
@RequestMapping(value = "/api/demo/v1.0")
public class DemoController {

    @Autowired
    private DemoApiService demoService;

    @Autowired
    private DemoRedisService demoRedisService;

    @ApiOperation(value = "测试接口", notes = "测试接口")
    @GetMapping(value = "/hello")
    public BaseResponse<String> hello() {
        return ResponseBuilder.success("Hello World");
    }

    @ApiOperation(value = "分页条件查询", notes = "分页条件查询")
    @PostMapping(value = "/page")
    public BaseResponse<List<DemoDTO>> queryPage(@RequestBody DemoQueryReq req) {
        return demoService.queryPage(req);
    }

    @ApiOperation(value = "查询详情接口", notes = "获取接口")
    @GetMapping(value = "/get/{demoId}")
    public BaseResponse<DemoDTO> geDemoDTO(@PathVariable Long demoId) {
        return demoService.getDemo(demoId);
    }

    @ApiOperation(value = "新增接口", notes = "新增接口")
    @PostMapping(value = "/add")
    public BaseResponse<DemoOptDTO> addDemo(@RequestBody DemoCommandReq req) {
        return demoService.addDemo(req);
    }

    @ApiOperation(value = "更新接口", notes = "更新接口")
    @PutMapping(value = "update")
    public BaseResponse<DemoOptDTO> updateDemo(@RequestBody DemoCommandReq req) {
        return demoService.updateDemo(req);
    }

    @ApiOperation(value = "删除接口", notes = "删除接口")
    @DeleteMapping(value = "/delete/{demoId}")
    public BaseResponse<DemoOptDTO> deleteDemo(@PathVariable Long demoId) {
        return demoService.deleteDemo(demoId);
    }

    @ApiOperation(value = "缓存", notes = "缓存")
    @GetMapping(value = "/cache/{key}/{value}")
    public BaseResponse<Void> cache(@PathVariable String key, @PathVariable String value) {
        demoRedisService.setValue(key, value);
        return ResponseBuilder.success();
    }

    @ApiOperation(value = "REST引用接口测试", notes = "REST引用接口测试")
    @PostMapping(value = "ref/test")
    public BaseResponse<String> refTest() {
        return demoService.refTest();
    }
}
