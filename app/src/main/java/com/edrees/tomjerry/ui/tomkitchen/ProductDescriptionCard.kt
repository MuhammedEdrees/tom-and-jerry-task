package com.edrees.tomjerry.ui.tomkitchen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edrees.tomjerry.ui.theme.IBMPlexSansArabic

@Composable
fun ProductDescriptionCard(
    modifier: Modifier = Modifier,
    @DrawableRes
    iconRes: Int,
    value: String,
    title: String,
) {
    Column(
        modifier = modifier
            .background(
                color = Color(0xFFD0E5F0),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(32.dp)
        )
        Text(
            modifier = Modifier.padding(top = 12.dp),
            text = value,
            fontFamily = IBMPlexSansArabic,
            fontSize = 14.sp,
            fontWeight = FontWeight.W500,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp,
            color = Color(0x99121212)
        )
        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = title,
            fontFamily = IBMPlexSansArabic,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp,
            color = Color(0x5E121212)
        )
    }
}