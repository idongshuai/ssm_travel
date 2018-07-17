package ds.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ds.dao.OrderDao;
import ds.domain.Order;
import ds.service.OrderService;

/**
 * 订单的service层实现类
 * 
 * @author 董帅
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    /**
     * 查询所有的订单
     */
    @Override
    public List<Order> findAllOrder() throws Exception {
        return orderDao.findAllOrder();
    }
}
