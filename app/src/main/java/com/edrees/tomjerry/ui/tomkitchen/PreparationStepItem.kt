package com.edrees.tomjerry.ui.tomkitchen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edrees.tomjerry.ui.theme.IBMPlexSansArabic

@Composable
fun PreparationStepItem(
    stepNumber: Int,
    stepText: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        // Step description
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp)
                )
        ) {
            Text(
                text = stepText,
                fontSize = 14.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp,
                fontWeight = FontWeight.W400,
                fontFamily = IBMPlexSansArabic,
                color = Color(0x99121212),
                modifier = Modifier.padding(start = 24.dp, top = 8.dp, bottom = 8.dp)
            )
        }

        // Step number
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = CircleShape
                )
                .border(
                    width = 1.dp,
                    color = Color(0xFFD0E5F0),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                text = stepNumber.toString(),
                fontSize = 12.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp,
                fontFamily = IBMPlexSansArabic,
                color = Color(0xFF035587)
            )
        }
    }
}

@Preview
@Composable
fun StepItemPreview() {
    PreparationStepItem(
        stepNumber = 1,
        stepText = "Put the pasta in a toaster."
    )
}