package com.example.librarymanagementsystem

import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration

class touch_Demo(context:Context): View(context) {
    private val STROKE_WIDTH = 12f
    private var path = Path()
    private val drawColor = Color.rgb(254, 149, 52)
    private val backgroundColor = Color.BLACK
    private lateinit var extraCanvas: Canvas
    private lateinit var extraBitmap: Bitmap
    private lateinit var frame : Rect
    private val paint = Paint().apply {
        color = drawColor
        isAntiAlias = true

        style = Paint.Style.STROKE
        strokeWidth = STROKE_WIDTH
    }
    private val touchTolerance = ViewConfiguration.get(context).scaledTouchSlop
    private var currentX = 0f
    private var currentY = 0f
    private var motionTouchEventX = 0f
    private var motionTouchEventY = 0f
    override fun onSizeChanged(width: Int, height: Int, oldwidth: Int, oldheight: Int) {
        super.onSizeChanged(width, height, oldwidth, oldheight)
        extraBitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888)
        extraCanvas = Canvas(extraBitmap)
        extraCanvas.drawColor(backgroundColor)
        val inset = 40
        frame = Rect(inset, inset, width-inset, height-inset)

    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawBitmap(extraBitmap, 0f, 0f, null)
        extraCanvas.drawRect(frame, paint)
    }
    override fun onTouchEvent (event: MotionEvent): Boolean {
        motionTouchEventX = event.x
        motionTouchEventY = event.y
        when (event.action ) {
            MotionEvent.ACTION_DOWN -> touchStart()
            MotionEvent.ACTION_MOVE -> touchMove()
            MotionEvent.ACTION_UP -> touchUp()
        }
        return true
    }

    private fun touchStart () {
        path .reset()
        path .moveTo(motionTouchEventX , motionTouchEventY )
        currentX = motionTouchEventX
        currentY = motionTouchEventY
    }

    private fun touchMove () {
        val dx = Math.abs(motionTouchEventX - currentX )
        val dy =Math.abs(motionTouchEventY - currentY )
        if (dx>=touchTolerance || dy>=touchTolerance ){
            path .quadTo(currentX , currentY ,
                (motionTouchEventX +currentX )/2 ,
                (motionTouchEventY +currentY )/2 ,
            )
            currentX =motionTouchEventX
            currentY =motionTouchEventY
            extraCanvas .drawPath(path , paint )
        }
        invalidate()

    }

    private fun touchUp () {
        path.reset()
    }

}