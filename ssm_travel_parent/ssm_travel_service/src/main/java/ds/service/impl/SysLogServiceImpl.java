package ds.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ds.dao.SysLogDao;
import ds.domain.SysLog;
import ds.service.SysLogService;

/**
 * 系统日志的service层实现类
 * 
 * @author 董帅
 */
@Service
public class SysLogServiceImpl implements SysLogService {
    
    @Autowired
    private SysLogDao sysLogDao;

    /**
     * 保存日志
     */
    @Override
    public void saveLog(SysLog log) {
        sysLogDao.saveLog(log);
        
    }

}
