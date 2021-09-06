package com.example.demo.controller

import com.example.demo.repository.DemoUser
import com.example.demo.service.UserService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/demo")
class UserController(private val userService: UserService) {

    @Get("/users")
    fun getUsers(): List<DemoUser> {
        return userService.getUsers()
    }
}

