package ds.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import ds.domain.Product;

/**
 * 商品的service层接口
 * 
 * @author 董帅
 */
public interface ProductService {


    /**
     * 查询所有商品
     * @return
     * @throws Exception
     */
    List<Product> findAll() throws Exception;
    
    /**
     * 保存商品
     * @param product
     * @throws Exception
     */ 
    void save(Product product) throws Exception;

    /**
     * 根据id查询产品
     * @param id
     * @return
     */
    Product findProductById(int id) throws Exception;

    /**
     * 根据id修改产品
     * @param product
     * @throws Exception
     */
    void updateProductById(Product product) throws Exception;

    /**
     * 根据id删除产品
     * @param id
     */
    void delProductById(int id) throws Exception;

    /**
     * 分页查询产品
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo findProductByPageHelper(int pageNum, int pageSize) throws Exception;
}
