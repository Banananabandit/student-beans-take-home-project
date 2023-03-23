package com.example.sbtechincaltest.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.sbtechincaltest.R
import com.example.sbtechincaltest.ui.theme.StudentBeansTeal
import com.example.sbtechincaltest.viewmodels.LoginScreenViewModel

//TODO: Refactor further
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginScreenViewModel = viewModel()
) {
    val uiState by viewModel.uiState

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 64.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Welcome back",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            modifier = Modifier
                .padding(top = 16.dp)
        )
        Text(
            text = "Login to your Student Beans account",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxHeight()
        ) {

            EmailField(uiState.email, viewModel::onEmailChange)

            PasswordField(uiState.password, viewModel::onPasswordChange)

            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(bottom = 32.dp)
            ) {
                SignInButton() {viewModel.onSignInClick(navController)}
            }
        }
    }
}

@Composable
fun EmailField(value: String, oneNewValue: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = { oneNewValue(it) },
        label = { Text("Email") },
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = StudentBeansTeal,
            focusedLabelColor = StudentBeansTeal,
            cursorColor = Color.Black,
        ),
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(onNext = {

        })
    )
}

@Composable
fun PasswordField(value: String, oneNewValue: (String) -> Unit) {
    var isPasswordVisible = false
    OutlinedTextField(
        value = value,
        onValueChange = { oneNewValue(it) },
        label = { Text("Password") },
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = StudentBeansTeal,
            focusedLabelColor = StudentBeansTeal,
            cursorColor = Color.Black
        ),
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {  }),
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (isPasswordVisible)
                R.drawable.baseline_visibility_24
            else R.drawable.baseline_visibility_off_24

            val description = if (isPasswordVisible) "Hide password" else "Show password"
            IconButton(
                onClick = { isPasswordVisible = !isPasswordVisible },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Icon(painterResource(id = image), contentDescription = description)
            }
        }
    )
}

@Composable
fun SignInButton(action: () -> Unit) {
    Button(
        onClick = action,
        enabled = true,
        colors = ButtonDefaults.buttonColors(StudentBeansTeal),
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
    ) {
        Text(
            text = "Log in",
            color = Color.White
        )
    }
}

