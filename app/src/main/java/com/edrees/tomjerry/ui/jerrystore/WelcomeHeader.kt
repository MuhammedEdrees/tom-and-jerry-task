package com.edrees.tomjerry.ui.jerrystore

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edrees.tomjerry.R
import com.edrees.tomjerry.ui.theme.IBMPlexSansArabic
import com.edrees.tomjerry.ui.theme.TomAndJerryTheme


@Composable
fun WelcomeHeader(
    modifier: Modifier = Modifier,
    username: String,
    userAvatarPainter: Painter,
    onNotificationsClicked: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = userAvatarPainter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(12.dp))
                .border(0.5.dp, Color(0x261F1F1E))
        )
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(1f)
        ) {
            Text(
                text = stringResource(R.string.hi_template, username),
                fontFamily = IBMPlexSansArabic,
                fontWeight = FontWeight.W500,
                fontSize = 14.sp,
                lineHeight = 14.sp,
                letterSpacing = 0.sp,
                color = Color(0xFF1F1F1E)
            )
            Text(
                text = stringResource(R.string.which_tom_do_you_want_to_buy),
                fontFamily = IBMPlexSansArabic,
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                lineHeight = 14.sp,
                letterSpacing = 0.sp,
                color = Color(0xFFA5A6A4)
            )
        }
        Box {
            OutlinedIconButton(
                onClick = onNotificationsClicked,
                modifier = Modifier
                    .size(40.dp),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(width = 1.dp, color = Color(0x261F1F1E))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_bell),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
            Badge(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = 1.dp, y = (-4).dp),
                containerColor = Color(0xFF03578A)
            ) {
                Text(
                    text = "3",
                    color = Color.White,
                    fontFamily = IBMPlexSansArabic,
                    fontWeight = FontWeight.W500,
                    fontSize = 10.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomeHeaderPreview() {
    TomAndJerryTheme {
        WelcomeHeader(
            modifier = Modifier.padding(horizontal = 16.dp),
            username = "Jerry",
            userAvatarPainter = painterResource(id = R.drawable.jerry_avatar),
            onNotificationsClicked = {}
        )
    }
}