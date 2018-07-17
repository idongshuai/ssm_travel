package ds.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ds.domain.Role;
import ds.service.RoleService;

/**
 * 角色
 * @author 董帅
 */
@Controller
@RequestMapping("/role")
/*@RolesAllowed("ROLE_ADMIN")*/
@Secured("ROLE_ADMIN")
public class RoleController {
    
    @Autowired
    private RoleService roleService;
    
    /**
     * 查询所有角色
     * @return
     */
    @RequestMapping("/findAllRole")
    public String findAllRole(Model model) {
        model.addAttribute("roleList", roleService.findAllRole());
        return "role/role-list";
    }
    
    /**
     * 保存角色
     */
    @RequestMapping("/saveRole")
    public String saveRole(Role role) {
        roleService.saveRole(role);
        return "redirect:/role/findAllRole";
    }

}
