package com.edrees.tomjerry.ui.tomkitchen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edrees.tomjerry.R
import com.edrees.tomjerry.ui.theme.IBMPlexSansArabic

@Composable
fun ProductDetailsSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Details",
            fontFamily = IBMPlexSansArabic,
            fontSize = 18.sp,
            lineHeight = 32.sp,
            letterSpacing = 0.5.sp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ProductDescriptionCard(
                modifier = Modifier.weight(1f),
                iconRes = R.drawable.ic_temperature,
                value = "1000 V",
                title = "Temperature"
            )
            ProductDescriptionCard(
                modifier = Modifier.weight(1f),
                iconRes = R.drawable.ic_timer,
                value = "3 sparks",
                title = "Time"
            )
            ProductDescriptionCard(
                modifier = Modifier.weight(1f),
                iconRes = R.drawable.ic_evil,
                value = "1M 12K",
                title = "No. of deaths"
            )
        }
    }
}