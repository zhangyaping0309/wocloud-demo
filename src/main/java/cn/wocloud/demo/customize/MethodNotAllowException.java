package cn.wocloud.demo.customize;

import cn.wocloud.demo.common.enums.ResultCode;

/**
 * @Author: zyp
 * @Date: 2021/8/9 19:33
 * @Param
 * @return
 * @Version 1.0
 * 方法不允许异常
 */
public class MethodNotAllowException extends BusinessException{
    public MethodNotAllowException() {
        super();
    }

    public MethodNotAllowException(Object data) {
        super.data = data;
    }

    public MethodNotAllowException(ResultCode resultCode) {
        super(resultCode);
    }

    public MethodNotAllowException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public MethodNotAllowException(String msg) {
        super(msg);
    }

    public MethodNotAllowException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
