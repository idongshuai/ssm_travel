package ds.service;

import java.util.List;

import ds.domain.SysUser;

/**
 * 用户的service层接口
 * 
 * @author 董帅
 */
public interface SysUserService {

    /**
     * 查询所有用户
     * @return
     */
    List<SysUser> findAllUser();

    /**
     * 添加用户
     * @param user
     */
    void saveUser(SysUser user);

}
