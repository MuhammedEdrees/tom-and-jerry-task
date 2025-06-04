package com.edrees.tomjerry.ui.tomkitchen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edrees.tomjerry.R
import com.edrees.tomjerry.ui.theme.IBMPlexSansArabic
import com.edrees.tomjerry.ui.theme.TomAndJerryTheme

data class PreparationStep(
    val description: String,
)

val preparationSteps = listOf(
    PreparationStep(
        description = "Put the pasta in a toaster."
    ),
    PreparationStep(
        description = "Pour battery juice over it."
    ),
    PreparationStep(
        description = "Wait for the spark to ignite."
    ),
    PreparationStep(
        description = "Serve with an insulating glove."
    ),
)


@Composable
fun TomKitchen(
    modifier: Modifier = Modifier,
) {
    Box {
        Box(
            modifier = modifier
                .fillMaxSize()
                .clipToBounds()
                .background(Color(0xFFEEF4F6))
                .drawBehind {
                    drawRect(
                        size = size.copy(height = 400.dp.toPx()),
                        color = Color(0x80035484)
                    )
                }
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(id = R.drawable.ellipse3),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .fillMaxWidth(0.52f)
                    .offset(x = -(16).dp, y = (-56).dp)
            )
            Column(
                modifier = Modifier.padding(top = 40.dp, start = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_ruler),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "High tension",
                        fontFamily = IBMPlexSansArabic,
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        color = Color.White.copy(alpha = 0.87f),
                        letterSpacing = 0.5.sp
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_chef),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Shocking foods",
                        fontFamily = IBMPlexSansArabic,
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.5.sp,
                        color = Color.White.copy(alpha = 0.87f),
                    )
                }
            }
            Surface(
                modifier = Modifier
                    .align(
                        Alignment.TopStart
                    )
                    .padding(top = 162.dp)
                    .fillMaxSize(),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                color = Color(0xFFEEF4F6)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(
                            top = 32.dp,
                            bottom = 16.dp,
                            start = 16.dp,
                            end = 16.dp
                        )
                ) {
                    ProductDetailsHeader()
                    ProductDetailsSection(modifier = Modifier.padding(top = 24.dp))
                    PreparationMethodSection(modifier = Modifier.padding(top = 24.dp))
                }
            }
            Image(
                painter = painterResource(R.drawable.delicious_meal),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 18.dp, end = 24.dp)
                    .size(width = 188.dp, height = 168.dp)
            )
        }
        AddToCartBottomBar(modifier = Modifier.align(Alignment.BottomCenter))
    }
}


@Preview(
    showBackground = true,
    device = "spec:width=411dp,height=891dp"
)
@Composable
private fun TomKitchenPreview() {
    TomAndJerryTheme {
        TomKitchen(
            modifier = Modifier.windowInsetsPadding(WindowInsets.safeContent)
        )
    }
}