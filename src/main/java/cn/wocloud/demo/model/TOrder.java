package cn.wocloud.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Mybatis Generator 2020/12/01
 */
@ApiModel(value = "cn.wocloud.demo.model.TOrder")
@Data
public class TOrder implements Serializable {
    @ApiModelProperty(value = "订单ID")
    private Integer orderId;

    @ApiModelProperty(value = "编码")
    private String enCode;

    @ApiModelProperty(value = "下单时间")
    private LocalDateTime orderTime;

    @ApiModelProperty(value = "null")
    private String proCode;

    @ApiModelProperty(value = "订单号")
    private String orderNum;

    @ApiModelProperty(value = "费用编码")
    private String feeCode;

    @ApiModelProperty(value = "费用名称")
    private String feeName;

    @ApiModelProperty(value = "单价")
    private String unitPrice;

    @ApiModelProperty(value = "订单费用")
    private String orderFee;

    @ApiModelProperty(value = "费用周期")
    private String feePeriod;

    @ApiModelProperty(value = "验证")
    private String validity;

    @ApiModelProperty(value = "订单注释")
    private String orderNote;

    private static final long serialVersionUID = 1L;

    public TOrder() {
    }

    protected boolean canEqual(Object other) {
        return other instanceof cn.wocloud.demo.model.TOrder;
    }
}