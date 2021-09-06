package com.example.demo.repository

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface UserRepository: CrudRepository<DemoUser, String>