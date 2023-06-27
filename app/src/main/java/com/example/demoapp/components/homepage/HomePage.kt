package com.example.demoapp.components.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlin.math.round

@Composable
fun HomePage(navController: NavController)
{
    Box(modifier = Modifier
        .fillMaxSize(1f)
        .background(Color(0xFF0000e6)))
    {
        Column(modifier = Modifier, verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier.fillMaxWidth().height(100.dp).background(Color.White))
            Box(modifier = Modifier.width(300.dp).height(250.dp).background(Color.Gray))
            Box(modifier = Modifier.fillMaxWidth().clip(
                RoundedCornerShape(20.dp,20.dp)).height(600.dp).background(Color.White))

        }

    }
}

@Preview(showBackground = true)
@Composable
fun defaultPreview3()
{
    HomePage(navController=rememberNavController())
}