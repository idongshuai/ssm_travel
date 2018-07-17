package ds.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import ds.domain.Product;
import ds.service.ProductService;

/**
 * 产品的Controller
 * 
 * @author 董帅
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    
    /**
     * 查询所有产品
     * @return
     * @throws Exception 
     */
    @RequestMapping("/findAllProduct")
    public String findAllProduct(Model model) throws Exception {
        
        model.addAttribute("productList", productService.findAll());
        return "product/product-list";
    }
    
    /**
     * 使用PageHelper分页的方式, 查询产品
     * @throws Exception 
     */
    @RequestMapping("findProductByPageHelper")
    public String findProductByPageHelper(
            @RequestParam(required=true,defaultValue="1") int pageNum,
            @RequestParam(required=true,defaultValue="5") int pageSize,
            Model model) throws Exception {
        
        //分页查询产品
        PageInfo page = productService.findProductByPageHelper(pageNum, pageSize);
        model.addAttribute("page", page);
        
        return "product/product-list";
    }
    
    
    
    /**
     * 跳转到新增产品页面
     * @return
     */
    @RequestMapping("/initAddProduct")
    public String initAddProduct() {
        return "product/product-add";
    }
    
    /**
     * 保存产品
     * @throws Exception 
     */
    @RequestMapping("/saveProduct")
    public String saveProduct(Product product) throws Exception {
        productService.save(product);
        return "redirect:/product/findAllProduct";
    }
    
    /**
     * 跳转到产品修改页面
     * @throws Exception 
     */
    @RequestMapping("/initUpdateProduct")
    public String initUpdateProduct(int id, Model model) throws Exception {
        //根据id查询产品
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "product/product-update";
    }
    
    /**
     * 根据id修改产品
     * @param id
     * @return
     * @throws Exception 
     */
    @RequestMapping("/updateProductById")
    public String updateProductById(Product product) throws Exception {
        productService.updateProductById(product);
        return "redirect:/product/findAllProduct";
    }
    
    /**
     * 根据id删除产品
     * @throws Exception 
     */
    @RequestMapping("/delProductById")
    public String delProductById(int id) throws Exception {
        productService.delProductById(id);
        return "redirect:/product/findAllProduct";
    }
    
    /**
     * 类型转换
     * 
     * @param dataBinder
     */
    /*@InitBinder
    public void initBinderDate(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Date.class, new PropertiesEditor() {
            // JSP页面传过来的数据
            public void setAsText(String text) throws IllegalArgumentException {
                // 把字符串转换成日期
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy‐MM‐dd HH:mm");
                try {
                    Date date = sdf.parse(text);
                    // 设置值
                    super.setValue(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }*/
}
