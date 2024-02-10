package com.example.diaryapp.presentation.components.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diaryapp.R
import com.example.diaryapp.presentation.components.icon.AppIcon
import com.example.diaryapp.presentation.components.progressBar.AppProgressBar
import com.example.diaryapp.presentation.components.text.AppText
import com.example.diaryapp.util.onButtonClicked

@Composable
fun SocialButton(
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    onButtonClicked: onButtonClicked,
) {
    Card(
        modifier = modifier,
        onClick = onButtonClicked,
        shape = RoundedCornerShape(8.dp)
    ) {
        if (!isLoading) {
            Row(
                modifier = modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                AppIcon(
                    modifier = Modifier.requiredSize(48.dp),
                    id = R.drawable.ic_google
                )
                Spacer(modifier = Modifier.width(8.dp))
                AppText(
                    text = "Sign in with Google",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        } else {
            AppProgressBar()
        }
    }
}