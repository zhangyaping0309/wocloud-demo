package cn.wocloud.demo.customize;

import cn.wocloud.demo.common.enums.ResultCode;

/**
 * @Author: zyp
 * @Date: 2021/8/9 19:33
 * @Param
 * @return
 * @Version 1.0
 * 权限不足异常
 */
public class PermissionForbiddenException extends BusinessException{

    public PermissionForbiddenException() {
        super();
    }

    public PermissionForbiddenException(Object data) {
        super.data = data;
    }

    public PermissionForbiddenException(ResultCode resultCode) {
        super(resultCode);
    }

    public PermissionForbiddenException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public PermissionForbiddenException(String msg) {
        super(msg);
    }

    public PermissionForbiddenException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
