package com.example.sbtechincaltest.offers.presentation.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
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
import com.example.sbtechincaltest.theme.StudentBeansTeal

//TODO: Refactor further
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginScreenViewModel = viewModel(),
) {
    val uiState by viewModel.uiState
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 64.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        GreetingMessage()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            EmailField(uiState.email, viewModel::onEmailChange, focusManager)

            PasswordField(uiState.password, viewModel::onPasswordChange, focusManager)

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
fun EmailField(value: String, oneNewValue: (String) -> Unit, focusManager: FocusManager) {
    OutlinedTextField(
        value = value,
        onValueChange = { oneNewValue(it) },
        label = { Text("Email") },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down)

        })
    )
}

@Composable
fun PasswordField(value: String, oneNewValue: (String) -> Unit, focusManager: FocusManager) {
    var isPasswordVisible = false
    OutlinedTextField(
        value = value,
        onValueChange = { oneNewValue(it) },
        label = { Text("Password") },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
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

@Composable
fun GreetingMessage() {
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
}

