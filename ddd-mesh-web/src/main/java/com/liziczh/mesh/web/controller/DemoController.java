package com.liziczh.mesh.web.controller;

import com.liziczh.archetype.redis.service.DemoRedisService;
import com.liziczh.ddd.mesh.api.condition.DemoCondition;
import com.liziczh.ddd.mesh.api.dto.DemoDTO;
import com.liziczh.ddd.mesh.api.service.DemoService;
import com.liziczh.ddd.mesh.common.controller.BaseController;
import com.liziczh.ddd.mesh.common.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "示例接口", tags = "示例接口")
@RequestMapping(value = "/demo/")
@RestController
public class DemoController extends BaseController {
    @Autowired
    private DemoService demoService;
    @Autowired
    private DemoRedisService demoRedisService;

    @ApiOperation(value = "hello", notes = "测试接口")
    @GetMapping(value = "hello")
    public Response<String> hello() {
        return Response.success("Hello World");
    }

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @PostMapping(value = "/page")
    public Response<List<DemoDTO>> selectPage(@RequestBody DemoCondition condition) throws Exception {
        List<DemoDTO> demoPage = demoService.selectPage(condition);
        return Response.success(demoPage);
    }

    @ApiOperation(value = "条件查询", notes = "分页查询")
    @GetMapping(value = "/select")
    public Response<List<DemoDTO>> selectByCondition(@RequestBody DemoCondition condition) throws Exception {
        List<DemoDTO> demoList = demoService.selectByCondition(condition);
        return Response.success(demoList);
    }

    @ApiOperation(value = "新增接口", notes = "新增接口")
    @PostMapping(value = "add")
    public Response<String> addDemo(DemoDTO demo) throws Exception {
        demoService.addDemo(demo);
        return Response.success();
    }

    @ApiOperation(value = "更新接口", notes = "更新接口")
    @PutMapping(value = "update")
    public Response<String> updateDemo(DemoDTO demo) throws Exception {
        demoService.updateDemo(demo);
        return Response.success();
    }

    @ApiOperation(value = "获取接口", notes = "获取接口")
    @GetMapping(value = "/get/{id}")
    public Response<DemoDTO> geDemoDTO(@PathVariable String id) throws Exception {
        DemoDTO demo = demoService.getDemo(id);
        return Response.success(demo);
    }

    @ApiOperation(value = "删除接口", notes = "删除接口")
    @DeleteMapping(value = "/delete/{id}")
    public Response<String> deleteDemo(@PathVariable String id) throws Exception {
        demoService.deleteDemo(id);
        return Response.success();
    }

    @ApiOperation(value = "缓存", notes = "缓存")
    @GetMapping(value = "/cache/{key}/{value}")
    public Response<String> cache(@PathVariable String key, @PathVariable String value) throws Exception {
        demoRedisService.setValue(key, value);
        return Response.success();
    }

    @ApiOperation(value = "REST引用接口测试", notes = "REST引用接口测试")
    @PostMapping(value = "ref/hello")
    public Response<String> refHello() {
        String hello = demoService.refHello();
        return Response.success(hello);
    }
}
