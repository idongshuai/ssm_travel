package ds.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import ds.utils.DateUtils;

/**
 * 商品的实体类
 * 
 * @author 董帅
 */
public class Product implements Serializable {

    private static final long serialVersionUID = -571363319317120503L;
    
    private int id;
    private String productNum;
    private String productName;
    private String cityName;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;

    private String departureTimeStr;
    private double productPrice;
    private String productDesc;
    private int productStatus;

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        if (departureTime == null) {
            return "";
        } else {
            return DateUtils.dateToStr(departureTime, "yyyy‐MM‐dd HH:mm");
        }

    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

}
