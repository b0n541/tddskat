/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package org.b0n541.tddskat

import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

class AppTest {
    @Test
    fun testAppHasAGreeting() {
        val classUnderTest = App()
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }
}
