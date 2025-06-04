package com.edrees.tomjerry.ui.tomkitchen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edrees.tomjerry.R
import com.edrees.tomjerry.ui.theme.IBMPlexSansArabic

@Composable
fun PriceLabel(
    modifier: Modifier = Modifier,
    price: Int
) {
    Surface(
        modifier = modifier
            .height(30.dp),
        shape = RoundedCornerShape(8.dp),
        onClick = { },
        color = Color(0xFFD0E5F0),
        contentColor = Color(0xFF03578A)
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 6.dp, horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_money_bag),
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = "$price cheeses",
                fontFamily = IBMPlexSansArabic,
                fontWeight = FontWeight.W500,
                fontSize = 12.sp,
                lineHeight = 14.sp,
                letterSpacing = 0.sp,
                maxLines = 1
            )
        }
    }
}