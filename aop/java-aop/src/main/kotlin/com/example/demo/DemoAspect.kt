package com.example.demo

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component



@Component
@Aspect
class DemoAspect{

    companion object {
        private val LOG = LoggerFactory.getLogger(DemoAspect::class.java)
    }


    //@Around("execution(* com..*Service.*(..))")
    @Around("execution(* com.example..*Service.*(..))")
    @Throws(Throwable::class)
    fun around(joinPoint: ProceedingJoinPoint): Any? {
        with(joinPoint) {
            LOG.info(
                    "Enter: ${signature.declaringTypeName}.${signature.name}() with argument(s) = ${args.joinToString()}"
            )
            try {
                val result = joinPoint.proceed()
                LOG.info("Exit: ${signature.declaringTypeName}.${signature.name}() with results = $result")
                return result
            } catch (e: Exception) {
                LOG.error(
                        "Exception: ${signature.declaringTypeName}.${signature.name}() with exception = $e")
                throw e
            }
        }

    }


}
