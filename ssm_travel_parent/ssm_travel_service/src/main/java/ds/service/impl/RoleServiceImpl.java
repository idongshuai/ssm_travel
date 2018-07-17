package ds.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ds.dao.RoleDao;
import ds.domain.Role;
import ds.service.RoleService;

/**
 * 角色
 * @author 董帅
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    /**
     * 查询所有角色
     */
    @Override
    public List<Role> findAllRole() {
        return roleDao.findAllRole();
    }

    /**
     * 保存角色
     */
    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }
}
