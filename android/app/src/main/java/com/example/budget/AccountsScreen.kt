package com.example.budget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AccountsScreen(navController: NavController){
  Column {
    Text("Konto: Rachunek bieżący", modifier = androidx.compose.ui.Modifier.clickable {
      navController.navigate("transactions/acc-1")
    })
  }
}
