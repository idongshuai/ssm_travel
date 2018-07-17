package ds.service;

import java.util.List;

import ds.domain.Permission;

/**
 * 权限
 * @author 董帅
 */
public interface PermissionService {

    /**
     * 查询所有权限
     * @return
     */
    List<Permission> findAllPermission();

    /**
     * 添加权限
     * @param permission
     */
    void savePermission(Permission permission);

}
