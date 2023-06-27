package com.example.demoapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.demoapp.components.LoginScreen
import com.example.demoapp.components.Page1

@Composable
fun SetupNavGraph(NavController: NavHostController)
{
    val context= LocalContext.current
    val prefInstance=Pref(context)
    val isLoggedIn=prefInstance.getdata("isLoggedIn")
    var defaultStart=Screen.Login.route
    if(isLoggedIn)
    {
        defaultStart=Screen.Page1.route
    }
    NavHost(navController = NavController, startDestination = defaultStart)
    {
        composable(route=Screen.Login.route)
        {
            LoginScreen(navController=NavController)
        }
        composable(route=Screen.Page1.route)
        {
            Page1(NavController = NavController)
        }
    }
}