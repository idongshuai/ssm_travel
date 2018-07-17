package ds.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import ds.domain.SysLog;

/**
 * 系统日志的dao层接口
 * 
 * @author 董帅
 */
@Repository
public interface SysLogDao {

    /**
     * 保存日志
     * @param log
     */
    @Insert("insert into sys_log (visitTime,username,ip,method) "
            + "values (#{visitTime},#{username},#{ip},#{method})")
    void saveLog(SysLog log);

}
