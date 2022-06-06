package com.joyy.android_project

import android.graphics.Outline
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.iv).outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                view?.apply {
                    outline?.apply {
                        outline.setRoundRect(0, 0, view.width, view.height, 10f)
                    }
                }
            }
        }
        findViewById<ImageView>(R.id.iv).clipToOutline = true;

        findViewById<ImageView>(R.id.iv).setOnClickListener {
            var iv: ImageView = it as ImageView
            if (iv.drawable != null) {

            }
        }
    }

//    fun roundCrop(source: Bitmap): Bitmap {
//        val result =
//            Bitmap.createBitmap(source.width, source.height, Bitmap.Config.ARGB_8888)
//        val canvas = Canvas(result)
//        canvas.drawRoundRect(
//            RectF(0f, 0f, source.width.toFloat(), source.height.toFloat()),
//            4f,
//            4f,
//            Paint().apply {
//                isAntiAlias = true
//                shader = BitmapShader(
//                    source,
//                    BitmapShader.TileMode.CLAMP,
//                    BitmapShader.TileMode.CLAMP
//                )
//            }
//        )
//        //paint.setShader(BitmapShader(source))
//        return source
//    }

}