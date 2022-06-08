package com.joyy.android_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * ● android:cardCornerRadius
 * ○ 在xml文件中设置card圆角的大小
 *
 * ● CardView.setRadius
 * ○ 在代码中设置card圆角的大小
 *
 * ● android:cardBackgroundColor
 * ○ 在xml文件中设置card背景颜色
 *
 * ● android:elevation
 * ○ 在xml文件中设置阴影的大小
 *
 * ● card_view:cardElevation
 * ○ 在xml文件中设置阴影的大小
 *
 * ● card_view:cardMaxElevation
 * ○ 在xml文件中设置阴影最大高度
 *
 * ● card_view:cardCornerRadius
 * ○ 在xml文件中设置卡片的圆角大小
 *
 * ● card_view:contentPadding
 * ○ 在xml文件中设置卡片内容于边距的间隔
 *
 * ● card_view:contentPaddingBottom
 * ○ 在xml文件中设置卡片内容于下边距的间隔
 *
 * ● card_view:contentPaddingTop
 * ○ 在xml文件中设置卡片内容于上边距的间隔
 *
 * ● card_view:contentPaddingLeft
 * ○ 在xml文件中设置卡片内容于左边距的间隔
 *
 * ● card_view:contentPaddingRight
 * ○ 在xml文件中设置卡片内容于右边距的间隔
 *
 * ● card_view:contentPaddingStart
 * ○ 在xml文件中设置卡片内容于边距的间隔起始
 *
 * ● card_view:contentPaddingEnd
 * ○ 在xml文件中设置卡片内容于边距的间隔终止
 *
 * ● card_view:cardUseCompatPadding
 * ○ 在xml文件中设置内边距，V21+的版本和之前的版本仍旧具有一样的计算方式
 *
 * ● card_view:cardPreventCornerOverlap
 * ○ 在xml文件中设置内边距，在V20和之前的版本中添加内边距，这个属性为了防止内容和边角的重叠
 *
 * https://www.freesion.com/article/1496763209/
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}