package ds.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import ds.domain.SysUser;

/**
 * 用户人的的service层接口
 * 
 * @author 董帅
 */
public interface UserService extends UserDetailsService {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    SysUser findUserById(int id) throws Exception;

    /**
     * 给用户设置角色
     * @param userId
     * @param ids
     */
    void addRoleToUser(int userId, int[] ids) throws Exception;

}
