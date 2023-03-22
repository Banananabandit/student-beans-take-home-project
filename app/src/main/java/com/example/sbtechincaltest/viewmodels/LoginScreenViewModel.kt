package com.example.sbtechincaltest.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.sbtechincaltest.models.LoginUiState
import com.google.android.gms.common.internal.AccountAccessor
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel() : ViewModel() {
    var uiState = mutableStateOf(LoginUiState())
        private set
}


//    fun authenticateUser(email: String, password:String) {
////        if(email.isNotBlank() && password.isNotBlank())
////            navController.navigate("offers")
////        else Toast.makeText(OffersApplication.getAppContext(), "Please enter user details!", Toast.LENGTH_SHORT).show()
//    }

