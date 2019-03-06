package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DemoService{

    @Autowired lateinit var demo2Service: Demo2Service

    fun demo(){
        println("demo")
        demo2Service.demo2()
    }
}

@Service
class Demo2Service{

    fun demo2(){
        println("demo2")
    }
}
