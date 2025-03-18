package com.example.myapplication

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun CounterUI(modifier: Modifier = Modifier) {
    val state = remember { mutableStateOf(0.0) }

    Log.d("Full State Click Event", "----------------------> Render full state")

    Button(onClick = {
        state.value = Math.random()
    }, modifier = modifier) {
        Log.d("Button Widget Click Event", "----------------------> Render button widget")

        Text("Click Result ${state.value}")
    }
}