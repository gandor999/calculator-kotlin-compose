package com.example.calculator_phone.components

import android.content.res.Configuration
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import com.example.calculator_phone.state_keeping.CalculatorStates

@Composable
fun RenderButtons(
    orientation: Int = Configuration.ORIENTATION_PORTRAIT,
    calculatorStateKeeper: CalculatorStates,
    fromIndex: Int = 0,
    toIndex: Int = 15
) {
    val buttonSequence = if (orientation == Configuration.ORIENTATION_PORTRAIT) listOf(
        "9", "%", "/", "X", "6", "7", "8", "-", "3", "4", "5", "+", "0", "1", "2", "C"
    ) else listOf("0", "1", "2", "3", "4", "%", "/", "X", "5", "6", "7", "8", "9", "+", "-", "C")

    for (i in fromIndex until toIndex + 1) {
        Button(
            onClick = {
                calculatorStateKeeper.setInputNumber(TextFieldValue(if (buttonSequence[i] == "C") "" else calculatorStateKeeper.inputNumber.text + buttonSequence[i]))
            }, colors = ButtonDefaults.buttonColors(
                if (buttonSequence[i] == "C") Color(
                    red = 255, green = 101, blue = 66
                ) else if (arrayOf(
                        "%", "/", "X", "+", "-"
                    ).contains(buttonSequence[i])
                ) Color(red = 247, green = 254, blue = 114) else Color(
                    red = 101, green = 184, blue = 145
                )
            )
        ) {
            Text(text = buttonSequence[i], color = Color(red = 0, green = 36, blue = 27))
        }
    }
}