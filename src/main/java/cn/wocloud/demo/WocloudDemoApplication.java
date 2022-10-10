package cn.wocloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: zyp
 * @Date: 2020/11/13 14:37
 * @Param ${param}
 * @return ${return}
 * @Version 1.0
 */
@ComponentScan(basePackages = {
        "cn.wocloud.demo.controller","cn.wocloud.demo.config","cn.wocloud.demo.service"
})
@SpringBootApplication
public class WocloudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WocloudDemoApplication.class,args);
    }

}
