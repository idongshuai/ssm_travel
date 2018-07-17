package ds.service;

import java.util.List;

import ds.domain.Order;

/**
 * 订单的service层接口
 * @author 董帅
 */
public interface OrderService {

    /**
     * 查询所有的订单
     * @return
     */
    List<Order> findAllOrder() throws Exception;

}
