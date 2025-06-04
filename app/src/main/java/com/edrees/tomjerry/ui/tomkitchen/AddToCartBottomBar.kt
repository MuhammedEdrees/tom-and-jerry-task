package com.edrees.tomjerry.ui.tomkitchen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edrees.tomjerry.ui.theme.IBMPlexSansArabic

@Composable
fun AddToCartBottomBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .border(1.dp, color = Color(0x1F1F1F1E))
    ) {
        Button(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 15.dp)
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF226993)),
            onClick = {},
            shape = RoundedCornerShape(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Add to cart",
                    fontFamily = IBMPlexSansArabic,
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.5.sp,
                    color = Color(0xDEFFFFFF)
                )
                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .background(
                            color = Color.White.copy(alpha = 0.38f),
                            shape = CircleShape
                        )
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "3 cheeses",
                        fontFamily = IBMPlexSansArabic,
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.5.sp,
                        color = Color.White
                    )
                    Text(
                        text = "5 cheeses",
                        fontFamily = IBMPlexSansArabic,
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.5.sp,
                        textDecoration = TextDecoration.LineThrough,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                }
            }
        }
    }

}