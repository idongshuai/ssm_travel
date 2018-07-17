package ds.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import ds.domain.Role;

/**
 * 角色
 * @author 董帅
 */
@Repository
public interface RoleDao {

    /**
     * 根据用户id查询角色
     * @param id
     * @return
     */
    @Select("select sr.* from sys_role sr,sys_user_role sur where sr.id=sur.roleId and sur.userId=#{id}")
    @Results({
        @Result(property="permissions",column="id",javaType=List.class,
                many=@Many(select="ds.dao.PermissionDao.findByRoleId",fetchType=FetchType.LAZY))
    })
    public List<Role> findByUserId(int id);

    /**
     * 查询所有角色
     * @return
     */
    @Select("select * from sys_role")
    public List<Role> findAllRole();

    /**
     * 保存角色
     * @param role
     */
    @Insert("insert into sys_role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    public void saveRole(Role role);
}
