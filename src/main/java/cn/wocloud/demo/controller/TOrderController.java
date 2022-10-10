package cn.wocloud.demo.controller;

import cn.wocloud.demo.common.result.CommonResult;
import cn.wocloud.demo.model.TOrder;
import cn.wocloud.demo.service.TOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zyp
 * @Date: 2021/8/9 20:01
 * @Param
 * @return
 * @Version 1.0
 */
@RestController
@RequestMapping("order")
@Api(value = "订单接口", tags = {"订单接口"})
public class TOrderController {

    @Autowired
    private TOrderService tOrderService;

    @ApiOperation("创建订单")
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody TOrder tOrder) {
        tOrderService.insert(tOrder);
        return CommonResult.success();
    }
}
