package com.example.calculator_phone

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun ButtonPanel(modifier: Modifier = Modifier, config: Configuration = LocalConfiguration.current) {
    Column(
        modifier = modifier
    ) {
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
            }
        } else {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
                Button(onClick = {}) {}
            }
        }

    }
}


@Composable
fun Calculator(
    modifier: Modifier = Modifier
) {
    val (inputNumber, setInputNumber) = remember { mutableStateOf(TextFieldValue("")) }
    val focusManager = LocalFocusManager.current
    val config = LocalConfiguration.current

    Column(
        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            value = inputNumber,
            onValueChange = {
                setInputNumber(it)
            },
            label = {},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone, imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {
                println("Enter Pressed And Done!")
                focusManager.clearFocus()
            }),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent, focusedIndicatorColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(30.dp))

        ButtonPanel(
            modifier = Modifier.fillMaxSize().padding(10.dp), config = config
        )
    }

}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(
                    modifier = Modifier.fillMaxSize().padding(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Calculator(
                        modifier = Modifier.padding(30.dp).height(300.dp)
                    )
                }
            }
        }
    }
}