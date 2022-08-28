package com.debduttapanda.composeroboelectric

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ActivityScenario
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out // Redirect Logcat to console
    }

    @Test
    fun `when I test, then it works`() {
        composeTestRule.setContent {
            MyContent()
        }
        composeTestRule.onNodeWithTag("First Button").performClick()
        composeTestRule.onNodeWithTag("Second Button").assertIsDisplayed()
    }

    @Test
    fun `when I test with activity, then it works`() {

        ActivityScenario.launch(MainActivity::class.java)
            .use { scenario ->
                scenario.onActivity {
                    composeTestRule
                        .onNodeWithTag("First Button").assertIsDisplayed()
                    composeTestRule.onNodeWithTag("First Button").performClick()
                    composeTestRule.onNodeWithTag("Second Button").assertIsDisplayed()
                }
            }
    }
}