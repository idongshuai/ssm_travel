package ds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ds.domain.Permission;
import ds.service.PermissionService;

/**
 * 权限
 * @author 董帅
 */
@Controller
@RequestMapping("/permission")
@Secured("ROLE_ADMIN")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;
    
    /**
     * 查询所有权限
     */
    @RequestMapping("/findAllPermission")
    public String findAllPermission(Model model) {
        model.addAttribute("permissionList", permissionService.findAllPermission());
        return "permission/permission-list";
    }
    
    /**
     * 添加权限
     * @return
     */
    @RequestMapping("/savePermission")
    public String savePermission(Permission permission) {
        permissionService.savePermission(permission);
        return "redirect:/permission/findAllPermission";
    }
}
