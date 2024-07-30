package com.example.computerarchitecture.ui.screens.branchprediction

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

/**
 * Displays a card with information about two-bit predictors.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun TwoBitPredictors(modifier: Modifier = Modifier) {
    var showMooreMachine by rememberSaveable { mutableStateOf(false) }
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val graphSize = when (screenWidth) {
        in 0..599 -> 200.dp
        in 600..841 -> 200.dp
        else -> 350.dp
    }
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.two_bit_predictors), fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.two_bit_predictors_description))
            TextButton(onClick = { showMooreMachine = !showMooreMachine }) {
                Text(stringResource(R.string.moore_machine))
            }
        }
        if (showMooreMachine) {
            TwoBitPredictionGraph(
                Modifier
                    .size(graphSize)
                    .background(MaterialTheme.colorScheme.surface)
                    .align(Alignment.CenterHorizontally)
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
private fun TwoBitPredictionGraph(modifier: Modifier = Modifier) {
    val circleRadius = 70f
    val circleColor = MaterialTheme.colorScheme.onSurfaceVariant
    val edgeColor = MaterialTheme.colorScheme.onSurface
    val txtColor = MaterialTheme.colorScheme.onSurface.toArgb()
    val txtSize = MaterialTheme.typography.titleLarge.fontSize.value
    val lineStrokeWidth = 4f
    val arrowLength = 20f
    val arrowAngle = 30f
    Canvas(modifier) {
        val states = listOf(
            Triple("10", statePositions["10"]!!, "P_T"),
            Triple("11", statePositions["11"]!!, "P_T"),
            Triple("00", statePositions["00"]!!, "P_NT"),
            Triple("01", statePositions["01"]!!, "P_NT")
        )

        states.forEach { (state, position, label) ->
            drawState(state, position, label, circleColor, circleRadius, txtSize, txtColor)
        }

        stateDividerPositions.forEach { (start, end) ->
            drawLine(edgeColor, start, end, lineStrokeWidth)
        }

        edges.forEach { transition ->
            drawArrowLine(
                transition.start,
                transition.end,
                transition.label,
                transition.labelPos,
                edgeColor,
                txtSize,
                txtColor,
                lineStrokeWidth,
                arrowLength,
                arrowAngle
            )
        }
    }
}

/**
 * A data class representing a transition in the two-bit predictor graph.
 *
 * @param start The start position of the transition
 * @param end The end position of the transition
 * @param label The label of the transition
 * @param labelPos The position of the label
 */
private data class Transition(
    val start: Offset,
    val end: Offset,
    val label: String,
    val labelPos: Offset
)

/**
 * The positions of the states in the two-bit predictor graph.
 */
private val statePositions = mapOf(
    "10" to Offset(150f, 100f),
    "11" to Offset(350f, 100f),
    "00" to Offset(150f, 300f),
    "01" to Offset(350f, 300f)
)

/**
 * The positions of the divider lines in the two-bit predictor graph.
 */
private val stateDividerPositions = listOf(
    Pair(
        Offset(statePositions["11"]!!.x + 70f, statePositions["11"]!!.y + 20f),
        Offset(statePositions["11"]!!.x + 140f, statePositions["11"]!!.y + 20f)
    ),
    Pair(
        Offset(statePositions["11"]!!.x + 140f, statePositions["11"]!!.y + 20f),
        Offset(statePositions["11"]!!.x + 140f, statePositions["11"]!!.y - 20f)
    ),
    Pair(
        Offset(statePositions["00"]!!.x - 70f, statePositions["00"]!!.y - 20f),
        Offset(statePositions["00"]!!.x - 140f, statePositions["00"]!!.y - 20f)
    ),
    Pair(
        Offset(statePositions["00"]!!.x - 140f, statePositions["00"]!!.y - 20f),
        Offset(statePositions["00"]!!.x - 140f, statePositions["00"]!!.y + 20f)
    )
)

/**
 * The edges between the states in the two-bit predictor graph.
 */
