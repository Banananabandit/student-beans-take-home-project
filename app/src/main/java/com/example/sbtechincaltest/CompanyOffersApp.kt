package com.example.sbtechincaltest

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.sbtechincaltest.screens.LoginScreen
import com.example.sbtechincaltest.ui.theme.StudentBeansAppTheme

@Composable
fun CompanyOffersApp(){
    val navController = rememberNavController()
    val appState = rememberAppState()

    NavHost(navController = navController, startDestination = "login") {
        composable(
            route = "login"
        ) {
            LoginScreen(openAndPopUp = {route, popUp -> appState.})

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