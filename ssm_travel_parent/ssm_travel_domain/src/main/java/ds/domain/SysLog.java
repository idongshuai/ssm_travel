package ds.domain;

import java.util.Date;

/**
 * 系统日志
 * 
 * @author 董帅
 */
public class SysLog {

    private Integer id;
    private Date visitTime;
    private String visitTimeStr;
    private String username;
    private String ip;
    private String method;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getVisitTime() {
        return visitTime;
    }
    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }
    public String getVisitTimeStr() {
        return visitTimeStr;
    }
    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    
    
}
