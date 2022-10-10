package cn.wocloud.demo.customize;

import cn.wocloud.demo.common.enums.BusinessExceptionEnum;
import cn.wocloud.demo.common.enums.ResultCode;

/**
 * @Author: zyp
 * @Date: 2021/8/9 19:28
 * @Param
 * @return
 * @Version 1.0
 * 业务异常类
 */
public class BusinessException extends RuntimeException{
    protected Integer code;
    protected String message;
    protected ResultCode resultCode;

    protected Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BusinessException() {
        BusinessExceptionEnum businessExceptionEnum = BusinessExceptionEnum.getByEClass(this.getClass());
        if (businessExceptionEnum != null) {
            this.code = businessExceptionEnum.getResultCode().getCode();
            this.resultCode = businessExceptionEnum.getResultCode();
            this.message = businessExceptionEnum.getResultCode().getMessage();
        }
    }

    public BusinessException(String message) {
        this();
        this.message = message;
    }

    public BusinessException(String format, Object... objects) {
        this();
        this.message = String.format(format, "{}", objects);
    }

    public BusinessException(ResultCode resultCode, Object data) {
        this(resultCode);
        this.data = data;
    }

    public BusinessException(ResultCode resultCode) {
        this.resultCode = resultCode;
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }
}
