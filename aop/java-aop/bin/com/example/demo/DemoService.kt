package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DemoService{

    @Autowired lateinit var demo2Service: Demo2Service

    fun demo(){
        println("demo")
        demo2Service.demo2()
        demo3()
    }

    // https://stackoverflow.com/questions/13564627/spring-aop-not-working-for-method-call-inside-another-method
    // demo3 AOP will be get called
    fun demo3(){
        println("demo3")
    }
}

@Service
class Demo2Service{

    fun demo2(){
        println("demo2")
    }
}
