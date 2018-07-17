package ds.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ds.domain.Role;
import ds.domain.SysUser;
import ds.service.RoleService;
import ds.service.SysUserService;
import ds.service.UserService;

/**
 * 用户的Controller
 * 
 * @author 董帅
 */
@Controller
@RequestMapping("/sysUser")
@Secured("ROLE_ADMIN")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;
    
    @Autowired
    private UserService userService;
    
    
    @Autowired
    private RoleService roleService;
    
    /**
     * 查询所有用户
     * @param model
     * @return
     */
    @RequestMapping("/findAllUser")
    public String findAllUser(Model model) {
        List<SysUser> list = sysUserService.findAllUser();
        model.addAttribute("userList", sysUserService.findAllUser());
        System.out.println(list);
        return "user/user-list";
    }
    
    /**
     * 跳转到新建用户页面
     * @return
     */
    @RequestMapping("/initSaveUser")
    public String initSaveUser() {
        
        return "user/user-add";
    }
    
    
    /**
     * 添加用户
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(SysUser user) {
        sysUserService.saveUser(user);
        return "redirect:/sysUser/findAllUser";
    }
    
    
    /**
     * 根据id查询用户
     * @param id
     * @return
     * @throws Exception 
     */
    @RequestMapping("/findUserById")
    public String findUserById(int id, Model model) throws Exception {
        
        
        SysUser user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "user/user-show";
    }
    
    /**
     * 跳转到添加角色的页面
     * @throws Exception 
     */
    @RequestMapping("/initAddRole")
    public String initAddRole(int id, Model model) throws Exception {
        
        //这一步查出来的user没有id, 待解决
        SysUser user = userService.findUserById(id);
        
        user.setId(id);
        
        //用户所拥有的角色
        List<Role> roles = user.getRoles();
        StringBuilder sb = new StringBuilder();
        for (Role role : roles) {
            sb.append(role.getRoleName());
            sb.append(",");
        }
        String roleStr = sb.toString();
        
        //查询所有的角色
        List<Role> roleList = roleService.findAllRole();
        
        model.addAttribute("user", user);
        model.addAttribute("roleStr", roleStr);
        model.addAttribute("roleList", roleList);
        
        return "user/user-role-add";
        
    }
    
    /**
     * 给用户设置角色
     * @throws Exception 
     */
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(int userId, int[] ids) throws Exception {
        userService.addRoleToUser(userId, ids);
        return "redirect:/sysUser/findAllUser";
    }
    
}
