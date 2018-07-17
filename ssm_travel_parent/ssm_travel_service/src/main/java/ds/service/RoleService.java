package ds.service;

import java.util.List;

import ds.domain.Role;

/**
 * 角色
 * @author 董帅
 */
public interface RoleService {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAllRole();

    /**
     * 保存角色
     * @param role
     */
    void saveRole(Role role);

}
