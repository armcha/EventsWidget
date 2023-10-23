package com.example.widgetexample

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.text.TextPaint
import android.util.TypedValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.core.content.res.ResourcesCompat


@Composable
fun Context.textAsBitmap(
    text: String, textSize: Float,
    color: Color = Color.Black,
    letterSpacing: Float = 0.1f,
    font: Int
): Bitmap {
    val paint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    paint.textSize = spToPx(textSize, this)
    paint.color = color.toArgb()
    paint.textAlign = Paint.Align.LEFT
    paint.letterSpacing = letterSpacing
    paint.typeface = ResourcesCompat.getFont(this, font)

    val baseline = -paint.ascent()
    val width = (paint.measureText(text) + 5f).toInt()
    val height = (baseline + paint.descent() + 15f).toInt()
    val image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(image)
    canvas.drawText(text, 0f, baseline + 10f, paint)
    return image
}

@Composable
fun Context.textAsBitmapWithBackground(
    text: String, textSize: Float,
    color: Color = Color.Black,
    backgroundColor: Color = Color.Transparent,
    letterSpacing: Float = 0.15f,
    font: Int
): Bitmap {
    val maxCharCount = 32
    val endChars = "..."
    var textToRender = text
    if (text.length > maxCharCount) {
        textToRender = text.substring(0, maxCharCount) + endChars
    }
    val paint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    paint.textSize = spToPx(textSize, this)
    paint.color = color.toArgb()
    paint.textAlign = Paint.Align.LEFT
    paint.letterSpacing = letterSpacing
    paint.typeface = ResourcesCompat.getFont(this, font)

    val baseline = -paint.ascent()
    val width = (paint.measureText(textToRender) + 40.dp.value.toInt()).toInt()
    val height = (baseline + paint.descent() + 60.dp.value).toInt()
    val image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(image)

    val backgroundPaint = Paint()
    val rect = Rect(0, 0, width, height)
    val rectF = RectF(rect)
    val roundPx = height / 2.7f
    backgroundPaint.isAntiAlias = true
    backgroundPaint.color = backgroundColor.toArgb()
    canvas.drawARGB(0, 0, 0, 0)
    canvas.drawRoundRect(rectF, roundPx, roundPx, backgroundPaint)
    canvas.drawBitmap(image, rect, rect, paint)

    val textHeight = baseline + paint.descent()
    val diff = height - textHeight
    canvas.drawText(textToRender, 20.dp.value, baseline + diff * 0.6f, paint)
    return image
}

fun spToPx(sp: Float, context: Context): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        sp,
        context.resources.displayMetrics
    )
}