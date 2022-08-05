package com.joyy.android_project

import org.junit.Test

import org.junit.Assert.*
import java.lang.StringBuilder

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        var sb = StringBuilder()
        sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        println(sb)
        var codePointCount = sb.codePointCount(0, sb.length)
        println(codePointCount)

        assertEquals(4, 2 + 2)
    }
}