package cn.wocloud.demo.controller;

import cn.wocloud.demo.common.result.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zyp
 * @Date: 2021/8/9 20:01
 * @Param
 * @return
 * @Version 1.0
 */
@RestController
@RequestMapping("customize")
@Api(value = "用户接口", tags = {"用户接口"})
public class CustomizeController {

    @ApiOperation("新增用户")
    @GetMapping(value = "/test")
    public CommonResult test(@RequestParam(name = "param") int param) {
        return CommonResult.success();
    }
}
