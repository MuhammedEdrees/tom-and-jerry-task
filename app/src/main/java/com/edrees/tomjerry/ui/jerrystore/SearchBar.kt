package com.edrees.tomjerry.ui.jerrystore

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edrees.tomjerry.R
import com.edrees.tomjerry.ui.theme.IBMPlexSansArabic
import com.edrees.tomjerry.ui.theme.TomAndJerryTheme

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    placeholder: String,
    query: String,
    onQueryChanged: (String) -> Unit = {},
    onFilterClicked: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row (
            modifier = Modifier
                .weight(1f)
                .background(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFFFFFFFF)
                )
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(24.dp)
            )
            BasicTextFieldWithPlaceholder(
                modifier = Modifier
                    .padding(start = 8.dp),
                value = query,
                onValueChange = onQueryChanged,
                placeholder = placeholder,
                placeholderStyle = LocalTextStyle.current.copy(
                    fontFamily = IBMPlexSansArabic,
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    lineHeight = 14.sp,
                    letterSpacing = 0.sp,
                    color = Color(0xFF969799)
                ),
                textStyle = LocalTextStyle.current.copy(
                    fontFamily = IBMPlexSansArabic,
                    fontSize = 12.sp
                )
            )
        }
        IconButton(
            modifier = Modifier
                .size(48.dp)
                .background(
                    color = Color(0xFF03578A),
                    shape = RoundedCornerShape(12.dp)
                ),
            onClick = onFilterClicked
        ) {
            Image(
                painter = painterResource(R.drawable.ic_filter),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
private fun BasicTextFieldWithPlaceholder(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current,
    placeholderStyle: TextStyle = textStyle.copy(
        color = LocalContentColor.current.copy(alpha = 0.6f)
    )
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = textStyle,
            singleLine = true
        )

        AnimatedVisibility(value.isEmpty()) {
            Text(
                text = placeholder,
                style = placeholderStyle
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun SearchBarPreview() {
    var query by remember{ mutableStateOf("") }
    TomAndJerryTheme {
        SearchBar(
            query = query,
            placeholder = "Search about tom ...",
            onQueryChanged = {query = it},
        )
    }
}