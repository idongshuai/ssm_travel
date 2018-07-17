package ds.aop;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import ds.domain.SysLog;
import ds.service.SysLogService;

/**
 * 日志的切面类
 * 
 * @author 董帅
 */
@Component
@Aspect
public class LogAop {

    //当前正在访问的方法名称
    private String methodName;
    
    @Autowired
    private HttpServletRequest request;
    
    @Autowired
    private SysLogService sysLogService;
    
    private Class clazz;
    
    
    /**
     * 方法执行前增强
     */
    @Before("execution(* ds.controller.*.*(..))")
    public void logBefore(JoinPoint jp) throws Exception {
        //获取到目标对象
        clazz = jp.getTarget().getClass();
        
        //获取类名
        String className = clazz.getSimpleName();
        
        //获取到正在执行的方法名称
        methodName = jp.getSignature().getName();
        methodName = className + "." + methodName;
        
        System.out.println(jp.getSignature().toShortString());
        System.out.println(jp.getSignature().toShortString());
        
    }
    
    /**
     * 方法执行后增强
     */
    @After("execution(* ds.controller.*.*(..))")
    public void logAfter() {
        SysLog log = new SysLog();
        log.setIp(request.getRemoteAddr());
        log.setMethod(methodName);
        
        SecurityContext context = SecurityContextHolder.getContext();
        //获取到认证的对象
        Authentication authentication = context.getAuthentication();
        //获取到登录的用户信息
        User user = (User) authentication.getPrincipal();
        
        log.setUsername(user.getUsername());
        log.setVisitTime(new Date());
        //保存日志
        sysLogService.saveLog(log);
    }
}
