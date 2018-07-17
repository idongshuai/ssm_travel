package ds.service;

import ds.domain.SysLog;

/**
 * 系统日志的service层接口
 * 
 * @author 董帅
 */
public interface SysLogService {

    /**
     * 保存日志
     * @param log
     */
    void saveLog(SysLog log);

}
