package ds.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 用户的实体类
 * @author 董帅
 */
public class SysUser implements Serializable {
    private static final long serialVersionUID = 583949293185839911L;

    private int id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    
    
    private List<Role> roles;
    
    
    
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
 
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
