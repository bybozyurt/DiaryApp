package com.example.diaryapp.presentation.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diaryapp.R
import com.example.diaryapp.presentation.components.button.SocialButton
import com.example.diaryapp.presentation.components.icon.AppIcon
import com.example.diaryapp.presentation.components.text.AppText
import com.example.diaryapp.util.onButtonClicked

@Composable
fun AuthenticationContent(
    paddingValues: PaddingValues,
    isLoading: Boolean = false,
    onButtonClicked: onButtonClicked
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(32.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FormView()
        SocialButton(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(70.dp),
            isLoading = isLoading,
            onButtonClicked = onButtonClicked
        )
    }
}

@Composable
fun FormView() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AppIcon(
            modifier = Modifier,
            id = R.drawable.logo_google
        )
        Spacer(modifier = Modifier.height(16.dp))
        AppText(
            text = stringResource(id = R.string.auth_title),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}