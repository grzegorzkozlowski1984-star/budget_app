package com.example.compose.jetchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.jetchat.ui.categories.CategoriesScreen

class NavActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppContent()
        }
    }
}

@Composable
fun AppContent() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "categories"
    ) {
        composable("categories") {
            CategoriesScreen()
        }
    }
}
