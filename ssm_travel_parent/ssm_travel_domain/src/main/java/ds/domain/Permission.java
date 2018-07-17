package ds.domain;

import java.util.List;

/**
 * 权限资源
 * 
 * @author 董帅
 */
public class Permission {
    
    private int id;
    private String permissionName;
    private String url;
    
    private List<Role> roleList;
    
    
    public List<Role> getRoleList() {
        return roleList;
    }
    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
  
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPermissionName() {
        return permissionName;
    }
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
