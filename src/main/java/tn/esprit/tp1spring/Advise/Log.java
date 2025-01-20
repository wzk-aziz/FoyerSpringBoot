package tn.esprit.tp1spring.Advise;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class Log {

    @Before("execution(* tn.esprit.tp1spring.Service.BlocService.*(..))")
    public void logService(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Service ya 3ami: " + name);
    }
}