private val edges = listOf(
    Transition(
        start = Offset(statePositions["00"]!!.x + 70f, statePositions["00"]!!.y + 20f),
        end = Offset(statePositions["01"]!!.x - 70f, statePositions["01"]!!.y + 20f),
        label = "T",
        labelPos = Offset(statePositions["00"]!!.x + 90, statePositions["01"]!!.y + 50)
    ),
    Transition(
        start = Offset(statePositions["01"]!!.x - 70f, statePositions["01"]!!.y - 20f),
        end = Offset(statePositions["00"]!!.x + 70f, statePositions["00"]!!.y - 20f),
        label = "NT",
        labelPos = Offset(statePositions["00"]!!.x + 90, statePositions["00"]!!.y - 50)
    ),
    Transition(
        start = Offset(statePositions["01"]!!.x + 20f, statePositions["01"]!!.y - 70f),
        end = Offset(statePositions["11"]!!.x + 20f, statePositions["11"]!!.y + 70f),
        label = "T",
        labelPos = Offset(statePositions["01"]!!.x + 30, statePositions["11"]!!.y + 110)
    ),
    Transition(
        start = Offset(statePositions["11"]!!.x - 70f, statePositions["11"]!!.y + 20f),
        end = Offset(statePositions["10"]!!.x + 70f, statePositions["10"]!!.y + 20f),
        label = "NT",
        labelPos = Offset(statePositions["11"]!!.x - 110, statePositions["10"]!!.y + 50)
    ),
    Transition(
        start = Offset(statePositions["10"]!!.x + 70f, statePositions["10"]!!.y - 20f),
        end = Offset(statePositions["11"]!!.x - 70f, statePositions["11"]!!.y - 20f),
        label = "T",
        labelPos = Offset(statePositions["11"]!!.x - 110, statePositions["11"]!!.y - 30)
    ),
    Transition(
        start = Offset(statePositions["10"]!!.x - 20f, statePositions["10"]!!.y + 70f),
        end = Offset(statePositions["00"]!!.x - 20f, statePositions["00"]!!.y - 70f),
        label = "NT",
        labelPos = Offset(statePositions["10"]!!.x - 55, statePositions["00"]!!.y - 100)
    ),
    Transition(
        start = Offset(statePositions["11"]!!.x + 140f, statePositions["11"]!!.y - 20f),
        end = Offset(statePositions["11"]!!.x + 70f, statePositions["11"]!!.y - 20f),
        label = "T",
        labelPos = Offset(statePositions["11"]!!.x + 110, statePositions["11"]!!.y - 30)
    ),
    Transition(
        start = Offset(statePositions["00"]!!.x - 140f, statePositions["00"]!!.y + 20f),
        end = Offset(statePositions["00"]!!.x - 70f, statePositions["00"]!!.y + 20f),
        label = "NT",
        labelPos = Offset(statePositions["10"]!!.x - 110, statePositions["00"]!!.y - 30)
    )
)

/**
 * Draws a state with a circle and an input and output label.
 *
 * @param state The state to draw
 * @param position The position of the state
 * @param label The label of the state
 * @param circleColor The color of the circle
 * @param circleRadius The radius of the circle
 * @param txtSize The size of the text
 * @param txtColor The color of the text
 */
private fun DrawScope.drawState(
    state: String,
    position: Offset,
    label: String,
    circleColor: Color,
    circleRadius: Float,
    txtSize: Float,
    txtColor: Int
) {
    drawCircle(
        color = circleColor, radius = circleRadius, center = position, style = Stroke(width = 4f)
    )
    drawContext.canvas.nativeCanvas.drawText(
        state,
        position.x - 13,
        position.y - 20,
        Paint().apply {
            textSize = txtSize
            color = txtColor
        })
    drawContext.canvas.nativeCanvas.drawLine(
        position.x + 70,
        position.y,
        position.x - 70f,
        position.y,
        Paint().apply {
            strokeWidth = 4f
            color = circleColor.toArgb()
        })
    drawContext.canvas.nativeCanvas.drawText(
        label,
        position.x - 13,
        position.y + 40,
        Paint().apply {
            textSize = txtSize
            color = txtColor
        })
}

/**
 * Draws an arrow line with a label.
 *
 * @param start The start position of the line
 * @param end The end position of the line
 * @param label The label of the edge
 * @param labelOffset The offset of the label
 * @param edgeColor The color of the edge
 * @param txtSize The size of the text
 * @param txtColor The color of the text
 * @param lineStrokeWidth The width of the line
 * @param arrowLength The length of the arrowhead
 * @param arrowAngle The angle of the arrowhead
 */
private fun DrawScope.drawArrowLine(
    start: Offset,
    end: Offset,
    label: String,
    labelOffset: Offset,
    edgeColor: Color,
    txtSize: Float,
    txtColor: Int,
    lineStrokeWidth: Float,
    arrowLength: Float,
    arrowAngle: Float
) {
    drawLine(color = edgeColor, start = start, end = end, strokeWidth = lineStrokeWidth)
    val angle = atan2(end.y - start.y, end.x - start.x)
    val arrowPoint1 = Offset(
        end.x - arrowLength * cos(angle - arrowAngle.toRadians()),
        end.y - arrowLength * sin(angle - arrowAngle.toRadians())
    )
    val arrowPoint2 = Offset(
        end.x - arrowLength * cos(angle + arrowAngle.toRadians()),
        end.y - arrowLength * sin(angle + arrowAngle.toRadians())
    )
    drawPath(Path().apply {
        moveTo(end.x, end.y)
        lineTo(arrowPoint1.x, arrowPoint1.y)
        lineTo(arrowPoint2.x, arrowPoint2.y)
        close()
    }, color = edgeColor)
    drawContext.canvas.nativeCanvas.drawText(label, labelOffset.x, labelOffset.y, Paint().apply {
        textSize = txtSize
        color = txtColor
    })
}

/**
 * Converts an angle in degrees represented by the Float on which
 * the function is called to an angle in radians.
 *
 * @return The angle in radians
 */
private fun Float.toRadians(): Float {
    return this * PI.toFloat() / 180f
}