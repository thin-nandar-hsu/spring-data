package com.example.democonnectionjdbc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.sql.Connection;

@Aspect
@Component
public class DataSourceAspect {

    public Object connectionAspect(ProceedingJoinPoint joinPoint)throws Throwable{
        System.out.println("DataSource Trace:"+ joinPoint.getSignature());
        Object returnObj = joinPoint.proceed();
        if(returnObj instanceof Connection){
             return  createConnectionProxy((Connection) returnObj);
        }else {
          return   returnObj;
        }
    }


    private Connection createConnectionProxy(Connection connection){
        return (Connection) Proxy.newProxyInstance(
                DataSourceAspect.class.getClassLoader(),
                new Class[]{Connection.class},
                new ConnectionInvokationHandler(connection)
        );
    }
}
