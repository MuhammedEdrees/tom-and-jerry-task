package com.edrees.tomjerry.ui.tomkitchen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edrees.tomjerry.ui.theme.IBMPlexSansArabic

@Composable
fun PreparationMethodSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(bottom = 96.dp)
    ) {
        Text(
            text = "Preparation method",
            fontFamily = IBMPlexSansArabic,
            fontSize = 18.sp,
            lineHeight = 32.sp,
            letterSpacing = 0.5.sp
        )
        preparationSteps.forEachIndexed { index, step ->
            PreparationStepItem(
                modifier = Modifier.padding(top = 8.dp),
                stepNumber = index.plus(1),
                stepText = step.description
            )
        }
    }
}