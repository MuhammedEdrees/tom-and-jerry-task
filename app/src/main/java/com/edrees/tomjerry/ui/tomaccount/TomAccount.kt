package com.edrees.tomjerry.ui.tomaccount

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edrees.tomjerry.R
import com.edrees.tomjerry.ui.theme.IBMPlexSansArabic
import com.edrees.tomjerry.ui.theme.TomAndJerryTheme

@Composable
fun TomAccount(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clipToBounds()
            .verticalScroll(rememberScrollState()),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(R.drawable.bg_tom_account),
            contentScale = ContentScale.FillWidth,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = -(48).dp),
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(R.drawable.tom_account_avatar),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(
                        width = 1.dp,
                        color = Color(0x261F1F1E)
                    )
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = "Tom",
                fontFamily = IBMPlexSansArabic,
                fontSize = 18.sp,
                lineHeight = 18.sp,
                color = Color.White
            )
            Text(
                text = "specializes in failure!",
                fontFamily = IBMPlexSansArabic,
                fontSize = 12.sp,
                lineHeight = 25.sp,
                color = Color.White.copy(alpha = 0.8f)
            )
            Text(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .background(
                        color = Color.White.copy(alpha = 0.12f),
                        shape = RoundedCornerShape(40.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                text = "Edit foolishness",
                fontFamily = IBMPlexSansArabic,
                fontSize = 10.sp,
                lineHeight = 18.sp,
                color = Color.White
            )
            Column(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxHeight()
                    .background(
                        color = Color(0xFFEEF4F6),
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    )
                    .padding(horizontal = 16.dp)
            ) {
                Row(
                    modifier = Modifier.padding(top = 23.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    StatItem(
                        modifier = Modifier.weight(1f),
                        imageRes = R.drawable.ic_evil,
                        progress = 0.6f,
                        tint = Color(0xFF03578A),
                        containerColor = Color(0xFFD0E5F0),
                        title = "2M 12K",
                        description = "No. of quarrels"
                    )
                    StatItem(
                        modifier = Modifier.weight(1f),
                        imageRes = R.drawable.ic_workout_run,
                        progress = 0.23f,
                        tint = Color(0xFF57AB0F),
                        containerColor = Color(0xFFDEEECD),
                        title = "+500 h",
                        description = "Chase time"
                    )
                }
                Row(
                    modifier = Modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    StatItem(
                        modifier = Modifier.weight(1f),
                        imageRes = R.drawable.ic_sad,
                        progress = 0.9f,
                        tint = Color(0xFFF46983),
                        containerColor = Color(0xFFF2D9E7),
                        title = "2M 12K",
                        description = "Hunting times"
                    )
                    StatItem(
                        modifier = Modifier.weight(1f),
                        imageRes = R.drawable.ic_heart_break,
                        progress = 0.15f,
                        tint = Color(0xFFFFBF1A),
                        containerColor = Color(0xFFFAEDCF),
                        title = "3M 7K",
                        description = "Heartbroken"
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 24.dp),
                    text = "Tom settings",
                    fontFamily = IBMPlexSansArabic,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W700,
                    color = Color(0xDE1F1F1E)
                )
                AccountListItem(
                    modifier = Modifier.padding(top = 8.dp),
                    imageRes = R.drawable.ic_bed,
                    title = "Change sleeping place"
                )
                AccountListItem(
                    modifier = Modifier.padding(top = 12.dp),
                    imageRes = R.drawable.ic_cat,
                    title = "Meow settings"
                )
                AccountListItem(
                    modifier = Modifier.padding(top = 12.dp),
                    imageRes = R.drawable.ic_fridge,
                    title = "Password to open the fridge"
                )
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 12.dp),
                    color = Color(0x14001A1F),
                    thickness = 1.dp
                )
                Text(
                    text = "His favorite foods",
                    fontFamily = IBMPlexSansArabic,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W700,
                    color = Color(0xDE1F1F1E)
                )
                AccountListItem(
                    modifier = Modifier.padding(top = 8.dp),
                    imageRes = R.drawable.ic_warning,
                    title = "Mouses",
                )
                AccountListItem(
                    modifier = Modifier.padding(top = 12.dp),
                    imageRes = R.drawable.ic_burger,
                    title = "Last stolen meal",
                )
                AccountListItem(
                    modifier = Modifier.padding(top = 12.dp),
                    imageRes = R.drawable.ic_sleeping,
                    title = "Change sleep mood",
                )
                Text(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .align(Alignment.CenterHorizontally),
                    text = "v.TomBeta",
                    fontWeight = FontWeight.W400,
                    fontFamily = IBMPlexSansArabic,
                    fontSize = 12.sp,
                    color = Color(0x99121212)
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable
private fun TomAccountPreview() {
    TomAndJerryTheme {
        TomAccount(modifier = Modifier.windowInsetsPadding(WindowInsets.safeDrawing))
    }
}