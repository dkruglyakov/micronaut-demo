package com.example.demo
import com.example.demo.repository.DemoUser
import com.example.demo.repository.UserRepository
import io.micronaut.http.HttpStatus
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import io.restassured.RestAssured
import io.restassured.RestAssured.given
import jakarta.inject.Inject
import org.hamcrest.Matchers
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate


@MicronautTest
class MicronautDemoTest {

    @Inject
    private lateinit var embeddedServer: EmbeddedServer


    @Inject
    lateinit var userRepository: UserRepository

    @BeforeEach
    internal fun setUp() {
        RestAssured.port = embeddedServer.port

        val demoUser = DemoUser(
            firstName = "Monika",
            lastName = "Musterfrau",
            street = "Fasanenweg",
            houseNo = "15",
            zipCode = "70771",
            city = "Leinfelden",
            state = "BW",
            birthday = LocalDate.of(1970, 8, 25)
        )
        userRepository.save(demoUser)
    }

    @AfterEach
    internal fun tearDown() {
        userRepository.deleteAll()
    }

    @Test
    fun requestUsers() {
        given()
            .`when`()
            .get("/demo/users")
            .then()
            .log().all()
            .statusCode(HttpStatus.OK.code)
            .body("[0].firstName", Matchers.`is`("Monika"))
    }
}
