package com.example.calculator_phone.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.calculator_phone.state_keeping.initCalculatorStates
import com.example.calculator_phone.util.calculate

@Composable
fun Calculator(
    modifier: Modifier = Modifier, horizontalAlignment: Alignment.Horizontal = Alignment.Start
) {
    val calculatorStateKeeper = initCalculatorStates()

    Column(
        modifier = modifier, horizontalAlignment = horizontalAlignment
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            value = calculatorStateKeeper.inputExpression,
            onValueChange = {
                calculatorStateKeeper.setInputExpression(it)
            },
            label = {},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone, imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {
                calculatorStateKeeper.setInputExpression(TextFieldValue(calculate(calculatorStateKeeper.inputExpression.text)))
                calculatorStateKeeper.focusManager.clearFocus()
            }),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Black,
                leadingIconColor = Color(red = 81, green = 187, blue = 254),
                cursorColor = Color(red = 81, green = 187, blue = 254),
            )
        )

        Spacer(modifier = Modifier.height(30.dp))

        LazyColumn {
            item {
                ButtonPanel(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp), calculatorStateKeeper = calculatorStateKeeper
                )
            }
        }
    }
}