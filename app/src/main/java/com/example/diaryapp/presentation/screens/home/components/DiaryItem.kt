package com.example.diaryapp.presentation.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diaryapp.presentation.components.text.AppText

@Preview()
@Composable
fun DiaryItem() {
    Card(
        modifier = Modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            AppText(
                text = "13 Wed March 2024",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
            AppText(
                text = LOREM_IPSUM_SOURCE,
                maxLines = 10,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp,
                lineHeight = 24.sp
            )
        }
    }
}

private val LOREM_IPSUM_SOURCE = "" +
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sodales\n" +
        "laoreet commodo. Phasellus a purus eu risus elementum consequat. Aenean eu\n" +
        "elit ut nunc convallis laoreet non ut libero. Suspendisse interdum placerat\n" +
        "risus vel ornare. Donec vehicula, turpis sed consectetur ullamcorper, ante\n" +
        "nunc egestas quam, ultricies adipiscing velit enim at nunc. Aenean id diam\n" +
        "neque. Praesent ut lacus sed justo viverra fermentum et ut sem. Fusce\n" +
        "convallis gravida lacinia. Integer semper dolor ut elit sagittis lacinia.\n" +
        "Praesent sodales scelerisque eros at rhoncus. Duis posuere sapien vel ipsum\n" +
        "ornare interdum at eu quam. Vestibulum vel massa erat. Aenean quis sagittis\n" +
        "purus. Phasellus arcu purus, rutrum id consectetur non, bibendum at nibh."