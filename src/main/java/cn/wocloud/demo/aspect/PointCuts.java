package cn.wocloud.demo.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author: zyp
 * @Date: 2021/6/16 15:36
 * @Param ${param}
 * @return ${return}
 * @Version 1.0
 */
public class PointCuts {

    @Pointcut(value = "within(cn.wocloud.demo.controller.*)")
    public void aopDemo() {

    }
}
