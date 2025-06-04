package com.edrees.tomjerry.ui.jerrystore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
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
fun PromotionBanner(modifier: Modifier = Modifier)
{
//    Box(
//        modifier = modifier
//            .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)),
//        contentAlignment = Alignment.BottomEnd
//    ) {
//        Surface(
//            color = Color.Transparent,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(92.dp)
//                .background(
//                    shape = RoundedCornerShape(16.dp),
//                    brush = Brush.linearGradient(
//                        colors = listOf(Color(0xFF03446A), Color(0xFF0685D0)),
//                    )
//                ),
//        ) {
//            Box {
//                Column(
//                    modifier = Modifier
//                        .padding(start = 12.dp, top = 16.dp, bottom = 16.dp)
//                        .align(Alignment.CenterStart),
//                    verticalArrangement = Arrangement.spacedBy(8.dp)
//                ) {
//                    Text(
//                        text = stringResource(R.string.buy_1_tom_and_get_2_for_free),
//                        fontFamily = IBMPlexSansArabic,
//                        fontWeight = FontWeight.W600,
//                        fontSize = 16.sp,
//                        lineHeight = 14.sp,
//                        letterSpacing = 0.sp,
//                        color = Color.White
//                    )
//                    Text(
//                        modifier = Modifier.widthIn(max = 177.dp),
//                        text = stringResource(R.string.adopt_tom_free_fail_free_guarantee),
//                        fontFamily = IBMPlexSansArabic,
//                        fontWeight = FontWeight.W400,
//                        fontSize = 12.sp,
//                        lineHeight = 14.sp,
//                        letterSpacing = 0.sp,
//                        color = Color.White.copy(alpha = 0.8f)
//                    )
//                }
//            }
//            Box {
//                Image(
//                    painter = painterResource(R.drawable.tom_counting_money),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .size(width = 115.38.dp, height = 108.dp)
//                        .align(Alignment.CenterEnd)
//                        .graphicsLayer {
//                            scaleX = 1.36f
//                            scaleY = 1.36f
//                        }
//                        .offset(
//                            y = 7.dp,
//                            x = 14.dp
//                        )
//                )
//            }
//        }
//    }
//}
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)),
        contentAlignment = Alignment.BottomEnd
    ) {
        Surface(
            color = Color.Transparent,
            modifier = Modifier
                .fillMaxWidth()
                .height(92.dp)
                .background(
                    shape = RoundedCornerShape(16.dp),
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF03446A), Color(0xFF0685D0)),
                    )
                ),
        ) {
            Box {
                Column(
                    modifier = Modifier
                        .padding(start = 12.dp, top = 16.dp, bottom = 16.dp)
                        .align(Alignment.CenterStart),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.buy_1_tom_and_get_2_for_free),
//                        fontFamily = IBMPlexSansArabic,
                        fontWeight = FontWeight.W600,
                        fontSize = 16.sp,
                        lineHeight = 14.sp,
                        letterSpacing = 0.sp,
                        color = Color.White
                    )
                    Text(
                        modifier = Modifier.widthIn(max = 177.dp),
                        text = stringResource(R.string.adopt_tom_free_fail_free_guarantee),
//                        fontFamily = IBMPlexSansArabic,
                        fontWeight = FontWeight.W400,
                        fontSize = 12.sp,
                        lineHeight = 14.sp,
                        letterSpacing = 0.sp,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                }
            }
        }
        Box {
            Image(
                painter = painterResource(R.drawable.tom_counting_money),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(width = 115.38.dp, height = 108.dp)
                    .align(Alignment.CenterEnd)
                    .graphicsLayer {
                        scaleX = 1.36f
                        scaleY = 1.36f
                    }
                    .offset(
                        y = (13).dp,
                        x = 15.dp
                    ).drawBehind {
                        drawOval(
                            color = Color.White.copy(alpha = 0.04f),
                            topLeft = Offset(17.dp.toPx(), -15.dp.toPx()),
                            size = Size(
                                width = size.width + 30.dp.toPx(),
                                height = size.height + 30.dp.toPx()
                            )
                        )

                        drawOval(
                            color = Color.White.copy(alpha = 0.04f),
                            topLeft = Offset(22.dp.toPx(), -5.dp.toPx()),
                            size = Size(
                                width = size.width - 5.dp.toPx(),
                                height = size.height + 15.dp.toPx()
                            )
                        )

                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PromotionBannerPreview() {
    TomAndJerryTheme {
        PromotionBanner(modifier = Modifier.padding(horizontal = 16.dp))
    }
}
