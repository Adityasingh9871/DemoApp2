package com.example.demoapp.components

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.demoapp.Pref
import com.example.demoapp.Screen
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController)
{
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var checkedState by remember { mutableStateOf(false) }
    val context= LocalContext.current

    Box(modifier = Modifier
        .fillMaxSize(1f)
        .background(Color.White))
    {
        Box(modifier = Modifier
            .align(Alignment.Center)
            .widthIn(min = 250.dp)
            .heightIn(min = 350.dp)
            .background(
                Color.White
            )
            .padding(all = 15.dp))

        {
            Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "USERNAME", fontSize = 25.sp, modifier =Modifier.padding(all=10.dp))
                TextField(value = username, onValueChange ={username=it} )
                Text(text = "PASSWORD", fontSize = 25.sp, modifier =Modifier.padding(all=10.dp))
                TextField(value = password, onValueChange ={password=it} )

                Row(modifier=Modifier, horizontalArrangement = Arrangement.End) {
                    Text(text = "Remember me", fontSize = 25.sp, modifier =Modifier.padding(all=15.dp))
                    Checkbox(checked = checkedState, onCheckedChange ={checkedState=it}, modifier =Modifier.padding(all=10.dp) )
                }

                Button(onClick = { loginAuth(checkedState,username,password,navController, context)
                    username=""
                    password=""})
                {
                    Text(text = "Login", fontSize = 25.sp)
                }

            }

        }
    }
}

fun loginAuth(isChecked:Boolean,username: String,password:String,navController: NavController,context: Context)
{
    if(isChecked)
    {
        val prefInstance=Pref(context)
        if(username=="a" && password=="a")
        {
            prefInstance.setdata("isLoggedIn",value = true)
            prefInstance.set_user_pass(key=username,value=password)
            navController.navigate(Screen.Page1.route)
            Toast.makeText(context, "Logged In", Toast.LENGTH_SHORT).show()
        }
    }
    else if(username=="a" && password=="a")
    {
        navController.navigate(Screen.Page1.route)
        Toast.makeText(context, "Logged In", Toast.LENGTH_SHORT).show()
    }



}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2()
{
    LoginScreen(navController = rememberNavController())
}