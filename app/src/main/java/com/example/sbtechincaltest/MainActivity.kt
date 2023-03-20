package com.example.sbtechincaltest

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.sbtechincaltest.ui.theme.StudentBeansAppTheme

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

@Composable
private fun CompanyOffersApp(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = "offers") {
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

