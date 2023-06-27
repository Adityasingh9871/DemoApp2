package com.example.demoapp.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.demoapp.Pref
import com.example.demoapp.Screen

@Composable
fun Page1(NavController:NavController)
{
    val context= LocalContext.current
    Box(modifier = Modifier.fillMaxSize())
    {
        Button(onClick = { logout(context,NavController) }, modifier = Modifier.align(
            Alignment.Center)) {
            Text(text = "Logout", fontSize = 20.sp)
        }
    }
}

fun logout(context: Context,NavController: NavController)
{
    val prefInstance= Pref(context)
    prefInstance.setdata("isLoggedIn",false)
    NavController.navigate(Screen.Login.route)
    Toast.makeText(context, "Logged out", Toast.LENGTH_SHORT).show()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview()
{
    Page1(NavController = rememberNavController())
}