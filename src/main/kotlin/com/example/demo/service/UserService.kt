package com.example.demo.service

import com.example.demo.repository.DemoUser
import com.example.demo.repository.UserRepository
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory
import java.net.URL

@Singleton
class UserService(private val repository: UserRepository) {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    fun getUsers(): List<DemoUser> {
        return repository.findAll().toList()
    }

    /**
     * see https://github.com/marlon360/rki-covid-api
     * URL https://rki.marlon-lueckert.de/api/states
     */
    fun requestRki() {
        val httpClient = HttpClient.create(URL("https://rki.marlon-lueckert.de")).toBlocking()
        val result = httpClient.retrieve(HttpRequest.GET<String>("/api/states"), String::class.java)
        logger.info(result)
    }
}