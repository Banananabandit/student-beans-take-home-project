package com.example.sbtechincaltest.viewmodels

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.sbtechincaltest.OffersApplication

class LoginScreenViewModel(): ViewModel() {

    fun authenticateUser(email: String, password:String, navController: NavController) {
        if(email.isNotBlank() && password.isNotBlank())
            navController.navigate("offers")
        else Toast.makeText(OffersApplication.getAppContext(), "Please enter user details!", Toast.LENGTH_SHORT).show()
    }

}