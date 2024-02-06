package com.example.diaryapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diaryapp.R
import com.example.diaryapp.presentation.components.button.SocialButton
import com.example.diaryapp.presentation.components.icon.AppIcon
import com.example.diaryapp.presentation.components.text.AppText

@Composable
fun AuthenticationScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FormView()
        SocialButton()
    }
}

@Composable
fun FormView() {
    AppIcon(
        modifier = Modifier,
        id = R.drawable.logo_google
    )
    Spacer(modifier = Modifier.height(16.dp))
    AppText(
        text = "Please sign in with Google",
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
}