package ds.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ds.dao.ProductDao;
import ds.domain.Product;
import ds.service.ProductService;

/**
 * 产品的service层实现类
 * 
 * @author 董帅
 */
@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductDao productDao;

    /**
     * 查询所有产品
     */
    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    /**
     * 保存产品
     */
    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
        
    }

    /**
     * 根据id查询产品
     */
    @Override
    public Product findProductById(int id) throws Exception {
        return productDao.findProductById(id);
    }

    /**
     * 根据id修改产品
     */
    @Override
    public void updateProductById(Product product) throws Exception {
        productDao.updateProductById(product);
        
    }

    /**
     * 根据id删除产品
     */
    @Override
    public void delProductById(int id) throws Exception {
       productDao.delProductById(id);
        
    }

    /**
     * 分页查询产品
     */
    @Override
    public PageInfo findProductByPageHelper(int pageNum, int pageSize) throws Exception {
        
        //设置第几页, 每页查询的条数
        PageHelper.startPage(pageNum, pageSize);
        //后面必须跟着查询所有数据的方法（注意，不是分页的方法，是查询所有数据的方法）
        List<Product> productList = productDao.findAll();
        
        //创建PageInfo类
        PageInfo<Product> page = new PageInfo<>(productList);
        
        return page;
    }
}
