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

import com.liziczh.ddd.mesh.api.condition.DemoCondition;
import com.liziczh.ddd.mesh.api.dto.DemoDTO;
import com.liziczh.ddd.mesh.api.service.DemoService;
import com.liziczh.ddd.mesh.common.response.Response;
import com.liziczh.ddd.mesh.common.response.ResponseBuilder;
import com.liziczh.ddd.mesh.redis.service.DemoRedisService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 逻辑删除枚举
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/1/16 12:50 下午
 */
@Api(value = "示例接口", tags = "示例接口")
@RestController
@RequestMapping(value = "/demo/")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private DemoRedisService demoRedisService;

    @ApiOperation(value = "hello", notes = "测试接口")
    @GetMapping(value = "hello")
    public Response<String> hello() {
        return ResponseBuilder.success("Hello World");
    }

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @PostMapping(value = "/page")
    public Response<List<DemoDTO>> selectPage(@RequestBody DemoCondition condition) throws Exception {
        List<DemoDTO> demoPage = demoService.selectPage(condition);
        return ResponseBuilder.success(demoPage);
    }

    @ApiOperation(value = "条件查询", notes = "分页查询")
    @GetMapping(value = "/select")
    public Response<List<DemoDTO>> selectByCondition(@RequestBody DemoCondition condition) throws Exception {
        List<DemoDTO> demoList = demoService.selectByCondition(condition);
        return ResponseBuilder.success(demoList);
    }

    @ApiOperation(value = "新增接口", notes = "新增接口")
    @PostMapping(value = "add")
    public Response<String> addDemo(DemoDTO demo) throws Exception {
        demoService.addDemo(demo);
        return ResponseBuilder.success();
    }

    @ApiOperation(value = "更新接口", notes = "更新接口")
    @PutMapping(value = "update")
    public Response<String> updateDemo(DemoDTO demo) throws Exception {
        demoService.updateDemo(demo);
        return ResponseBuilder.success();
    }

    @ApiOperation(value = "获取接口", notes = "获取接口")
    @GetMapping(value = "/get/{id}")
    public Response<DemoDTO> geDemoDTO(@PathVariable String id) throws Exception {
        DemoDTO demo = demoService.getDemo(id);
        return ResponseBuilder.success(demo);
    }

    @ApiOperation(value = "删除接口", notes = "删除接口")
    @DeleteMapping(value = "/delete/{id}")
    public Response<Void> deleteDemo(@PathVariable String id) throws Exception {
        demoService.deleteDemo(id);
        return ResponseBuilder.success();
    }

    @ApiOperation(value = "缓存", notes = "缓存")
    @GetMapping(value = "/cache/{key}/{value}")
    public Response<Void> cache(@PathVariable String key, @PathVariable String value) throws Exception {
        demoRedisService.setValue(key, value);
        return ResponseBuilder.success();
    }

    @ApiOperation(value = "REST引用接口测试", notes = "REST引用接口测试")
    @PostMapping(value = "ref/hello")
    public Response<String> refHello() {
        String hello = demoService.refHello();
        return ResponseBuilder.success(hello);
    }
}
