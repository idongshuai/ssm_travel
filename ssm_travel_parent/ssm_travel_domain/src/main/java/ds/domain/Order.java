package ds.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import ds.utils.DateUtils;

/**
 * @author 董帅
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 1487601680687458373L;

    private int id;
    private String orderNum;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderTime;
    
    private String orderTimeStr;
    
    private int peopleCount;
    private String orderDesc;
    private int payType;
    private int orderStatus;
    
    //外键
    //private int productId;
    private Product product;
    
    
    

    public String getOrderTimeStr() {
        if (orderTime == null) {
            return "";
        } else {
            return DateUtils.dateToStr(orderTime, "yyyy‐MM‐dd HH:mm:ss");
        }
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    
}
