package com.edrees.tomjerry.ui.jerrystore

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edrees.tomjerry.R
import com.edrees.tomjerry.ui.theme.IBMPlexSansArabic
import com.edrees.tomjerry.ui.theme.TomAndJerryTheme

fun LazyGridScope.cheapTomSection(
    onViewAllClicked: () -> Unit = {},
    tomProducts: List<TomProduct>,
) {
    item(span = { GridItemSpan(maxLineSpan) }) {
        CheapTomListHeader(onViewAllClicked = onViewAllClicked)
    }
    items(
        items = tomProducts
    ) { tomProduct ->
        TomProductItem(
            tomProduct = tomProduct
        )
    }
}

@Composable
private fun CheapTomListHeader(
    modifier: Modifier = Modifier,
    onViewAllClicked: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(R.string.cheap_tom_section),
            fontFamily = IBMPlexSansArabic,
            fontWeight = FontWeight.W600,
            fontSize = 20.sp,
            lineHeight = 14.sp,
            letterSpacing = 0.sp
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = stringResource(R.string.view_all),
                fontFamily = IBMPlexSansArabic,
                fontWeight = FontWeight.W500,
                fontSize = 12.sp,
                lineHeight = 14.sp,
                color = Color(0xFF03578A),
                letterSpacing = 0.sp
            )
            Icon(
                painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = null,
                tint = Color(0xFF03578A),
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(12.dp)
            )
        }
    }
}


@Composable
private fun TomProductItem(
    modifier: Modifier = Modifier,
    tomProduct: TomProduct,
    onAddProductToCart: () -> Unit = {},
    onProductClicked: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .widthIn(max = 160.dp)
            .padding(bottom = 4.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Surface(
            modifier = Modifier.padding(top = 16.dp),
            shape = RoundedCornerShape(16.dp),
            color = Color.White
        ) {
            Column(
                modifier = Modifier.padding(top = 92.dp, start = 8.dp, end = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = tomProduct.title,
                    fontFamily = IBMPlexSansArabic,
                    fontWeight = FontWeight.W600,
                    fontSize = 18.sp,
                    lineHeight = 14.sp,
                    letterSpacing = 0.sp
                )
                Text(
                    modifier = Modifier.height(36.dp),
                    text = tomProduct.description,
                    fontFamily = IBMPlexSansArabic,
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    letterSpacing = 0.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
                Row(
                    modifier = Modifier.padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    ProductPriceLabel(
                        modifier = Modifier.weight(1f),
                        originalPrice = tomProduct.originalNumberOfCheeses,
                        discountedPrice = tomProduct.discountedNumberOfCheeses
                    )
                    OutlinedIconButton(
                        onClick = onAddProductToCart,
                        modifier = Modifier
                            .size(30.dp),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(width = 1.dp, color = Color(0xFF03578A))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_add_to_cart),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }
        Image(
            painter = painterResource(tomProduct.imageRes),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.height(100.dp),
        )
    }
}

@Composable
private fun ProductPriceLabel(
    modifier: Modifier = Modifier,
    originalPrice: Int,
    discountedPrice: Int? = null,
) {
    Surface(
        modifier = modifier
            .height(30.dp),
        shape = RoundedCornerShape(8.dp),
        onClick = { },
        color = Color(0xFFE9F6FB),
        contentColor = Color(0xFF03578A)
    ) {
        Row(
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
                text = buildAnnotatedString {
                    if (discountedPrice != null) {
                        withStyle(
                            style = SpanStyle(
                                textDecoration = TextDecoration.LineThrough,
                                fontFamily = IBMPlexSansArabic,
                                fontWeight = FontWeight.W500,
                                fontSize = 12.sp,
                                letterSpacing = 0.sp
                            )
                        ) {
                            append("$originalPrice ")
                        }
                    }
                    withStyle(
                        style = SpanStyle(
                            fontFamily = IBMPlexSansArabic,
                            fontWeight = FontWeight.W500,
                            fontSize = 12.sp,
                            letterSpacing = 0.sp
                        )
                    ) {
                        append("${discountedPrice?.toString() ?: originalPrice.toString()} cheeses")
                    }
                },
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


@Preview( showBackground = true,)
@Composable
private fun TomProductPreview() {
    TomAndJerryTheme {
        TomProductItem(
            tomProduct = TomProduct(
                id = "TODO()",
                title = "TODO()",
                imageRes = R.drawable.spy_tom,
                description = "TODO()",
                originalNumberOfCheeses = 5,
                discountedNumberOfCheeses = null
            )
        )
    }
}


@Preview(showSystemUi = true, showBackground = true, device = "id:pixel_9_pro")
@Composable
private fun CheapTomSectionPreview() {
    val context = LocalContext.current
    TomAndJerryTheme {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(160.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            cheapTomSection(
                {},
                listOf(
                    TomProduct(
                        title = context.getString(R.string.sport_tom),
                        imageRes = R.drawable.sport_tom,
                        description = context.getString(R.string.sport_tom_description),
                        originalNumberOfCheeses = 5,
                        discountedNumberOfCheeses = 3
                    ),
                    TomProduct(
                        title = context.getString(R.string.tom_the_lover),
                        imageRes = R.drawable.tom_the_lover,
                        description = context.getString(R.string.tom_the_lover_description),
                        originalNumberOfCheeses = 5,
                    ),
                    TomProduct(
                        title = context.getString(R.string.tom_the_bomb),
                        imageRes = R.drawable.tom_the_bomb,
                        description = context.getString(R.string.tom_the_bomb_description),
                        originalNumberOfCheeses = 10,
                    ),
                    TomProduct(
                        title = context.getString(R.string.spy_tom),
                        imageRes = R.drawable.spy_tom,
                        description = context.getString(R.string.spy_tom_description),
                        originalNumberOfCheeses = 12,
                    ),
                    TomProduct(
                        title = context.getString(R.string.frozen_tom),
                        imageRes = R.drawable.frozen_tom,
                        description = context.getString(R.string.frozen_tom_description),
                        originalNumberOfCheeses = 10,
                    ),
                    TomProduct(
                        title = context.getString(R.string.sleeping_tom),
                        imageRes = R.drawable.sleeping_tom,
                        description = context.getString(R.string.sleeping_tom_description),
                        originalNumberOfCheeses = 10,
                    ),
                )
            )
        }
    }
}