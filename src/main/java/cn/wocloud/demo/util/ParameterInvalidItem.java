package cn.wocloud.demo.util;

/**
 * @Author: zyp
 * @Date: 2021/8/9 19:52
 * @Param
 * @return
 * @Version 1.0
 * 参数无效项
 */
public class ParameterInvalidItem {
    /**
     * 无效字段的名称
     */
    private String fieldName;

    /**
     * 错误信息
     */
    private String message;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
