package cn.wocloud.demo.customize;

import cn.wocloud.demo.common.enums.ResultCode;

/**
 * @Author: zyp
 * @Date: 2021/8/9 19:33
 * @Param
 * @return
 * @Version 1.0
 *  用户未登录异常
 */
public class UserNotLoginException extends BusinessException{

    public UserNotLoginException() {
        super();
    }

    public UserNotLoginException(String msg) {
        super(msg);
    }

    public UserNotLoginException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
