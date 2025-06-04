package com.edrees.tomjerry.ui.jerrystore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edrees.tomjerry.R
import com.edrees.tomjerry.ui.theme.TomAndJerryTheme
import java.util.UUID

@Composable
fun JerryStore(modifier: Modifier = Modifier) {
    var query by remember { mutableStateOf("") }
    val nestedScrollConnection = rememberNestedScrollInteropConnection()
    val context = LocalContext.current
    val tomProducts = remember {
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
    }
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 160.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFEEF4F6))
            .then(modifier)
            .nestedScroll(nestedScrollConnection),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(bottom = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        item(span = { GridItemSpan(maxLineSpan) }) {
            WelcomeHeader(
                username = stringResource(R.string.jerry),
                userAvatarPainter = painterResource(R.drawable.jerry_avatar)
            )
        }
        item(span = { GridItemSpan(maxLineSpan) }) {
            SearchBar(
                modifier = Modifier.padding(top = 4.dp),
                query = query,
                onQueryChanged = { query = it },
                placeholder = stringResource(R.string.search_about_tom)
            )
        }
        item(span = { GridItemSpan(maxLineSpan) }) {
            PromotionBanner()
        }
        cheapTomSection(
            tomProducts = tomProducts
        )
    }
}

@Preview(showSystemUi = true, showBackground = true,
    device = "spec:width=411dp,height=891dp"
)
@Composable
private fun JerryStorePreview() {
    TomAndJerryTheme {
        JerryStore(modifier = Modifier.windowInsetsPadding(WindowInsets.safeDrawing).background(
            Color(0xFFEEF4F6)
        ))
    }
}


data class TomProduct(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val imageRes: Int,
    val description: String,
    val originalNumberOfCheeses: Int,
    val discountedNumberOfCheeses: Int? = null,
)