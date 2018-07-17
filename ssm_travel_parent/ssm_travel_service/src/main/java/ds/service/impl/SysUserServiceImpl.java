package ds.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ds.dao.SysUserDao;
import ds.domain.SysUser;
import ds.service.SysUserService;

/**
 * 用户的service层实现类
 * 
 * @author 董帅
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;
    
    /**
     * 查询所有用户
     */
    @Override
    public List<SysUser> findAllUser() {
        return sysUserDao.findAllUser();
    }

    /**
     * 添加用户
     */
    @Override
    public void saveUser(SysUser user) {
        //密码加密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        
        sysUserDao.saveUser(user);
    }
}
