package com.edrees.tomjerry.ui.tomaccount

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edrees.tomjerry.R
import com.edrees.tomjerry.ui.theme.IBMPlexSansArabic
import com.edrees.tomjerry.ui.theme.TomAndJerryTheme

@Composable
fun StatItem(
    modifier: Modifier = Modifier,
    @DrawableRes
    imageRes: Int,
    progress: Float,
    tint: Color,
    containerColor: Color,
    title: String,
    description: String,
) {
    Row(
        modifier = modifier
            .background(
                color = containerColor,
                shape = RoundedCornerShape(12.dp)
            ),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomCircularProgressIndicatorWithInnerIcon(
            progress = progress,
            painter = painterResource(imageRes),
            modifier = Modifier
                .padding(start = 12.dp, top = 8.dp, bottom = 8.dp),
            size = 40.dp,
            strokeWidth = 1.dp,
            innerIconPadding = 8.dp,
            progressColor = tint,
            backgroundColor = Color.White,
            iconTint = tint,
            thumbRadius = 2.5.dp
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = title,
                fontFamily = IBMPlexSansArabic,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp,
                fontWeight = FontWeight.W600,
                color = Color(0x99121212),
            )
            Text(
                text = description,
                fontFamily = IBMPlexSansArabic,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp,
                color = Color(0x5E121212),
            )
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_9_pro")
@Composable
private fun StatItemPreview() {
    TomAndJerryTheme {
        StatItem(
            imageRes = R.drawable.ic_evil,
            progress = 0.6f,
            tint = Color(0xFF03578A),
            containerColor = Color(0xFFD0E5F0),
            title = "2M 12K",
            description = "No. of quarrels"
        )
    }
}