package ds.domain;

import java.util.List;

/**
 * 用户角色
 * 
 * @author 董帅
 */
public class Role {
    
    private int id;
    private String roleName;
    private String roleDesc;
    
    private List<SysUser> sysUserList;
    
    private List<Permission> permissions;
    
    
    public List<SysUser> getSysUserList() {
        return sysUserList;
    }
    public void setSysUserList(List<SysUser> sysUserList) {
        this.sysUserList = sysUserList;
    }
  
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getRoleDesc() {
        return roleDesc;
    }
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
    public List<Permission> getPermissions() {
        return permissions;
    }
    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
    
    
}
