package com.idexx.lims

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 *
 * @author gpaul
 * Date: May 25, 2018
 */
@SpringBootApplication
class PubsubPushTrialApp : SpringBootServletInitializer() {
    override fun configure(builder: SpringApplicationBuilder?): SpringApplicationBuilder {
        return builder!!.sources(PubsubPushTrialApp::class.java)
    }
}

fun main(args: Array<String>) {
    runApplication<PubsubPushTrialApp>(*args)
}


@RestController
class SubscriberController {

    val messages = mutableListOf<String>()

    @PostMapping("/_ah/push-handlers/trial")
    fun trial(@RequestBody body: String) {
        println("got: $body")
        messages.add(body)
    }

    @GetMapping("/messages")
    fun results(): List<String> {
        return messages
    }

}