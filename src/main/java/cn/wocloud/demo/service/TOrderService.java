package cn.wocloud.demo.service;

import java.util.List;
import cn.wocloud.demo.model.TOrder;
public interface TOrderService{

    int insert(TOrder tOrder);

    int insertSelective(TOrder tOrder);

    int insertList(List<TOrder> tOrders);

    int updateByPrimaryKeySelective(TOrder tOrder);
}
