package com.demircandemir.rickandmort.view

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.demircandemir.rickandmort.R
import kotlinx.coroutines.delay


@Composable
fun SplashScreen2 (navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }


    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,

            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.popBackStack()
        navController.navigate("list_screen")
    }


    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.rickandmorty),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value))

        Spacer(modifier = Modifier.height(6.dp))

        Text(text = "HELLO!!",
            fontWeight = FontWeight.Bold, style = MaterialTheme.typography.h3,

            )
    }





}