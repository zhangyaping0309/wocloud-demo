package cn.wocloud.demo.woclouddemo;


import cn.wocloud.demo.enums.Color;
import cn.wocloud.demo.enums.MessageEnum;
import cn.wocloud.demo.enums.Operator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zyp
 * @Date: 2020/11/20 10:30
 * @Param ${param}
 * @return ${return}
 * @Version 1.0
 */
public class EnumTest {




    @Test
    public void  meijuTest(){



        System.out.println( Operator.valueOf("ADMIN"));
        System.out.println(Operator.ADMIN);
        System.out.println(Operator.ADMIN.name());
        Operator[] values1 = Operator.values();
        for (Operator operator : values1) {
            System.out.println(operator);
        }

        MessageEnum system = MessageEnum.SYSTEM;
        System.out.println(system);
        System.out.println(system.name());
        System.out.println(system.getType());
        System.out.println(system.getDesc());

        System.out.println(Color.BLACK);
        System.out.println(Color.valueOf("BLACK"));
        Color[] values = Color.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }


    }

    @Test
    public void test(){
        List<Object> objects = new ArrayList<>();
        Object[] objects1 = objects.toArray();
    }























































































































































































































































































































































}
