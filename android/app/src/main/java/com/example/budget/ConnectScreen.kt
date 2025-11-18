package com.example.budget

import android.net.Uri
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.browser.customtabs.CustomTabsIntent
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun ConnectScreen(navController: NavController){
  val context = LocalContext.current
  Button(onClick = {
    CoroutineScope(Dispatchers.Main).launch {
      // In a real app: call backend /connect/start and open returned URL
      val authUrl = "http://10.0.2.2:3000/mock-bank/auth?session=demo"
      val intent = CustomTabsIntent.Builder().build()
      intent.launchUrl(context, Uri.parse(authUrl))
    }
  }) { Text("Połącz bank") }
}
