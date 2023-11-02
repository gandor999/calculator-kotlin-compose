package com.example.calculator_phone.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.calculator_phone.state_keeping.CalculatorStates
import com.example.calculator_phone.util.calculate

@Composable
fun ButtonPanel(
    modifier: Modifier = Modifier,
    calculatorStateKeeper: CalculatorStates,
) {
    val orientation = calculatorStateKeeper.config.orientation

    Column(
        modifier = modifier
    ) {

        val buttonIndexes = if (orientation == Configuration.ORIENTATION_LANDSCAPE) listOf(
            listOf(
                0, 7
            ), listOf(8, 15)
        ) else listOf(listOf(0, 3), listOf(4, 7), listOf(8, 11), listOf(12, 15))

        for (buttonIndex in buttonIndexes) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
            ) {
                RenderButtons(
                    orientation = orientation,
                    calculatorStateKeeper = calculatorStateKeeper,
                    fromIndex = buttonIndex[0],
                    toIndex = buttonIndex[1]
                )
            }
        }


        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) { // these are invisible buttons so that we can align the buttons perfectly either landscape or orientation
            for (i in 0 until (if (orientation == Configuration.ORIENTATION_LANDSCAPE) 6 else 2)) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {}
            }

            Button(onClick = {
                calculatorStateKeeper.setInputExpression(
                    TextFieldValue(
                        calculatorStateKeeper.inputExpression.text.dropLast(
                            1
                        )
                    )
                )
            }, colors = ButtonDefaults.buttonColors(Color(red = 146, green = 55, blue = 77))) {
                Text("<")
            }


            Button(onClick = {
                calculatorStateKeeper.setInputExpression(
                    TextFieldValue(
                        calculate(
                            calculatorStateKeeper.inputExpression.text
                        )
                    )
                )
            }, colors = ButtonDefaults.buttonColors(Color(red = 81, green = 187, blue = 254))) {
                Text("=")
            }
        }
    }
}