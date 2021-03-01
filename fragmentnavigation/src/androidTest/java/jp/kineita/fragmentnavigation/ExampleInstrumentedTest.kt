/*
 * Written by Lê Trần Ngọc Thành (瑛太 / Ngọc Thành / kineita) <thanhletranngoc@yahoo.co.jp>, [1/3/2021 - Present]
 */

package jp.kineita.fragmentnavigation

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("jp.kineita.fragmentnavigation.test", appContext.packageName)
    }
}