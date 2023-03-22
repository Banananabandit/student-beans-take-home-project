package com.example.sbtechincaltest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.sbtechincaltest.screens.LoginScreen
import com.example.sbtechincaltest.ui.theme.StudentBeansAppTheme
import com.example.sbtechincaltest.viewmodels.OffersViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StudentBeansAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CompanyOffersApp()
                }
            }
        }
    }
}



