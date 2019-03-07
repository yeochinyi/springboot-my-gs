package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import javax.annotation.PostConstruct

@SpringBootApplication
class DemoApplication{

	@Autowired
	lateinit var demoService: DemoService

	@PostConstruct
	fun done(){
		demoService.demo("Hello!")
	}
}




fun main(args: Array<String>) {
	SpringApplication.run(DemoApplication::class.java, *args)
}
