package com.example.calculator_phone.state_keeping

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.TextFieldValue

data class CalculatorStates(
    val inputExpression: TextFieldValue,
    val setInputExpression: (TextFieldValue) -> Unit,
    val focusManager: FocusManager,
    val config: Configuration
)

@Composable
fun initCalculatorStates(): CalculatorStates {
    val (inputExpression, setInputExpression) = remember { mutableStateOf(TextFieldValue("")) }
    val focusManager = LocalFocusManager.current
    val config = LocalConfiguration.current
    return CalculatorStates(inputExpression, setInputExpression, focusManager, config)
}