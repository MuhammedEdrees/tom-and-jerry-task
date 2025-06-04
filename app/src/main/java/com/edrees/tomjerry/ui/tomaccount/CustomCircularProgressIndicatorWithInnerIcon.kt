package com.edrees.tomjerry.ui.tomaccount

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.edrees.tomjerry.R
import com.edrees.tomjerry.ui.theme.TomAndJerryTheme
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CustomCircularProgressIndicatorWithInnerIcon(
    progress: Float,
    painter: Painter,
    modifier: Modifier = Modifier,
    size: Dp = 48.dp,
    strokeWidth: Dp = 4.dp,
    innerIconPadding: Dp = 8.dp,
    progressColor: Color = MaterialTheme.colorScheme.primary,
    backgroundColor: Color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
    iconTint: Color = MaterialTheme.colorScheme.onSurface,
    thumbRadius: Dp = 6.dp
) {
    Box(
        modifier = modifier.size(size),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasSize = this.size
            val radius = (canvasSize.minDimension - thumbRadius.toPx() * 2) / 2
            val center = Offset(canvasSize.width / 2, canvasSize.height / 2)
            
            drawCircle(
                color = backgroundColor,
                radius = radius,
                center = center
            )
            
            val sweepAngle = 360f * progress
            if (sweepAngle > 0) {
                drawArc(
                    color = progressColor,
                    startAngle = -90f,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    size = Size(radius * 2, radius * 2),
                    topLeft = Offset(center.x - radius, center.y - radius),
                    style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
                )
                
                val endAngle = (-90f + sweepAngle) * (PI / 180f)
                val thumbX = center.x + radius * cos(endAngle).toFloat()
                val thumbY = center.y + radius * sin(endAngle).toFloat()
                
                drawCircle(
                    color = progressColor,
                    radius = thumbRadius.toPx(),
                    center = Offset(thumbX, thumbY)
                )
            }
        }
        
        Icon(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.padding(innerIconPadding),
            tint = iconTint
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TestPreview() {
    TomAndJerryTheme {
        CustomCircularProgressIndicatorWithInnerIcon(
            progress = 0.5f,
            painter = painterResource(R.drawable.ic_evil),
            size = 40.dp,
            strokeWidth = 1.dp,
            progressColor = Color.Red,
            backgroundColor = Color.White,
            iconTint = Color.Red,
            thumbRadius = 2.dp

        )
    }
}