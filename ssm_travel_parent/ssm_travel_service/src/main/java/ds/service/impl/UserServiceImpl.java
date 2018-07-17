package ds.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ds.dao.SysUserDao;
import ds.domain.Role;
import ds.domain.SysUser;
import ds.service.UserService;

/**
 * 用户认证的service层实现类
 * 
 * @author 董帅
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    
    @Autowired
    private SysUserDao sysUserDao;

    /**
     * 该方法时认证的方法
     * 先编写一个默认的认证代码
     * 参数就是表单提交的用户名
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        List<GrantedAuthority> authorities = new ArrayList<>();
        
        //传入角色
        
        
        //通过用户名查询用户
        SysUser sysUser = sysUserDao.findSysUserByUsername(username);
        
        if (sysUser != null) {
            List<Role> roles = sysUser.getRoles();
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            }
            
          //创建用户
            User user = new User(username, sysUser.getPassword(), authorities);
            
            return user;
           
        }
        
        return null;
        
        
    }

    
    /**
     * 根据id查询用户
     */
    @Override
    public SysUser findUserById(int id) throws Exception {
        return sysUserDao.findUserById(id);
    }


    /**
     * 给用户分配角色
     */
    @Override
    public void addRoleToUser(int userId, int[] ids) throws Exception {
        //先从中间表删除用户的角色
        sysUserDao.deleteUserRole(userId);
        
        //再添加数据
        if (ids != null) {
            for (int roleId : ids) {
                //给用户分配角色
                sysUserDao.addRoleToUser(userId,roleId);
            }
        }
    }

}
