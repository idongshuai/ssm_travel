package ds.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import ds.domain.Order;

/**
 * 订单的dao层接口
 * 
 * @author 董帅
 */
@Repository
public interface OrderDao {

    /**
     * 查询所有的订单
     * @return
     */
    @Select("select * from orders")
    @Results(
            @Result(column = "productId", property = "product",
                    one = @One(select = "ds.dao.ProductDao.findProductById")
            )
    )
    List<Order> findAllOrder() throws Exception;

}
