package com.example.doctorathome.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.doctorathome.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.doctorathome.database.User
import com.example.doctorathome.database.UserRepository

@Composable
fun PatientInfo(navController: NavHostController) {
    var name by remember{ mutableStateOf("") }
    var age by remember{ mutableStateOf("") }
    var height by remember{ mutableStateOf("") }
    var gender by remember{ mutableStateOf("") }
    var idproof by remember{ mutableStateOf("") }
    var email by remember{ mutableStateOf("") }
    var phone by remember{ mutableStateOf("") }
    var address by remember{ mutableStateOf("") }
    var job by remember{ mutableStateOf("") }

    val focusManager = LocalFocusManager.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        EditTextField(
            label = R.string.username,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down)}
            ),
            value = name,
            onValueChange = { name = it }
        )
        EditTextField(
            label = R.string.age,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down)}
            ),
            value = age,
            onValueChange = { age = it }
        )
        EditTextField(
            label = R.string.height,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down)}
            ),
            value = height,
            onValueChange = { height= it }
        )
        EditTextField(
            label = R.string.gender,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down)}
            ),
            value = gender,
            onValueChange = { gender = it }
        )
        EditTextField(
            label = R.string.email,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down)}
            ),
            value = email,
            onValueChange = { email = it }
        )
        EditTextField(
            label = R.string.phone,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down)}
            ),
            value = phone,
            onValueChange = { phone = it }
        )
        EditTextField(
            label = R.string.job,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down)}
            ),
            value = job,
            onValueChange = { job = it }
        )
        EditTextField(
            label = R.string.address,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down)}
            ),
            value = address,
            onValueChange = { address = it }
        )
        EditTextField(
            label = R.string.id,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.clearFocus()}
            ),
            value = idproof,
            onValueChange = { idproof = it }
        )
        val userRepository = UserRepository(database.userDao())

        Button(
            onClick = {
                val user = User(name = name, email = email, phone = phone)
                userRepository.addUser(user)},
            modifier = Modifier.width(10.dp),
        ) {
            Text(text ="Register",color = Color.White)
        }
    }
}
