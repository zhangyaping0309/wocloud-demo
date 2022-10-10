package cn.wocloud.demo.common.result;

import cn.wocloud.demo.common.enums.ResultCode;

/**
 * @Author: zyp
 * @Date: 2021/8/9 19:22
 * @Param
 * @return
 * @Version 1.0
 */
public class CommonResult<T> implements ResponseResult {
    private Integer code;

    private String msg;

    private T data;

    public CommonResult() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CommonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static CommonResult success() {
        CommonResult result = new CommonResult();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static <T> CommonResult success(T data) {
        CommonResult result = new CommonResult();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static CommonResult failure(ResultCode resultCode) {
        CommonResult result = new CommonResult();
        result.setResultCode(resultCode);
        return result;
    }

    public static <T> CommonResult failure(ResultCode resultCode, T data) {
        CommonResult result = new CommonResult();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public static CommonResult failure(String message) {
        CommonResult result = new CommonResult();
        result.setCode(ResultCode.PARAM_IS_INVALID.getCode());
        result.setMsg(message);
        return result;
    }

    private void setResultCode(ResultCode code) {
        this.code = code.getCode();
        this.msg = code.getMessage();
    }
}
