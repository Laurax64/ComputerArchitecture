package com.example.computerarchitecture.ui.screens

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

/**
 * Displays the jump prediction screen with an app scaffold.
 *
 * @param navigateBack The function to navigate back
 * @param modifier The modifier for the layout
 */
@Composable
fun BranchPredictionScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.branch_prediction), navigateBack = navigateBack
            )
        },
    ) { paddingValues ->
        BranchPredictionScreen(
            modifier
                .padding(paddingValues)
                .padding(16.dp)
        )
    }
}


/**
 * Displays the jump prediction screen.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun BranchPredictionScreen(modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        LocalPredictors()
        CorrelatingPredictors()
        TournamentPredictors()
        BranchTargetBuffer()
        ReturnAddressBuffer()
    }
}

/**
 * Displays a card with information about local predictors.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun LocalPredictors(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.local_predictors),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            OneBitPredictors(Modifier.fillMaxWidth())
            TwoBitPredictors(Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun OneBitPredictors(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.one_bit_predictors), fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.one_bit_predictors_description))
        }
    }

}


@Composable
private fun TwoBitPredictors(modifier: Modifier = Modifier) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val graphSize = when (screenWidth) {
        in 0..599 -> 150.dp
        in 600..841 -> 150.dp
        else -> 250.dp
    }
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.two_bit_predictors), fontWeight = FontWeight.Bold
            )
            TwoBitPredictionGraph(
                modifier = Modifier.size(graphSize)
            )

        }
    }
}

/**
 * Displays a moore machine for a two-bit predictor.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun TwoBitPredictionGraph(
    modifier: Modifier = Modifier,
) {
    val circleRadius = 70f
    val circleColor = MaterialTheme.colorScheme.onSurfaceVariant
    val edgeColor = MaterialTheme.colorScheme.onSurface
    val txtColor = MaterialTheme.colorScheme.onSurface.toArgb()
    val txtSize = MaterialTheme.typography.titleLarge.fontSize.value

    val lineStrokeWidth = 4f
    val arrowLength = 20f // Length of the arrowhead
    val arrowAngle = 30f  // Angle of the arrowhead

    Canvas(modifier) {
        // Define positions for each state
        val oneZero = Offset(150f, 100f)
        val oneOne = Offset(350f, 100f)
        val zeroZero = Offset(150f, 300f)
        val zeroOne = Offset(350f, 300f)


        // Draw states
        drawCircle(
            color = circleColor, radius = circleRadius, center = oneZero, style = Stroke(width = 4f)
        )
        drawCircle(
            color = circleColor, radius = circleRadius, center = oneOne, style = Stroke(width = 4f)
        )
        drawCircle(
            color = circleColor,
            radius = circleRadius,
            center = zeroZero,
            style = Stroke(width = 4f)
        )
        drawCircle(
            color = circleColor, radius = circleRadius, center = zeroOne, style = Stroke(width = 4f)
        )

        // Draw state labels
        drawContext.canvas.nativeCanvas.drawText(
            "10",
            oneZero.x - 13,
            oneZero.y - 20,
            Paint().apply {
                textSize = txtSize
                color = txtColor
            })
        drawContext.canvas.nativeCanvas.drawLine(oneZero.x + 70,
            oneZero.y,
            oneZero.x - 70f,
            oneZero.y,
            Paint().apply {
                strokeWidth = 4f
                color = circleColor.toArgb()
            })
        drawContext.canvas.nativeCanvas.drawText(
            "P_T",
            oneZero.x - 13,
            oneZero.y + 40,
            Paint().apply {
                textSize = txtSize
                color = txtColor
            })

        drawContext.canvas.nativeCanvas.drawText("11", oneOne.x - 13, oneOne.y - 20, Paint().apply {
            textSize = txtSize
            color = txtColor
        })
        drawContext.canvas.nativeCanvas.drawLine(oneOne.x + 70,
            oneOne.y,
            oneOne.x - 70f,
            oneOne.y,
            Paint().apply {
                strokeWidth = 4f
                color = circleColor.toArgb()
            })
        drawContext.canvas.nativeCanvas.drawText(
            "P_T",
            oneOne.x - 13,
            oneOne.y + 40,
            Paint().apply {
                textSize = txtSize
                color = txtColor
            })

        drawContext.canvas.nativeCanvas.drawText(
            "00",
            zeroZero.x - 13,
            zeroZero.y - 20,
            Paint().apply {
                textSize = txtSize
                color = txtColor
            })
        drawContext.canvas.nativeCanvas.drawLine(zeroZero.x + 70,
            zeroZero.y,
            zeroZero.x - 70f,
            zeroZero.y,
            Paint().apply {
                strokeWidth = 4f
                color = circleColor.toArgb()
            })
        drawContext.canvas.nativeCanvas.drawText(
            "P_NT",
            zeroZero.x - 30,
            zeroZero.y + 40,
            Paint().apply {
                textSize = txtSize
                color = txtColor
            })

        drawContext.canvas.nativeCanvas.drawText(
            "01",
            zeroOne.x - 13,
            zeroOne.y - 20,
            Paint().apply {
                textSize = txtSize
                color = txtColor
            })
        drawContext.canvas.nativeCanvas.drawLine(zeroOne.x + 70,
            zeroOne.y,
            zeroOne.x - 70f,
            zeroOne.y,
            Paint().apply {
                strokeWidth = 4f
                color = circleColor.toArgb()
            })
        drawContext.canvas.nativeCanvas.drawText(
            "P_NT",
            zeroOne.x - 30,
            zeroOne.y + 40,
            Paint().apply {
                textSize = txtSize
                color = txtColor
            })

        // Draw transitions
        val dashEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
        val stroke = Stroke(
            width = lineStrokeWidth,
            cap = StrokeCap.Round,
            join = StrokeJoin.Round,
            pathEffect = dashEffect
        )
        val strokeWidth = stroke.width

        fun drawArrowLine(start: Offset, end: Offset) {
            drawLine(
                color = edgeColor, start = start, end = end, strokeWidth = strokeWidth
            )
            // Calculate arrowhead points
            val angle = atan2(end.y - start.y, end.x - start.x)
            val arrowPoint1 = Offset(
                end.x - arrowLength * cos(angle - arrowAngle.toRadians()),
                end.y - arrowLength * sin(angle - arrowAngle.toRadians())
            )
            val arrowPoint2 = Offset(
                end.x - arrowLength * cos(angle + arrowAngle.toRadians()),
                end.y - arrowLength * sin(angle + arrowAngle.toRadians())
            )

            // Draw arrowhead
            drawPath(
                path = Path().apply {
                    moveTo(end.x, end.y)
                    lineTo(arrowPoint1.x, arrowPoint1.y)
                    lineTo(arrowPoint2.x, arrowPoint2.y)
                    close()
                }, color = edgeColor
            )
        }

        // 00 to 01
        drawArrowLine(
            Offset(zeroZero.x + 70f, zeroZero.y + 20f), Offset(zeroOne.x - 70f, zeroOne.y + 20f)
        )
        drawContext.canvas.nativeCanvas.drawText(
            "T",
            zeroZero.x + 90,
            zeroOne.y + 50,
            Paint().apply {
                textSize = txtSize
                color = txtColor
            })
        // 01 to 00
        drawArrowLine(
            Offset(zeroOne.x - 70f, zeroOne.y - 20f), Offset(zeroZero.x + 70f, zeroZero.y - 20f)
        )
        drawContext.canvas.nativeCanvas.drawText(
            "NT",
            zeroZero.x + 90,
            zeroZero.y - 50,
            Paint().apply {
                textSize = txtSize
                color = txtColor
            })
        // 01 to 11
        drawArrowLine(
            Offset(zeroOne.x + 20f, zeroOne.y - 70f), Offset(oneOne.x + 20f, oneOne.y + 70f)
        )
        drawContext.canvas.nativeCanvas.drawText(
            "T",
            zeroOne.x + 30,
            oneOne.y + 110,
            Paint().apply {
                textSize = txtSize
                color = txtColor
            })

        // 11 to 10
        drawArrowLine(
            Offset(oneOne.x - 70f, oneOne.y + 20f), Offset(oneZero.x + 70f, oneZero.y + 20f)
        )
        drawContext.canvas.nativeCanvas.drawText(
            "NT",
            oneOne.x - 110,
            oneZero.y + 50,
            Paint().apply {
                textSize = txtSize
                color = txtColor
            })
        // 10 to 11
        drawArrowLine(
            Offset(oneZero.x + 70f, oneZero.y - 20f), Offset(oneOne.x - 70f, oneOne.y - 20f)
        )
        drawContext.canvas.nativeCanvas.drawText("T", oneOne.x - 110, oneOne.y - 30, Paint().apply {
            textSize = txtSize
            color = txtColor
        })
        // 10 to 00
        drawArrowLine(
            Offset(oneZero.x - 20f, oneZero.y + 70f), Offset(zeroZero.x - 20f, zeroZero.y - 70f)
        )
        drawContext.canvas.nativeCanvas.drawText(
            "NT",
            oneZero.x - 55,
            zeroZero.y - 100,
            Paint().apply {
                textSize = txtSize
                color = txtColor
            })
        // 11 to 11
        drawLine(
            color = edgeColor,
            start = Offset(oneOne.x + 70f, oneOne.y + 20f),
            end = Offset(oneOne.x + 140f, oneOne.y + 20f),
            strokeWidth = strokeWidth
        )
        drawLine(
            color = edgeColor,
            start = Offset(oneOne.x + 140f, oneOne.y + 20f),
            end = Offset(oneOne.x + 140f, oneOne.y - 20f),
            strokeWidth = strokeWidth
        )
        drawArrowLine(
            Offset(oneOne.x + 140f, oneOne.y - 20f), Offset(oneOne.x + 70f, oneOne.y - 20f)
        )
        drawContext.canvas.nativeCanvas.drawText("T", oneOne.x + 110, oneOne.y - 30, Paint().apply {
            textSize = txtSize
            color = txtColor
        })

        // 00 to 00
        drawLine(
            color = edgeColor,
            start = Offset(zeroZero.x - 70f, zeroZero.y - 20f),
            end = Offset(zeroZero.x - 140f, zeroZero.y - 20f),
            strokeWidth = strokeWidth
        )
        drawLine(
            color = edgeColor,
            start = Offset(zeroZero.x - 140f, zeroZero.y - 20f),
            end = Offset(zeroZero.x - 140f, zeroZero.y + 20f),
            strokeWidth = strokeWidth
        )
        drawArrowLine(
            start = Offset(zeroZero.x - 140f, zeroZero.y + 20f),
            end = Offset(zeroZero.x - 70f, zeroZero.y + 20f),
        )
        drawContext.canvas.nativeCanvas.drawText(
            "NT",
            oneZero.x - 110,
            zeroZero.y - 30,
            Paint().apply {
                textSize = txtSize
                color = txtColor
            })
    }
}


private fun Float.toRadians(): Float {
    return this * PI.toFloat() / 180f
}


@Composable
private fun NBitPredictors(modifier: Modifier = Modifier) {

}

@Composable
private fun CorrelatingPredictors(modifier: Modifier = Modifier) {

}

@Composable
private fun TournamentPredictors(modifier: Modifier = Modifier) {

}

@Composable
private fun BranchTargetBuffer(modifier: Modifier = Modifier) {

}

@Composable
private fun ReturnAddressBuffer(modifier: Modifier = Modifier) {

}

/**
 * Displays previews for the caching screen.
 */
@PreviewLightDark
@PreviewScreenSizes
@Composable
private fun BranchPredictionScreenPreview() {
    ComputerArchitectureTheme {
        BranchPredictionScreen(
            navigateBack = {},
        )
    }
}
