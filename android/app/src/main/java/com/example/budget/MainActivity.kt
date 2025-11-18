package com.example.budget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?){
    super.onCreate(savedInstanceState)
    setContent{
      BudgetApp()
    }
  }
}

@Composable
fun BudgetApp(){
  val navController = rememberNavController()
  NavHost(navController, startDestination = "connect"){
    composable("connect"){ ConnectScreen(navController) }
    composable("accounts"){ AccountsScreen(navController) }
    composable("transactions/{accountId}"){ /* TransactionsScreen placeholder */ }
  }
}
