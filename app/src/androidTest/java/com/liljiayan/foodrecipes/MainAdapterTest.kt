package com.liljiayan.foodrecipes

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.liljiayan.foodrecipes.adapter.MainAdapter
import com.liljiayan.foodrecipes.model.ModelMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainAdapterTest {

    private lateinit var mContext: Context

    @Before
    fun setup() {
        mContext = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun testAdapterItemCount() {
        val items = listOf(
            ModelMain("Category 1", "image_url_1"),
            ModelMain("Category 2", "image_url_2"),
            ModelMain("Category 3", "image_url_3")
        )
        val adapter = MainAdapter(mContext, items, null)
        assertEquals(items.size, adapter.itemCount)
    }
}
