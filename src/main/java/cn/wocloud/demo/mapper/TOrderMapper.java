package cn.wocloud.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.wocloud.demo.model.TOrder;



@Mapper
public interface TOrderMapper {
    int insert(@Param("tOrder") TOrder tOrder);

    int insertSelective(@Param("tOrder") TOrder tOrder);

    int insertList(@Param("tOrders") List<TOrder> tOrders);

    int updateByPrimaryKeySelective(@Param("tOrder") TOrder tOrder);
}
