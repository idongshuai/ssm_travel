package ds.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ds.dao.PermissionDao;
import ds.domain.Permission;
import ds.service.PermissionService;

/**
 * 权限
 * @author 董帅
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    /**
     * 查询所有权限
     */
    @Override
    public List<Permission> findAllPermission() {
        return permissionDao.findAllPermission();
    }

    /**
     * 添加权限
     */
    @Override
    public void savePermission(Permission permission) {
        permissionDao.savePermission(permission);
    }
}
