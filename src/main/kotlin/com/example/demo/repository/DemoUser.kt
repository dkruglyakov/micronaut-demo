package com.example.demo.repository

import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.core.annotation.Introspected
import java.time.LocalDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@Introspected
data class DemoUser(
        @Id
        val userId: String = UUID.randomUUID().toString(),
        val firstName: String,
        val lastName: String,
        val street: String,
        val houseNo: String? = null,
        val zipCode: String,
        var city: String? = null,
        var state: String? = null,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        var birthday: LocalDate? = null
)