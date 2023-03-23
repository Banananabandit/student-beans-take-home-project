package com.example.sbtechincaltest.viewmodels

import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.sbtechincaltest.OffersApplication
import com.example.sbtechincaltest.models.LoginUiState

class LoginScreenViewModel(): ViewModel() {
    val uiState = mutableStateOf(LoginUiState())

    private val email
    get() = uiState.value.email

    private val password
    get() = uiState.value.password

    fun onEmailChange(newValue: String) {
        uiState.value = uiState.value.copy(email = newValue)
    }

    fun onPasswordChange(newValue: String) {
        uiState.value = uiState.value.copy(password = newValue)
    }

    fun onSignInClick(navController: NavController) {
        if(email.isNotBlank() && password.isNotBlank())
            navController.navigate("offers")
        else Toast.makeText(OffersApplication.getAppContext(), "Please enter user details", Toast.LENGTH_SHORT).show()
        }
}