package cn.wocloud.demo.enums;

import lombok.Data;

/**
 * @Author: zyp
 * @Date: 2020/11/20 11:20
 * @Param ${param}
 * @return ${return}
 * @Version 1.0
 */

public enum  MessageEnum {

    SYSTEM("1","系统消息"),
    WEILAN_FOR_HUOZHU("2","围栏给货主发消息"),
    WEILAN_FOR_CHEZHU("3","围栏给车主发消息"),
    ORDER_STATE("4","运单状态消息"),
    USER_FLEET("5","用户车队推送信息"),
    VOICE_NOTICE("6","语音播报通知"),
    ACCOUNT_DISABLE("7","账户禁用通知");

    private String type;    //类型
    private String desc;    //描述

    private MessageEnum(String type,String desc){
        this.type=type;
        this.desc=desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
