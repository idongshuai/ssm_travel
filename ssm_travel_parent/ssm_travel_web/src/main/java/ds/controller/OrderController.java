package ds.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ds.service.OrderService;

/**
 * 订单的Controller
 * 
 * @author 董帅
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    
    /**
     * 查询所有的订单
     * @throws Exception 
     */
    @RequestMapping("findAllOrder")
    public String findAllOrder(Model model) throws Exception {
        
        model.addAttribute("orderList", orderService.findAllOrder());
        return "order/order-list";
    }
}
