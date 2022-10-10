package cn.wocloud.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zyp
 * @Date: 2021/6/16 16:05
 * @Param ${param}
 * @return ${return}
 * @Version 1.0
 */
@Configuration
@MapperScan(basePackages = {MybatisMasterConfig.PACKAGE} )
public class MybatisMasterConfig {
    static final String PACKAGE = "cn.wocloud.demo.mapper";
}
