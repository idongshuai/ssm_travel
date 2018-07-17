package ds.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import ds.domain.Product;

/**
 * 商品的dao层接口
 * 
 * @author 董帅
 */
@Repository
public interface ProductDao {
    
    /**
     * 查询所有商品
     * @return
     * @throws Exception
     */
    @Select("select * from product")
    List<Product> findAll() throws Exception;
    
    /**
     * 保存商品
     * @param product
     * @throws Exception
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,"
            + "productPrice,productDesc,productStatus)"
            + " values(#{productNum},#{productName},#{cityName},"
            + "#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    /**
     * 根据id查询产品
     * @param id
     * @return
     */
    @Select("select * from product where id=#{id}")
    Product findProductById(int id) throws Exception;

    /**
     * 根据id修改产品
     * @param product
     */
    @Update("update product set productNum=#{productNum},productName=#{productName},"
            + "cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},"
            + "productDesc=#{productDesc},productStatus=#{productStatus} where id=#{id}")
    void updateProductById(Product product) throws Exception;

    /**
     * 根据id删除产品
     * @param id
     */
    @Delete("delete from product where id=#{id}")
    void delProductById(int id);
}
