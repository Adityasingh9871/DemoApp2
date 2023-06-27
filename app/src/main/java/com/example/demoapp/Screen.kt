package com.example.demoapp

sealed class Screen(val route:String)
{
    object Login:Screen(route="Login_screen")
    object Page1:Screen(route = "Page1")

}
