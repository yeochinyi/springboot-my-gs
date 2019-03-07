package com.example.demo

import io.kotlintest.shouldNotBe
import io.kotlintest.specs.WordSpec
import io.kotlintest.spring.SpringListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [(DemoApplication::class)])
class KotlinSpringTest : WordSpec() {

    override fun listeners() = listOf(SpringListener)

    @Autowired
    var bean: DemoService? = null

    init {
        "Spring Extension" should {
            "have wired up the bean" {
                bean shouldNotBe null
                bean?.demo("Test Hello")
            }
        }
    }
}