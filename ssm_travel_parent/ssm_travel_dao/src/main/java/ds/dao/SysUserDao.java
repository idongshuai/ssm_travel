package ds.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import ds.domain.SysUser;

/**
 * 用户的dao层接口
 * 
 * @author 董帅
 */
@Repository
public interface SysUserDao {

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    @Select("select * from sys_user where username=#{username}")
    @Results({
        @Result(property="roles",column="id",javaType=List.class,
                many=@Many(select="ds.dao.RoleDao.findByUserId",fetchType=FetchType.LAZY))
    })
    SysUser findSysUserByUsername(String username);

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from sys_user")
    List<SysUser> findAllUser();

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into sys_user (username,email,password,phoneNum,status) "
            + "values(#{username},#{email},#{password},#{phoneNum},#{status})")
    void saveUser(SysUser user);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Select("select * from sys_user where id=#{id}")
    @Results({
        @Result(property="roles", column="id", javaType=List.class,many=@Many(
                    select="ds.dao.RoleDao.findByUserId",fetchType=FetchType.LAZY))
    })
    SysUser findUserById(int id);

    /**
     * 从中间表删除和用户有关的角色信息
     * @param userId
     */
    @Delete("delete from sys_user_role where userId=#{userId}")
    void deleteUserRole(int userId);

    /**
     * 给用户分配角色
     * @param userId
     * @param roleId
     */
    @Insert("insert into sys_user_role (userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") int userId, @Param("roleId") int roleId);

}
