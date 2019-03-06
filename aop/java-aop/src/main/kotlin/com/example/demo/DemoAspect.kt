package com.example.demo

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component



@Component
@Aspect
class DemoAspect{

    @Around("execution(* com..*Service.*(..))")
    @Throws(Throwable::class)
    fun around(proceedingJoinPoint: ProceedingJoinPoint): Any? {
        println("@Around Before: $proceedingJoinPoint");
        val proceed = proceedingJoinPoint.proceed()
        println("@Around After: $proceed");
        return proceed

    }


}
