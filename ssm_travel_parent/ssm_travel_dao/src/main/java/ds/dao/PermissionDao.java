package ds.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import ds.domain.Permission;

/**
 * 权限
 * @author 董帅
 */
@Repository
public interface PermissionDao {

    /**
     * 根据角色id查询权限
     * @param id
     * @return
     */
    @Select("select sp.* from sys_permission sp,sys_role_permission srp "
            + "where sp.id=srp.permissionId and srp.roleId=#{id}")
    public List<Permission> findByRoleId(int id);

    /**
     * 查询所有权限
     * @return
     */
    @Select("select * from sys_permission")
    public List<Permission> findAllPermission();

    /**
     * 添加权限
     * @param permission
     */
    @Insert("insert into sys_permission (permissionName,url) values (#{permissionName},#{url})")
    public void savePermission(Permission permission);
}
