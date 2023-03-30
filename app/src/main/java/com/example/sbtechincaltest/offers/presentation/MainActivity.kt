package com.example.sbtechincaltest.offers.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sbtechincaltest.offers.presentation.details.OfferDetailsScreen
import com.example.sbtechincaltest.offers.presentation.list.OffersScreen
import com.example.sbtechincaltest.offers.presentation.login.LoginScreen
import com.example.sbtechincaltest.theme.StudentBeansAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StudentBeansAppTheme {
                Surface(color = MaterialTheme.colors.background) {
//                    CompanyOffersApp()
                    OffersScreen()
                }
            }
        }
    }
}

@Composable
private fun CompanyOffersApp(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable(
            route = "login"
        ) {
            LoginScreen(navController)

        }
        composable(
            route = "offers"
        ) {
            OffersScreen { id ->
                navController.navigate("offers/$id")
            }
        }
        composable(
            route = "offers/{offer_id}",
            arguments = listOf(navArgument("offer_id") {
                type = NavType.IntType
            }),
            deepLinks = listOf(navDeepLink {
                uriPattern = "www.studentbeans.hello.com/{offer_id}"
            })
        ) {
            OfferDetailsScreen()
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    StudentBeansAppTheme {
        OffersScreen()
    }
}

