package com.example.kotlin

import com.example.kotlin.util.Utils
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleUnitTest {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        var currentDate= Utils.getCurrentTime()
        println(currentDate)
    }
}