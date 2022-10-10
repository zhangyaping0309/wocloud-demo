package cn.wocloud.demo.customize;

import cn.wocloud.demo.common.enums.ResultCode;

/**
 * @Author: zyp
 * @Date: 2021/8/9 19:33
 * @Param
 * @return
 * @Version 1.0
 *  远程访问异常
 */
public class RemoteAccessException extends BusinessException{

    public RemoteAccessException() {
        super();
    }

    public RemoteAccessException(Object data) {
        super.data = data;
    }

    public RemoteAccessException(ResultCode resultCode) {
        super(resultCode);
    }

    public RemoteAccessException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public RemoteAccessException(String msg) {
        super(msg);
    }

    public RemoteAccessException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
