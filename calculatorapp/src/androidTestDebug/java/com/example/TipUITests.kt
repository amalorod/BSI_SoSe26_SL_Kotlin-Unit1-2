package com.example

import androidx.compose.material3.Surface
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.calculatorapp.TipTimeLayout
import com.example.calculatorapp.ui.theme.CalculatorTheme
import org.junit.Rule
import org.junit.Test
import java.lang.reflect.Modifier
import java.text.NumberFormat

class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

@Test
fun calculate_20_percent_tip(): Unit {
    composeTestRule.setContent {
        CalculatorTheme() {
            Surface (modifier = Modifier.fillMaxSize()){
                TipTimeLayout()
            }
        }
    }
    composeTestRule.onNodeWithText("Bill Amount")
        .performTextInput("10")
    composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
    val expectedTip = NumberFormat.getCurrencyInstance().format(2)
    composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
        "No node with this text was found."
    )
}