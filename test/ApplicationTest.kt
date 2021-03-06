package se.an3ll

import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import se.an3ll.ktor.koin.app.module
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ApplicationTest {

    @Test
    fun testRoot() {
        withTestApplication({ module() }) {
            handleRequest(HttpMethod.Get, "/users/5beb4603736124c6e32a26b7").apply {
                assertEquals(HttpStatusCode.NotFound, response.status())
                assertNotNull(response.content)
            }
        }
    }
}
