package cn.wocloud.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import cn.wocloud.demo.model.TOrder;
import cn.wocloud.demo.mapper.TOrderMapper;
import cn.wocloud.demo.service.TOrderService;

@Service
public class TOrderServiceImpl implements TOrderService{

    @Resource
    private TOrderMapper tOrderMapper;

    @Override
    public int insert(TOrder tOrder){
        return tOrderMapper.insert(tOrder);
    }

    @Override
    public int insertSelective(TOrder tOrder){
        return tOrderMapper.insertSelective(tOrder);
    }

    @Override
    public int insertList(List<TOrder> tOrders){
        return tOrderMapper.insertList(tOrders);
    }

    @Override
    public int updateByPrimaryKeySelective(TOrder tOrder){
        return tOrderMapper.updateByPrimaryKeySelective(tOrder);
    }
}
